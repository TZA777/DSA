import java.util.Stack;

public class practice2 {

    //1.push at bottom of stack---HINT using recurssion
    public static void pushBottom(Stack<Integer>stack, int data){
        //s1: remove elements from top
        //s2: recursive call---empty the stack-----ie BASE CASE(where we add data i,e push data at bottom)
        //s3: put back removed elements

        //basecase
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }


        //step1-remove element from top
        int top = stack.pop();

        //step2:-recursive call 
        pushBottom(stack, data);

        //step3:-add removed elements back to stack
        stack.push(top);
    }

    //2. reverse a string using stack
    public static String reversString(String str){

        //creating stack
        Stack<Character> stack = new Stack<>();

        //s1: push all characters into stack
        for(int i=0; i<str.length(); i++){
            stack.push(str.charAt(i));
        }

        //s2: pop characters and build reversed string
        StringBuilder result = new StringBuilder();

        while(!stack.isEmpty()){
            result.append(stack.pop());  //stack.pop() method automatically removed top elemets and append to SttingBuilder(result)
        }

        return result.toString();

    }


    //reverse a stack---note: we make use of pushBottom method
    public static void reverseStack(Stack<Integer>stack){
        //basecase----when all elements are removed---return
        if(stack.isEmpty()){
            return;
        }

        //removing top elements
        int top = stack.pop();

        //recursively removing top elements----Note: Base case (to stop infinate looping);
        reverseStack(stack);

        //add elements at bottom---using pushBottom() method
        pushBottom(stack, top); 

    }

    public static void main(String[] args) {

        //stack using Java Collection Framework
        Stack<Integer> s = new Stack<>();

        //push
        s.push(10);
        s.push(20);
        s.push(30);

        //peek
        System.out.println("top element :"+ s.peek());

        //1. push at bottom
        pushBottom(s, 5);

        //2. reverse a string
        System.out.println(reversString("abc"));

        //3. reversing a stack
        reverseStack(s);  //stack<> ---10,20,30,5----->output ---5,30,20,10

        //printing stack----using pop()
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
        
    }   
}

//practice2
//stack using collections framework
//problems
//push at bottom of stack 
//reverse a string using a stack
//reverse a stack
