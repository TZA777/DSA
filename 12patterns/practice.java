
public class practice {

    public static void main(String[] args) {

        //square pattern
        // for(int i = 0; i<5; i++){
        //     for(int j =0; j<5; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println("");
        // }
        //----------------------------------------------------------------------------------------
        // //right angle pattern-left alinged 
        // for (int i = 1; i <= 5; i++) {
        //     int start = i;
        //     for (int j = 1; j <= 5; j++) {
        //         while (start > 0) {
        //             System.out.print("* ");
        //             start--;
        //         }
        //     }
        //     System.out.println("");
        // }
        //-----------------------------------------------------------------------------------------
        //right angled tringle-right alinged 
        // int n = 5;
        // for (int i = 1; i <= n; i++) {
        //     //print spaces
        //     for(int space= n-i; space>0; space--){
        //         System.out.print("  ");
        //     }
        //     //print stars
        //     for( int star= 1; star<=i; star++){
        //         System.out.print("* ");
        //     } 
        //     System.out.println("");
        // }
        //-----------------------------------------------------------------------------------
        // //inverted right angle tringle-right alinged 
        // int n=5;
        // for(int i=0; i<5; i++){
        //     //spaces
        //     for(int j=i; j>0; j--){
        //         System.out.print("  "); //2 spaces to make star and space
        //     }
        //     //stars
        //     for(int k= n-i; k>0; k--){
        //         System.out.print("* ");
        //     }
        //     System.out.println("");
        // }
        //--------------------------------------------------------------------------------------
        // //inverted right angle tringle-left alined 
        // for( int i =5; i>0; i--){
        //     int star = i;
        //     for(int j=star; star>0; star--){
        //         System.out.print("* ");
        //     }
        //     System.out.println("");
        // }    
        //--------------------------------------------------------------------------------------
        //hollow square
        //     for (int i = 1; i <= 5; i++) {
        //         for (int j = 1; j <= 5; j++) {
        //             if (i == 1 || i == 5 || j == 1 || j == 5) {
        //                 System.out.print("* ");
        //             } else {
        //                 System.out.print("  ");
        //             }
        //         }
        //         System.out.println("");
        //     }
        //---------------------------------------------------------------------------------------
        // //diagnol in a square
        // for (int i=1; i<=5; i++){
        //     for(int j=1; j<=5; j++){
        //         //primary diagnol
        //         if(i==j || i+j==6 ){
        //             System.out.print("*");
        //         }
        //         System.out.print(" ");
        //     }
        //     System.out.println("");
        // }
        //----------------------------------------------------------------------------------------
        //right angled tringle with numbers
        // for (int i = 0; i < 5; i++) {
        //     for (int j = 1; j <= i+1; j++) {
        //         int idx = j;
        //         System.out.print(idx);
        //     }
        //     System.out.println("");
        // }
        //----------------------------------------------------------------------------------------
        //right angled tringle with continues numbers
        int start =1;
        for (int i = 0; i < 5; i++) {
            
            for (int j = 1; j <= i + 1; j++) {
            
                System.out.print(start+ " ");
                start++;
            }
            System.out.println("");
        }
    }
}
