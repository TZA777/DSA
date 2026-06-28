import java.util.*;


public class dataTypes {


    public static void main(String[] args) {
        //creating Scanner instance
        Scanner sc = new Scanner(System.in);

        //input
        //int
        System.out.println("enter a number");
        int a = sc.nextInt();
       
        // to read nextLine
        sc.nextLine();  //consumes nexLine ...very imp when nextLine() is used to take a name as input

        //string
        System.out.println("enter your name");
        String name = sc.nextLine();

        //output
        System.out.println(a);
        System.out.println(name);


        //Type conversion
        int x = 10;
        float y= x;

        System.out.println(y);

        //here x is int type , when tried to stroe in float no error
        //reason float is higher dataType and it accomidates int -----reverse results in error

        //Type Casting
        //int z = y; ---gives error
        //when ever we ask system to store higher dataType in lower dataType---here float into int---in insit system to compromise
        //note: during type casting---data loss may happen

        int z = (int)y;
        System.out.println(z);

        //Type Promotion
        double ab = a + x *y;
        System.out.println(ab);
        System.out.println(((Object)ab).getClass().getName()); // to know the datatype of a primitive data-type

        //Note during if we want to store result in lower data-type we have to use type casting
        int abc = (int)ab; //gives error if not casted

        System.out.println(abc);
        System.out.println(((Object)abc).getClass().getName());
        
        
    }
    
}
