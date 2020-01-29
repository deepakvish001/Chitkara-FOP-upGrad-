// Note that because the order of covering the points is already defined, the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).

// Can you think of a formula for calculating the distance in O(1) ?

// Note that because the order of covering the points is already defined, the problem just reduces to figuring out the way to calculate the distance between 2 points (A, B) and (C, D).

// Note that what only matters is X = abs(A-C) and Y = abs(B-D).

// While X and Y are positive, you will move along the diagonal and X and Y would both reduce by 1.
// When one of them becomes 0, you would move so that in each step the remaining number reduces by 1.

// In other words, the total number of steps would correspond to max(X, Y).



public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        int dist = 0;
        int i = 1;
        while(i<A.size()){
            dist += Math.max(Math.abs(A.get(i)-A.get(i-1)),Math.abs(B.get(i)-B.get(i-1)));
            i++;
        }
        return dist;
    }
}