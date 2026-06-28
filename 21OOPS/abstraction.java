
public class abstraction {

    public static void main(String[] args) {

        //instance of horse and chicken are created
        Horse h = new Horse();
        Chicken ch = new Chicken();

        //accessing methods of self and parent
        h.eat();
        h.walk();

        ch.eat();
        ch.walk();

        //NOTE: for walk(); nothing is defined in parent----but gave an idea that every sub-class should have--- walk method  else results in error

        //3.
        //in parent color is set to brown using Animal constructor Animal()
        //this acts as default color of all children unless altered
        System.out.println(h.color);  //color before alteration ----default color
        h.changeColor();              //invoking change color method 
        System.out.println(h.color); //check for updated color

    }
}

//creating abstract class of animal 
abstract class Animal {

    //1.non-abstract method
    void eat() {
        System.out.println("Animal eats");
    }

    //1.abstract method
    abstract void walk();

    //3.can have constructors--and automatically called at the time of creation of instace of parent of childern
    String color;
    Animal(){
        color="brown";  //default color
        System.out.println("animal constructor called ");
     }
}

//Horse class derived from Animal
class Horse extends Animal {

    void walk() {
        System.out.println("Walks on 4 legs");
    }

    void changeColor(){
        color="dark brown";
    }
}

//Chicken class derived from Animal
class Chicken extends Animal {

    void walk() {
        System.out.println("Walks on 4 legs");
    }
}

//Abstract classes---Hidding all unnecessary details and showing only required info to users
//Abstract classes---will give an idea and not implementation of the same
//important things about abstract
//1. cannot have instance of abstract classes
//2. can have abstract/non-abstract methods
//3. can hava constructors

//Note: Animal constructor---ie,  abstract class animal constructor is called at the time of creating insatace of defived classes
