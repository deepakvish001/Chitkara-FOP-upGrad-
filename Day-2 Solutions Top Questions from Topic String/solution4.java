// This is a straight forward recursive solution. We just have to implement a function that can say a given string. 
// For ex - given "1211" the function should return "111221" (one 1, one 2 and 2 ones). 
// Then once we have this function, each number would recursively call n-1 and say what the n-1 number said.

// For ex - 3 would "say" what 2 said.

// The say method below says the given string. 
// If previous character is same as current, we just increment the count, and when we get a different character, 
// we append the count and the previous number, and reset the count to 1.

class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        return say(countAndSay(n-1));
    }
    
    private String say (String s) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) count++;
            else {
                sb.append(count);
                sb.append(s.charAt(i-1));
                count=1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length()-1));
        return sb.toString();
    }
}