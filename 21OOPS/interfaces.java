
public class interfaces {

    public static void main(String[] args) {
        //creating instance of queen 
        Queen q = new Queen();
        //accessign q methods
        q.moves();

        //multiple inheritance using interface
        //creating bear instance
        Bear b= new Bear();
        b.eatsMeat();
        b.eatsPlants();
    }
}

//creating interface
interface ChessPlayer {

    void moves();  //by default public and by default abstract
}

//Queen implements ChessPlayer interface
class Queen implements ChessPlayer {

    public void moves() {
        System.out.println("up, down, left, right, diagnol");
    }
}

//Rook implements ChessPlayer interface
class Rook implements ChessPlayer {

    public void moves() {
        System.out.println("up, down, left, right");
    }
}

//-----------------------------------------------------------------------------------
//Multiple inheritance using interface----acheived indirectly
//creating interface of Herbivours
interface Herbivours {

    void eatsPlants();
}

//creating interface of Carnivours
interface Carnivours {

    void eatsMeat();
}

//bear class implementing both herbivours and carnivours
class Bear implements Herbivours, Carnivours {

    public void eatsPlants() {  //imp---public 
        System.out.println("eats plants");
    }

    public void eatsMeat() {
        System.out.println("eats meat");
    }
}

//inteface is a blueprint of class
//class is a blueprint of objects
//1. All methods are public, abstract without implementation
//2. Used to acheive total abstraction 
//3. Variable in interface are final, public and static
//Multiple inheritance using interface----acheived indirectly

//static keyword
//super keyword


