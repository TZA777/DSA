
public class oops {

    public static void main(String[] args) {

        //creating an instance of pen
        Pen p1 = new Pen();

        //setter function
        p1.setColor("blue");
        p1.setTip(5);

        p1.color = "yellow";  //direct access
        System.out.println(p1.color);

        //getter function 
        System.out.println(p1.getColor());

    }
}

//NOTE:
// main() is static
// Pen is a non-static inner class
// A non-static inner class needs an object of outer class

//creating pen blueprint
class Pen {

    //properties
    String color;
    int tip;

    //function to getColor------------getters
    String getColor(){
        return this.color;
    }

    //functions to set color and tip---setters
    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

//Classes and Objecs
//Objects----entities in real world
//Classes----group of entities----blueprint

//Getters and setters f(x)


//ACCESS MODIFIERS----refeerncePDF
//PACKAGES-----------referencePDF



