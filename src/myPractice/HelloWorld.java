package myPractice;
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello World");
        System.out.println("哈囉");
    }

    public static int main(int x) {
        System.out.println("Parameters: int x");
	return 87;
    }

    public static int main(int... args) {
        System.out.println("Parameters: int... args");
	return 88;
    }

   public static int main(int a, int b) {
        System.out.println("Parameters: int a, int b");
	return 89;
   }

   public static int main(String a) {
        System.out.println("Parameters: String a");
	return 90;
    }
}