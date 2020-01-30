// The straightforward approach is to for every element find how many integers are greater than that, 
// and if that matches our given statement then we have our answer.

// Will sorting the array help?


// First we sort the input array.

// Now, all we have to do is to traverse through each element of the array and check whether 
// it matches our given statement, since the array is sorted 
// we directly know how many elements are greater than that number in the array.

// Note: Please take care of cases, when certain element repeats many times.


public class Solution {
    public int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        Collections.reverse(A);
        int l =A.size();
        for(int i=0; i<l ;i++){
            if(A.get(i)==i){
                if(i!=0 && A.get(i)!=A.get(i-1)){
                //System.out.println(i);
                return 1;
                }
                else if(i==0){
                return 1;
                    
                }
                
            }
        }
        return -1;
    }
}
