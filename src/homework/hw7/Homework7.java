package homework.hw7;
// File
import java.io.File;
// Input
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.ObjectInputStream;
// Output
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.ObjectOutputStream;
// Exception
import java.io.EOFException;
import java.io.IOException;

public class Homework7 {
	public static void main(String[] args) throws Exception{
		Homework7 hw7 = new Homework7();
		// Q1
		hw7.loadSampleTxt("src\\homework\\hw7\\Sample.txt");
		// Q2
		hw7.randomNumLog("src\\homework\\hw7\\Data.txt");
		// Q3
		hw7.copyFile(new File("src\\homework\\hw7\\Hyejin.png"), new File("src\\homework\\hw7\\Hyejin_copy.png"));
		// Q4
		hw7.objectPersistence();
		// Q5
		hw7.objectPersistenceImprove();
	}

	// Q1
	public void loadSampleTxt(String filepath) {
		/**
		 * Reads a specified text file and prints out its file size, number of characters and
		 * lines.
		 * @param filepath path of the specified text file.
		 */
		try {
			File myFile = new File(filepath);
			FileReader fr = new FileReader(myFile);
			BufferedReader br = new BufferedReader(fr);

			// Count characters
			int charCount = 0;
			while ((br.read()) != -1) {
				charCount += 1;
			}
			br.close();
			fr.close();

			// Count lines
			BufferedReader br2 = new BufferedReader(new FileReader(myFile));
			int lineCount = 0;
			while ((br2.readLine()) != null) {
				lineCount += 1;
			}

			System.out.printf("%s檔案共有%d個位元組, %d個字元, %d列資料", myFile.getName(), myFile.length(), charCount, lineCount);

			br2.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	// Q2
	public void randomNumLog(String filepath) {
		/**
		 * Generates 10 random numbers between 1 and 1000 and appends them to a specified file.
		 * Each time this method is called, it will add the generated numbers to the end of the file 
		 * without overwriting any previously generated numbers.
		 * @param filepath path of the specified text file.
		 */
		try {
			FileWriter fw = new FileWriter(filepath, true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);

			for (int i = 0; i < 10; i++) {
				int randomNum = (int) (Math.random() * 1000) + 1;
				pw.print(randomNum + "\t");
			}
			pw.println();

			pw.close();
			bw.close();
			fw.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	// Q3
	public void copyFile(File origin, File copy) {
		/**
		 * Copies a specified file to another file.
		 * @param origin the source file.
		 * @param copy the destination file. 
		 */
		try {
			FileInputStream fis = new FileInputStream(origin);
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos  = new FileOutputStream(copy);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int c;
			
			while ((c = fis.read()) != -1) {  // Use c to store the next byte of data when invoking fis.read(),
				fos.write(c);                 // because each time fis.read() is invoked, the pointer will move to the next byte.
			}
			bis.close();
			fis.close();
			bos.close();
			fos.close();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	
	// Q4
	public void objectPersistence() {
		/**
		 * Creates two objects of each Cat and Dog classes, write them to a .ser file,
		 * and read them to invoke speak() method. 
		 */
		Cat c1 = new Cat("Ian");
		Cat c2 = new Cat("Josh");
		Dog d1 = new Dog("Alicia");
		Dog d2 = new Dog("Jane");
		
		try {
			// Make directory C:\data.
			File dir = new File("C:\\data\\");
			dir.mkdir();
		
			// Output
			FileOutputStream fos = new FileOutputStream("C:\\data\\Object.ser");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(c1);
			oos.writeObject(c1);
			oos.writeObject(d1);
			oos.writeObject(d2);
			
			oos.close();
			bos.close();
			fos.close();
			
			// Input
			FileInputStream fis = new FileInputStream("C:\\data\\Object.ser");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			Object o;
			while((o = ois.readObject()) != null) {  // Need to type cast in order to use speak() method.
				if (o instanceof Cat) {
					((Cat)o).speak();
				} else if (o instanceof Dog) {
					((Dog)o).speak();
				}

			}
			
			ois.close();
			bis.close();
			fis.close();	
		} catch (IOException e) {
			System.out.println("資料讀取完畢");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	// Q5 
	public void objectPersistenceImprove() throws Exception {
		/**
		 * A improved version of objectPersistence() method by the application of polymorphism. 
		 */
		Cutie c1 = new Cat("Ian");
		Cutie c2 = new Cat("Josh");
		Cutie d1 = new Dog("Alicia");
		Cutie d2 = new Dog("Jane");
		
		try {
			// Make directory C:\data.
			File dir = new File("C:\\data\\");
			dir.mkdir();
		
			// Output
			FileOutputStream fos = new FileOutputStream("C:\\data\\Object.ser");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			oos.writeObject(c1);
			oos.writeObject(c1);
			oos.writeObject(d1);
			oos.writeObject(d2);
			
			oos.close();
			bos.close();
			fos.close();
			
			// Input
			FileInputStream fis = new FileInputStream("C:\\data\\Object.ser");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			Cutie o;  
			while((o = (Cutie)ois.readObject()) != null) {
					o.speak();  // Both Cat and Dog classes implement Cutie interface. No need to type cast.
			}
			
			ois.close();
			bis.close();
			fis.close();	
		} catch (IOException e) {
			System.out.println("資料讀取完畢");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
