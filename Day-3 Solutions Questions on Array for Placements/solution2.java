// First convince yourself that constructing numbers and then adding 1 will not work.
// The number of digits can be really high ( Imagine 1000 - 10000 digits ).

// Now, lets look at how we will add 1.
// Try to think of how you would add 1 on paper. Start from the last digit, and maintain carry.

// There are 2 cases with adding one.

// Case 1:

// The number of digits after adding 1 remains the same.

// This is the easy case. Simulate the mathematical process of adding one maintaining carry from the digit.

// Case 2:

// The number of digits increases by 1 when adding.

// This causes some complication as you would have to shift all digits by 1 to make space for the
//  new digit in the most significant position.

//  Tip :Try reversing the digits for the addition. Reverse them back after getting the result.

//  Reverse the digits of the number to make your life easier.

// Maintain a carry which is initialized to 1 ( Denoting that we need to add one to the number ).
// Run a loop on the digit array ( which is now reversed ), and add carry to the current digit. If the digit D exceeds 10 on doing so, store the last digit in current position ( D % 10 ), and make carry = rest of the digits ( D / 10 ). Continue the process till you have covered all the digits.
// Now if at the end, carry = 0, we are done, and we can return the array.

// If not, we need to add one more digit, with carry in it.


public class Solution {
    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int reminder = 0;
       while (A.size() > 1 && A.get(0) == 0) {
            A.remove(0);
        }
        for (int i = A.size() - 1; i >= 0; i--) {
            int num = A.get(i);
            if(num == 9){
                A.remove(i);
                A.add(i,0);
                reminder = 1;
            }else{
                A.remove(i);
                A.add(i,num+1);
                reminder = 0;
                break;
            }
        }
        if(reminder == 1){
            A.add(0,1);
        }
        return A;
    }