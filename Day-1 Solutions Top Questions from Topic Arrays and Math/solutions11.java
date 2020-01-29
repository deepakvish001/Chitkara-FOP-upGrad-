// Approach 1: Hash it!
// Intuition

// This approach is an optimization over approach 2. When the number of mappings are limited, approach 2 looks good. 
// But what if you face a tricky interviewer and he decides to add too many mappings?

// Having a condition for every mapping is not feasible or may be we can say the code might get ugly and tough to maintain.

// What if tomorrow we have to change a mapping or may be delete a mapping? 
// Are we going to change the code every time we have a modification in the mappings?

// We don't have to. We can put all these mappings in a Hash Table.

// Algorithm

// Put all the mappings in a hash table. The hash table fizzBuzzHash would look something like { 3: 'Fizz', 5: 'Buzz' }
// Iterate on the numbers from 1 ... N1...N.
// For every number, iterate over the fizzBuzzHash keys and check for divisibility.
// If the number is divisible by the key, concatenate the corresponding hash value to the answer string for current number. 
// We do this for every entry in the hash table.
// Add the answer string to the answer list.
// This way you can add/delete mappings to/from to the hash table and not worry about changing the code.

// So, for FizzBuzzJazz the hash table would look something like { 3: 'Fizz', 5: 'Buzz', 7: 'Jazz' }


// Complexity Analysis

// Time Complexity : O(N)
// Space Complexity : O(1)


class Solution {
  public List<String> fizzBuzz(int n) {

    // ans list
    List<String> ans = new ArrayList<String>();

    // Hash map to store all fizzbuzz mappings.
    HashMap<Integer, String> fizzBizzDict =
        new HashMap<Integer, String>() {
          {
            put(3, "Fizz");
            put(5, "Buzz");
          }
        };

    for (int num = 1; num <= n; num++) {

      String numAnsStr = "";

      for (Integer key : fizzBizzDict.keySet()) {

        // If the num is divisible by key,
        // then add the corresponding string mapping to current numAnsStr
        if (num % key == 0) {
          numAnsStr += fizzBizzDict.get(key);
        }
      }

      if (numAnsStr.equals("")) {
        // Not divisible by 3 or 5, add the number
        numAnsStr += Integer.toString(num);
      }

      // Append the current answer str to the ans list
      ans.add(numAnsStr);
    }

    return ans;
  }
}