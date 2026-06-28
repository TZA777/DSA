
public class strings {

    public static void main(String[] args) {
        //1.charactor array 
        char[] arr = {'a', 'b', 'c', 'd'};

        //2.string using string class
        String str = "abcd";

        //3.string length()
        str.length();

        //4.string concatination
        String firstName = "Divya";
        String lastName = "Teja";
        String fullName = firstName + lastName;

        //5.string charAt()
        System.out.println(fullName.charAt(0));

        //6.string function compare
        String t1 = "Tony";
        String t2 = "Tony"; //t1 and t2 shares same memory

        String t3 = new String("Tony"); //t3 creates new memory

        if (t1 == t2) {  //equal R: shares same memory
            System.out.println("Strings are equals");
        } else {
            System.out.println("String are not equal");
        }

        if (t1 == t3) { //not equal R:new memory is created
            System.out.println("Strings are equals");
        } else {
            System.out.println("String are not equal");
        }

        //if we want to compare only values ----.equals()----result will be equal R: .equals()
        if (t1.equals(t3)) {
            System.out.println("Strings are equals");
        } else {
            System.out.println("Strings are not equal");
        }

        //compareToIgnoreCase() is a String method that compares two strings lexicographically,
        //ignoring uppercase and lowercase differences.

        //eg: str1.compareToIgnoreCase(str2);

        //7.why string are immutable----R: every time when string is muated ---a new string is created in Heap(Storage)
        //to solve thsi problem----we come up with STRING BUILDER----which is mutable 

        //8.String Builder
        StringBuilder sb = new StringBuilder();

        //using string builder object we can perform many functions
        // sb.append("hello"); 
        // sb.insert(si, "value");
        // sb.replace(si,'value');
        // sb.delete(si,ei);
        // sb.reverese();
        // sb.charAt(idx);
        // sb.length();
        // sb.substring(si,ei);

        // sb.toString(); //StringBuilder is an object type, so to convert into string we use .toString()
    }

    //9. STRING BUFFER---String Builder is NOT THREAD SAFE ie,. when huge data is handled ----there could be some missing of data
    // in order to make things THREAD SAFE---we use STRING BUFFER

    //all methods are similar to sting builder
    

    //FEATURES for String, Sting Builder, String Buffer----check in notes
    //Mutability
    //Thread safe
    //Preformance
    //Storage
    //Use case
}

//problem set
//Palindrome---racecar
//Shortest Path---WNEEENESENNNN-----length of hypotenuse
//Print largest string------String fruits[]= {"apple", "banana", "mango"};---HINT: str1.compareTo(str2);
//for a given string convert 1st letter of each word to Uppercase STRING = "Hey this is teja and hope people are doing good"
//String comparision------input STRING = "aaabbcccdd"; -----required OUTPUT = a3b2c3d2;

 

