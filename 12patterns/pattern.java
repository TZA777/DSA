public class pattern{
    public static void main (String[]args){
        System.out.println("Hello");

        // //squate pattern
        // for (int i=1; i<=5; i++){
        //     for(int j=1; j<=5; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // //right tringle pattern 
        // for (int i=1; i<=5; i++){
        //     for(int j=1; j<=i; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // //inverted tringle pattern
        // for(int i=5; i>=1; i--){
        //     for(int j=1; j<=i; j++){
        //         System.out.print("* ");
        //     }
        //     System.out.println();
        // }

        // //Pyramid
        // int n =5;
        // for (int i = 1; i<=n; i++){

        //     //spaces
        //     for(int j= i; j<n; j++){
        //         System.out.print(" ");
        //     }

        //     //stars
        //     for(int k = 1; k <= (2*i-1); k++){
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        //Diamond Pattern
        int n =5;

        //upper half
        for (int i = 1; i<=n; i++){
            //spaces
            for(int j= i; j<n; j++){
                System.out.print(" ");
            }
            //stars
            for(int k = 1; k <= (2*i-1); k++){
                System.out.print("*");
            }
            System.out.println();
        }

        //lower half
        for(int i=n-1; i>=1; i--){
            //spaces
            for ( int j=i; j<n; j++){
                System.out.print(" ");
            }
            //stars
            for(int k= 1; k<= (2*i-1); k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}