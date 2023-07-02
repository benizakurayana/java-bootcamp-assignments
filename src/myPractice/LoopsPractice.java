package myPractice;
public class LoopsPractice {
	public static void main(String[] args) {
        // for loop
        int sum1 = 0;
        for (int i = 1; i < 11; i++) {
            sum1 += i;
        }
        System.out.println(sum1);
     
        // while loop
        int sum2 = 0;
        int j = 1;
        while (j < 11) {
            sum2 += j;
            j++;
        }
        System.out.println(sum2);    
       
        // do while loop
        int sum3 = 0;
        int k = 1;
        do {
            sum3 += k;
            k++;
        } while (k < 11);
        System.out.println(sum3);
    }
}