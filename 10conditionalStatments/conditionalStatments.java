import java.util.*;

public class conditionalStatments {

    public static void main(String[] args) {
        int a=-4;

        //if-else condition 
        if(a>0){
            System.out.println("a is a positive number");
        }else{
            System.out.println("a is a negative number");
        }


        //else if
        Scanner sc = new Scanner(System.in);
        System.out.println("enter gender of the candidate");
        String b= sc.nextLine();

            // if(b=="male"){ 
            //     System.out.println("MALE");
            // }else if(b=="female"){
            //     System.out.println("FEMALE");
            // }else{
            //     System.out.println("others");
            // }//ERROR CODE
            
            //always attracts else {} 
            //reason String is non-primative ----and == compares memory reference
            //so for String we use b.equals() or b.equalsIgnoreCase()

        
            if(b.equalsIgnoreCase("male")){ 
                System.out.println("MALE");
            }else if(b.equalsIgnoreCase("female")){
                System.out.println("FEMALE");
            }else{
                System.out.println("others");
            }

        //ternary operator
        int x=4, y=5;
        boolean larger = (x > y)?true:false;

        System.out.println(larger);


        //Switch operator
        switch(4){
            case 4: System.out.println("hey i am 4");
            break;
            case 2: System.out.println("hey i am case 2");
            break;
            default: System.out.println("Sorry wrong case chosen"); 
        }
    }
    
}
