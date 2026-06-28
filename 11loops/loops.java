
public class loops {

    public static void main(String[] args) {
        // //for loop
        // for (int i = 0; i <= 5; i++) {
        //     System.out.println(i);
        // };

        // //while loop
        // int j = 100;
        // while (j > 90) {
        //     System.out.println(j);
        //     j--;
        // };
        // // //do-while loop
        // int x = 3;
        // do {
        //     System.out.println(x);
        //     x--;
        // } while (x >= 0);
        // //break and continue keywords
        // //break-----to break the flow of code 
        // //continue--to skip a particular event
        // for (int ab = 0; ab <= 5; ab++) {
        //     if (ab == 2) {
        //         // break;
        //         continue;
        //     }
        //     System.out.println("ab is " + ab);
        // }

        
        //reverse of a number---using String
        int i = 123;
        String str = "";

        while (i > 0) {
            int j = i % 10;
            str += j;
            //System.out.println(str);
            i = i / 10;
        }
        System.out.println(str);

        //reverse of a number without using String 
        int num = -12345;
        int reverse = 0;

        int temp = Math.abs(num);

        while (temp > 0) {
            int lastDigit = temp % 10;
            reverse = reverse * 10 + lastDigit;
            temp = temp / 10;
        }
        System.out.println(reverse);

    }

}
