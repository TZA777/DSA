
public class inheritance {

    public static void main(String[] args) {

        //creating instace of fish or fish object
        Fish shark = new Fish();
        shark.eat(); //animal method accessed by fish instance(Inheritance)
    }
}

//BASE / PARENT class
class Animal {

    String skinColor;
    void eat() {
        System.out.println("eats");
    }
    void breath() {
        System.out.println("eats");
    }
}

//DERIVED / CHILD class
class Fish extends Animal  {

    void swim(){
        System.out.println("swim in water");  //as fish is derived class to animal--it can access to properties and methods of both fish and animal
    }
}

//Inheritance is when properties of BASE/PARENT class are passed to DERIVEED/CHILD class
//extends keyword is used

//Types of inheritance
//1. Single level ANIMAL-->FISH
//2. Multi level  ANIMAL-->MAMMALS-->DOG
//3. Hierarchial level ANIMAL----->FISH      ANIMAL---->BIRDS       
//4. Hydrid Inheritance----MIX of above---eg: in hierarchial---if fish have derived classes like tuna, shark, king fish etc
//5. Multiple Inferitance------handeled indirectly ---studied at the time of interphases 

//NEXT----POLYMORPHISM

