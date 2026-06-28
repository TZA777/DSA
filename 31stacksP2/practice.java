
import java.util.Stack;

public class practice {

    public static boolean validateParentheses(String str) {
        //creating stack
        Stack<Character> stack = new Stack<>();

        //loop
        for (int i = 0; i < str.length(); i++) {
            //current char
            char ch = str.charAt(i);

            //opening case---ie opening parentheses ---push to stack 
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } //closing case
            else if (ch == ')' || ch == '}' || ch == ']') {

                //stack-empty case--->there are few closing parantheses---not valid--return false
                if (stack.isEmpty()) {
                    return false;
                }

                //check top with curr char and both are same----remove opening from stack using stack.pop();---next closing parantheses can be validated
                char top = stack.peek();

                if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
                    stack.pop();
                } else {
                    return false;
                }

            }

        }

        //return true---as opening and closing parantheses matches
        return stack.isEmpty();
    }

    //-------------------------------------------------------------------------------------
    // Function to check duplicate parentheses
    public static boolean checkDuplicateParentheses(String str) {

        // Create a stack to store characters
        Stack<Character> s = new Stack<>();

        // Traverse the entire string
        for (int i = 0; i < str.length(); i++) {

            // Current character
            char ch = str.charAt(i);

            // If current character is closing bracket
            if (ch == ')') {

                // Count characters inside current ()
                int count = 0;

                // Pop elements until opening bracket '(' is found
                while (!s.isEmpty() && s.peek() != '(') {
                    s.pop();
                    count++;   // Count how many characters are inside
                }

                // If no character exists between ()
                // Example: "()"  OR  "((a+b))" → inner () has no content
                if (count < 1) {
                    return true;  // Duplicate parentheses found
                } else {
                    // Remove the matching '(' from stack
                    s.pop();
                }
            } // If opening bracket OR operand OR operator
            // push everything into stack
            else {
                s.push(ch);
            }
        }

        // If no duplicate parentheses found
        return false;
    }

    //---------------------------------------------------------------------------------------------------
    public static void maxRectangularArea(int arr[]) {
        int n = arr.length;
        int nsr[] = new int[n];
        int nsl[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        //calculate nsr
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsr[i] = n;
            } else {
                nsr[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear(); //to clear if any left out elements in the stack

        //calculate nsl
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = stack.peek();
            }

            stack.push(i);
        }

        //calculate curr area---width= j-i-1
        for (int i = 0; i < n; i++) {
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;

            int currArea = height * width;

            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println(maxArea);

    }

    public static void main(String[] args) {

        //validate parantheses
        String str = "(({{[[()]]}}))";

        //calling validateParentheses f(x)
        //System.out.println(validateParentheses(str));
        //------------------------------------------------------------------------------------------------
        //checkDuplicateParentheses
        String str1 = "((a+b))";
        //System.out.println(checkDuplicateParentheses(str1));
        //------------------------------------------------------------------------------------------------
        //max rectangular area in a histogram

        int heights[] = {2, 1, 5, 6, 2, 3};

        maxRectangularArea(heights);

    }
}

//valid parentheses
//Write a Java program to check whether a given string of parentheses is valid using a Stack.
// A string is valid if:
// Every opening bracket has a corresponding closing bracket.
// Brackets are closed in the correct order.
// The string contains only (), {}, and [].
//String str= "(({{[[()]]}))";
//
//
//duplicate parentheses
// Write a Java program to determine whether a given arithmetic expression contains duplicate parentheses.
// Duplicate parentheses occur when an expression is unnecessarily enclosed within an extra pair of brackets.
// For example:
// ((a+b)) → Duplicate parentheses exist
// (a+b)+(c+d) → No duplicate parentheses
// Use a Stack data structure to solve the problem.//
//
//
//max rectangular area in histogram
//Given an array of integers representing the heights of bars in a histogram (where each bar has width 1), write a program to find the area of the largest rectangle that can be formed within the histogram.
// Use a Stack to compute the solution efficiently.
// Example:
// Input: {2,1,5,6,2,3}
// Output: 10
//
//next assignment

