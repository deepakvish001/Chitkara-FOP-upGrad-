// Approach 4: Binary search
// The idea is to apply binary search method to find the string with maximum value L, which is common prefix of all of the strings. 
// The algorithm searches space is the interval (0…minLen), where minLen is minimum string length and the maximum possible 
// common prefix. Each time search space is divided in two equal parts, one of them is discarded, 
// because it is sure that it doesn't contain the solution. There are two possible cases:

// 1. S[1...mid] is not a common string. This means that for each j > i S[1..j] 
// is not a common string and we discard the second half of the search space.

// 2. S[1...mid] is common string. This means that for for each i < j S[1..i]
//  is a common string and we discard the first half of the search space, because we try to find longer common prefix.

public String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0)
        return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs)
        minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
        int middle = (low + high) / 2;
        if (isCommonPrefix(strs, middle))
            low = middle + 1;
        else
            high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
}

private boolean isCommonPrefix(String[] strs, int len){
    String str1 = strs[0].substring(0,len);
    for (int i = 1; i < strs.length; i++)
        if (!strs[i].startsWith(str1))
            return false;
    return true;
}


// Complexity Analysis

// In the worst case we have nn equal strings with length m

// Time complexity : O(S⋅logn), where S is the sum of all characters in all strings.

// The algorithm makes nlogn iterations, for each of them there are S=m⋅n comparisons, which gives in total O(S⋅logn) time complexity.

// Space complexity : O(1). We only used constant extra space.