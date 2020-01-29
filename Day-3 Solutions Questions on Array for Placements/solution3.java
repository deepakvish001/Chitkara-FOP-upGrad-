O(n^3) solution is simple.

You look at every pair (i,j) and compute the sum of elements between i and j and then take the maximum of the sums.

Obviously, this is not the best solution.

Next improvement is O(n^2) when you notice that you don’t need to sum up all the elements between i and j. You can just add A[j] to the sum you have already calculated in the previous loop from i to j-1.

However, we are looking for something better than N^2.

For O(n) solution can you look at optimal subarray and deduce some observations from it?
If you start taking every element greedily when should you stop?


Let us say Ai, Ai+1 … Aj is our optimal solution.

Note that no prefix of the solution will ever have a negative sum.

Let us say Ai … Ak prefix had a negative sum.

Sum ( Ai Ai+1 … Aj ) = Sum (Ai … Ak) + Sum(Ak+1 … Aj)

Sum ( Ai Ai+1 … Aj) - Sum(Ak+1 … Aj) = Sum(Ai … Ak)

Now, since Sum(Ai … Ak) < 0,

Sum (Ai Ai+1 … Aj) - Sum (Ak+1 … Aj) < 0

which means Sum(Ak+1 … Aj ) > Sum (Ai Ai+1 … Aj)

This contradicts the fact that Ai, Ai+1 … Aj is our optimal solution.

Instead, Ak+1, Ak+2 … Aj will be our optimal solution.

Similarily, you can prove that for optimal solution, it is always good to include a prefix with positive sum.

Try to come up with a solution based on the previous 2 facts.

If this still does not make sense, watch this video for more detailed explanation :

https://www.youtube.com/watch?v=ohHWQf1HDfU&vl=en


public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int maxSubArray(final List<Integer> A){
        int currMax = A.get(0);
        int tempMax = A.get(0);
        for(int i=1;i<A.size();i++){
            if(A.get(i)>tempMax+A.get(i)){
                tempMax=A.get(i);
            }
            else{
                tempMax+=A.get(i);
            }
            if(currMax < tempMax){
                currMax=tempMax;
            }
        }
        return currMax;
    }
}