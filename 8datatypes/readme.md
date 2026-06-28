install JDK---refer Installation Resources PDF

1. creaeting a java file-----file with name .java
2. Boilerplate Code + Compilation

    Boilerplate code

    public class JavaBasics{
        public static void main (String[]args){
            System.out.println("Hello");
        }
    }

    Compilation
        Step1: javac JavaBasics.java
        Step2: java JavaBasics.java

3. Variables in Java
    a = 10;
    b = 5;

    2*(a+b)

    here 
    a, b are variables
    2 is number literals

4. Data Types in java
    Refer Picture folder

    apart from Data type we can segregrate according to category----Refer Picture folder (Non-Primitive Datatypes)

5. Comments in Java

    // for single line comment 
    /* for group fo lines */

6. Input in Java
    s1: importing util package-------import java.util.*;
    s2: creating scanner object sc---Scanner sc = new Scanner(System.in);
    s3: use sc--scanner object to take an input


7. Type Conversion
    Conversion happens when 
    a. Type Compatiable
    b. Destination > Source

    byte--->short--->int--->float--->long--->double

    int num = sc.nextFloat();   WRONG R: float is higher to int so it can not be stored in int
    float  num = sc.nextInt();  WORKS

8. Type Casting
    When we insist the system to convert data to lower data type even there is loss of data
    eg: int----->float

    formate: 
    int a = (int)35.5f;
    System.out.println(a);

9. Type promotion in Expression -----Automatically done in java


        byte b = 10;
        int i = 20;
        double d = 5.5; 

        double result = b + i + d;  // all promoted to double as double is larger dataType
        System.out.println("Result: " + result);

        note: if we want the promoted value---here its double---in lower dataType like int Type Casting is needed





