// Explanation::

// In the first step we are checking whether the length of any of the array is 0 i.e empty
// then return the empty array itself as we intersection means common elements between
// two array so this is one of corner testcase where one array is empty and other is non-empty
// so return the array itself.
// for e.g 1st array: [ ]
// 2nd array : [1 , 2, 4]
// then our function should return [ ].(This is all about both if conditions)
// Now if we sort the array the time taken to find the common element is reduced as the
// array is sorted. so we sorting the array to reduce the time complexity.

// Now we use two pointer approach to find the common elements fast
// for e.g if(element at 0th index in first array<element at 0th index in second array)
// then increment the index of first array by one.

//           similarly second case
//           else if(if(element at 0th index in first array>element at 0th index in second array)
//             then    increment the index of second  array by one.
            
//             we do this because the array is sorted(in ascending order) since if the first element
//             is less than second element then it must be present after that.
            
//             In the third case in else condition if both are equal insert the element into the
//             array and increment its position by one i.e(nums1[k++] = nums1[i])
// At last we copy the elements into nums1 and return the array.

class Solution
{
    public int[] intersect(int[] nums1, int[] nums2)
    {
        if(nums1.length==0)
            return nums1;
        if(nums2.length==0)
            return nums2;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0,k=0;
        while(i<nums1.length && j<nums2.length)
        {
            if(nums1[i]<nums2[j])
                i++;
            else if(nums1[i]>nums2[j])
                j++;
            else
            {
                nums1[k++] = nums1[i];
                i++;
                j++;
            }
        }
       return Arrays.copyOfRange(nums1,0,k);
    }
}
