
public class functions {

    //creating f(x)
    public static void printHello(){
        System.out.println("Hello");

    }
    public static void main(String []args){
        //calling f(x)
        //printHello();

        //check if a given num is prime
        //note:  i<Math.sqrt(num)----------more efficient than num/2
        int num = 7;
        boolean isPrime= true;

        if(num<=1){
            isPrime = false;
        }else{
            for(int i=2; i<Math.sqrt(num); i++){
                if (num %i==0){
                    isPrime = false;
                    break;
                }
            }
        }

        System.out.println(isPrime);

        //-----------------------------------------------------------------------------
        //conversion of binary to decimal
        int binaryNum   = 1010;
        int decimalVal = 0;

        int power = 1;

        while(binaryNum >0){
            int lastDigit = binaryNum % 10;
            
            //updating decimal val
            decimalVal = decimalVal + lastDigit*power;
            
            //upating power
            power *=2;

            //updating binaryNum
            binaryNum = binaryNum /10;
        }
        System.out.println(decimalVal);





        //conversion of decimal to binary
        int decNum= 10;
        String binary = "";

  

        while(decNum >0){
            //updating binary
            binary = decNum %2 + binary;

            //updating decNum
            decNum = decNum/2;
        }

        System.out.println(binary);

    }    
}
