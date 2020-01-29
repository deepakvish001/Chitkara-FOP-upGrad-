// Time: O(N), Space: O(1)

class Solution {
    public void moveZeroes(int[] nums) {
        // init count of zeroes
        int count = 0;
        
        // loop through array, determine the number of zeroes
        for (int i = 0; i < nums.length; i++){
            if (nums[i] == 0){
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        
        // replace with zeroes from right
        for (int i = 0; i < count; i++){
            nums[nums.length - 1 - i] = 0;
        }
    }
}