import java.util.Stack;

public class practice3 {

    public static void stockSpan(int stocksArr[], int stockSpan[]){
        
        //creating an empty stack
        Stack <Integer> stack = new Stack<>();

        //handling span first element---for 1st itself so 1
        stockSpan[0]=1;
        stack.push(0); //pushing 0th index for future ref

        //for loop for rest of elements 
        for(int i= 1; i<stocksArr.length; i++){

            int currentPrice = stocksArr[i];

            //condition to check lower prices/equal prices till current day and removing respective index from stack
            // after loop---the top of the stack repesent index of  higher price than currnet day price of a previous day---so beyond is not consecutive
            while(!stack.isEmpty() && currentPrice>stocksArr[stack.peek()]){
                stack.pop(); //removing elements with lower and equal prices till we hit a highter price of  previous days
            }

            if(stack.isEmpty()){
                stockSpan[i]= i+1; //previous days + current day
            }else{
                //index of previousHigh
                int previousHigh = stack.peek();

                //cal stockSpan and push into stockSpan array
                stockSpan[i]= i-previousHigh; //i= current day index, previousHigh= higherPrice of previous day, diff is stockSpan-here curr index is also considered in diff
            }

            //pushing currnt day index for future check
            stack.push(i);
        }
    }

    //------------------------------------------------------------------------------------------

    public static void nextGreaterElement(int arr[], int nextGreater[]){
        //creating empty stack 
        Stack<Integer> s = new Stack<>();

        //reverse loop on arr---to check next greaterElement
        for(int i= arr.length-1; i>=0; i--){

            //step1
            //if next element is not greater than currnt element then remove from stack
            while(!s.isEmpty()  && arr[i]>arr[s.peek()]){
                s.pop();
            }

            //step2
            //if stack is empty, then no greater element on right 
            if(s.isEmpty()){
                nextGreater[i]= -1;
            }else{
                nextGreater[i]= arr[s.peek()];
            }

            //step3
            //adding curent index to stak for further loop
            s.push(i);   
        }
    }

    
    public static void main(String [] args){
        
        //creating stocks array.
        int stocks[]= {100, 80, 60, 70, 60, 85,100};

        //stock span empty array
        int span[]= new int[stocks.length];

        //calling stockSpan f(x)
        stockSpan(stocks, span);


        // //printing Stock span 
        // for(int i=0; i<span.length; i++){
        //     System.out.println(span[i]);
        // }

        //-------------------------------------------------------------------------
        //nextGreater element

        int arr[]= {6,8,0,1,3};

        int result[] = new int[arr.length];

        //calling nextGreaterElement f(x)
        nextGreaterElement(arr, result);

          //printing result
        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
      }
        //--------------------------------------------------------------------------
    }  
}

//practice3
//advanced problems
//
//1.stock span problem
//Given an array of stock prices, calculate the stock span for each day.
//The stock span of a day is the number of consecutive previous days (including the current day) 
// for which the stock price was less than or equal to today’s price.
//int stocks[]= {100, 80, 60, 70, 60, 85,100};
//NOTE: HINT: index of higher price is stored into stack and we make use of the same
//
//
//2.next greater element in the array int arr[]= {6,8,0,1,3};
