
public class polymorphism {

    public static void main(String[] args) {

        //METHOD-OVERLOADING
        //creating instace of Calculator class
        Calculator cal = new Calculator();

        //accesssing Calculator functions with its instance-----same funciton name diff parameters --METHOD OVERLOADING
        System.out.println(cal.sum(1, 2));
        System.out.println(cal.sum(2.5f, 3.5f));
        System.out.println(cal.sum(1, 2, 3));

        //METHOD-OVERRIDDING
        //creating instance of Deer and accessing a f(x)/method with same name---
        Deer d = new Deer();

        d.eat();//----method of deer is overrided /considered over parent Animal

    }
}

//creating a class Calculator and multiple functions with same name and differetn parameters---types and count 
class Calculator {

    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

class Animal {

    void eat() {
        System.out.println("Animal eats");
    }
}

class Deer extends Animal {

    void eat() {
        System.out.println("Deer eats");
    }
}

//there are 2 types of polymorphism
//1. compile time polymorphism-----.methodOverloading
//2. run time polymorphism---------.methodOverridding
//methodOverloading---Multiple funcitons with different parameters----parameters base on type and count


//methodOverridding---------------------------------------------------------------------------------------------------
//PARENT/BASE CLASSS------CHILD/DERIVED CLASS
//when both parent and child classes have f(x)/ method of same name-----and if object of child class access such f(x)
//1st priority is given to clild class f(x) and not parent class f(x)----this is call METHOD OVERRIDDING


//-------------------------------------------------------------------------------------------------------------------
//Packages in java
//packages are group of similar type of classes, interfaces and sub-packages
//They 2 tpes of packages --user defined  and built-in packages 
//why packages are usefull
//REFER---referencePDF


//user defined package
// S1: CREATING PACKAGE
// package mypack;

// public class Student {
//     public void show() {
//         System.out.println("Hello from Student class");
//     }
// }
//NOTE:package statement must be the first line.


//S2: COMPILE
//javac -d . Student.java

//This creates folder
//mypack/Student.class


//s3: How to use package
//import single class
//import mypack.Student;

//import all classes
//import mypack;


//----------------------
// imp things to note about packages 
// ✔ Package statement must be first line
// ✔ One file → one package
// ✔ Class can be accessed using import
// ✔ Packages help in data hiding




