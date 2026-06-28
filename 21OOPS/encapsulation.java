
public class encapsulation {

    public static void main(String[] args) {

        //creating instance---with an arguemnt name
        Pen p1 = new Pen("Parker");

        //System.out.println(p1.name);//check

        //creating Address instace / object
        Address a1 = new Address();
        a1.city= "Hyderabad";
        

        //creating an instance of Student and passing name and address
        Student s1 = new Student("teja", 22, a1);
        Student s2 = new Student(s1);

        s2.name = "rahul";

        System.out.println(s1.name);
        System.out.println(s2.name); //will print updated name
        System.err.println(s1.name); //s2 gets seperate copy so s1 name is not altered R: primative data types and immutable data types gets new memory---But objects---REFERENCES is passed 

        System.out.println(s2.age); //s2 will take default value of s1---R: copy constructor

        //for address things are different R: muttable data type and reference is passed
        System.out.println(s1.city.city);

        //updte address for s2
        s2.city.city = "Bangalore";

        //check for s1 and s2--address will be the same R: same memory is shared
        System.out.println(s2.city.city); //Bangalore---updted address
        System.out.println(s1.city.city); //should print Hyderabad but prints Bangalore---R: Shallow copy---for objects REFERENCE----same memory is shared


        // DEEP COPY ---- in while copy Student object-----where ever there are muttable data types ----like ADDRESS here
        //we create a new instance of the same and update that field

     
    }
}

//creating Pen class
class Pen {

    String name;
    int tip;

    //case-1---calling constructor(NON PARAMITARIZED)
    Pen() {
        System.out.println("constructor is called");
    }

    //case-2--- (PARAMITARIZED CONSTRUCTOR)
    Pen(String name) {
        this.name = name;
    }

    //case-3---copy constructor
    //Student class
}

//creting Address class
class Address {
    String city;
}

//creating Student class
class Student {

    String name;
    int age;
    Address city;

    //normal constructor
    Student(String name, int age, Address city) {

        this.name = name;
        this.age = age;
        this.city = city;
    }

    // //shallow copy constructor
    // Student(Student s) {
    //     this.name = s.name;
    //     this.age = s.age;  
    //     this.city= s.city;//SHALLOW COPY---same reference---both objects share same memory
    // }

    //deep copy constructor
    Student(Student d){
        this.name = d.name;
        this.age = d.age;
        this.city = new Address();  //new adderess is created 
        this.city.city = d.city.city;  //and updted
    }
}

//Encapsulation is defined as the wrapping up of data and method under a single unit
//It also impements data hiding----private/punlic/protected-------------------------------------------------


//Constructors
//Constructors are special methods which is invoked automatically a the time of object cretion
//Pen p1 = new Pen();
//Key points:
//constructors have same name of class or structure
//They dont have return type---not even void
//Constructors are called only once(At the time of object creation)
//Memory allocation happens when constructor is called
// 
//Types of constructors 1. PARAMETERIZED  2. NON-PARAMETERIZED  3. COPY CONSTRUCTOR ---

//copy constructors are futher divided into 
// 3.1 shollow copy constructor and 3.2 hollow copy constructor-----------------------------------------------------

//DESTRUCTORS
//In C++ we have special f(x) for delecting the memory of the object
//In java we have garbage collectors for delectign, it is done automatically 

//NEXT INHERITANCE

