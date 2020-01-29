public class Solution {
    public int countPrimes(int n) {
        if(n<1) return 0;
        boolean[] primeArray = new boolean[n+1];
        primeArray[1] = true;
        for(int i=2; i<primeArray.length; i++) {
            if(primeArray[i]==false) {
                for(int j=2; i*j<n+1;j++) 
                    primeArray[i*j] = true;
            }
        }
        int count=0;
        for(int i=1; i<primeArray.length-1; i++)
            if(primeArray[i]==false) count++;
        return count;
    }
}