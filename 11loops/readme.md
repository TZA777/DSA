1. while loop
2. for loop
3. do-while loop

used over loops
4. break
5. continue

while (condition){
    //do some work
}
--------------------------------------------------------------------------------------------------------
for(initialization, condition, updation){
    //do some work
}
----------------------------------------------------------------------------------------------------------
do{
    //do some work
}while()
-----------------------------------------------------------------------------------------------------------

break statement
Used to exit a loop immediately (or switch-case).
Control jumps out of the loop.


public class BreakExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                break;   // exit loop when i == 3
            }
            System.out.println("i = " + i);
        }
    }
}
-----------------------------------------------------------------------------------------------------
continue statement 
Used to skip the current iteration of a loop.
Control jumps to the next iteration.

public class ContinueExample {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;   // skip when i == 3
            }
            System.out.println("i = " + i);
        }
    }
}

Practice questions
1. Print numbers 1 to n
2. Sum of first n natural numbers
3. print Square pattern
4. Revers a given number
5. Check if a number is prime or not \

            for (int i = 2; i <= num / 2; i++) {   
                if (num % i == 0) {
                    isPrime = false;  // found a divisor
                    break;}}

6. Write a program that reads a set of integers and prints the sum of even and odd integers 
7. write a program to find factorial of a number
8. write a program to print multiplication table of a number N

