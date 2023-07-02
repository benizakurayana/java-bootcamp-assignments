package myPractice;
public class HiWorld {
    public static void main(String[] args) {
         int returnA = HelloWorld.main(1);
         System.out.println(returnA + "\n");

         int returnB = HelloWorld.main(1, 2, 3);
         System.out.println(returnB + "\n");

         int returnC = HelloWorld.main(1, 2);
         System.out.println(returnC + "\n");

         int returnD = HelloWorld.main("ABC");
         System.out.println(returnD + "\n");
       
    }

}