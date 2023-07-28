package homework.hw7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		try {
			FileInputStream fis = new FileInputStream(origin);
			BufferedInputStream bis = new BufferedInputStream(fis);
			FileOutputStream fos  = new FileOutputStream(copy);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			int c;
			
			while ((c = fis.read()) != -1) {
				fos.write(c);
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
	
	
	
	// Q5 
	public void objectPersistenceImprove() throws Exception {
		Cat c1 = new Cat("Ian");
		Cat c2 = new Cat("Josh");
		Dog d1 = new Dog("Alicia");
		Dog d2 = new Dog("Jane");
		
		File dir = new File("C:\\data");
		dir.mkdir();
		File file = new File("C:\\data\\Object.ser");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(c1);
		oos.writeObject(c2);
		oos.writeObject(d1);
		oos.writeObject(d2);
		
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		System.out.println(file.getName() + "檔案內容如下: ");
		System.out.println("--------------------");
		try {
			while (true) {
				Object o = ois.readObject();
				((Cutie) o).speak();
				System.out.println("--------------------");
			}
		} catch (EOFException e) {
			System.out.println("資料讀取完畢！");
		}
		ois.close();
		fis.close();
	}	
	
}
