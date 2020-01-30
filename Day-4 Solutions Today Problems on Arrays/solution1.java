// This problem requires a simple adhoc approach :

// Just need to simulate whats stated in the problem.
// Can you traverse through the array maintaining the current subset ?
// Note that the subset becomes invalid as soon as you encounter a negative number.

// Also, note that you do not need to start again on encountering the negative number. 
// You can start from the number next to the negative number.

// Here we go :

// Loop i = 1 to Array.length :
//         IF current element is positive :
//                 update current sum
//                 compare max sum with current sum
//                 update max sum
//                 update max ranges
//         ELSE :
//             current sum := 0
//             update current ranges.
// EndLoop;

// return elements of max ranges


public class Solution {
	public ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    long max=-1;
	    long max1=0;
	    int start_index=0,last_index=0,temp=0;
	    Integer [] arr=a.toArray(new Integer[a.size()]);
        Integer [] arr1=a.toArray(new Integer[a.size()]);
	    int n=a.size();
	    for(int i=0;i<n;i++)
	    {
	        if(i!=0 && arr[i-1]>=0 && arr[i]>=0)
	        {
	            max1+=arr[i];
	            if(i==n-1 && max<max1)
	            {
	                max=max1;
	                last_index=i;
	                start_index=temp;
	            }else if(i==n-1 && max== max1)
	            {
	                int length1=last_index- start_index+1;
	                int lenght2=i-temp+1;
	                if(lenght2>length1)
	                {
	                    last_index=i;
	                    start_index=temp;
	                }
	            }
	        }
	        else if(arr[i]>=0)
	        {
	            temp=i;
	            max1=arr[i];
	            if(i==n-1 && max<max1)
	            {
	                max=max1;
	                last_index=i;
	                start_index=temp;
	            }
	            else if(i==n-1 && max== max1)
	            {
	                int length1=last_index- start_index+1;
	                int lenght2=i-temp+1;
	                if(lenght2>length1)
	                {
	                    last_index=i;
	                    start_index=temp;
	                }
	            }
	        }
	        else if(i!=0 && arr[i]<0 && arr[i-1]>=0)
	        {
	            if(max<max1){
	                max=max1;
	                max1=0;
	                start_index=temp;
	                last_index=i-1;
	            }
	            else if(max == max1)
	            {
	                max1=0;
	                int length1=last_index- start_index+1;
	                int lenght2=i-1 -temp+1;
	                if(lenght2>length1)
	                {
	                    last_index=i-1;
	                    start_index=temp;
	                }
	            }
	        }
	    }
	    a.clear();
	    if(max==-1)
	        return a;
	    for(int i=start_index;i<=last_index;i++)
	    {
	        
	        a.add(arr1[i]);
	    }
	    
	    return a;
	}
}