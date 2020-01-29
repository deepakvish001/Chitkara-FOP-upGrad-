public static int[] plusOne(int[] digits) {

        //  making sure the array is not empty
        if (digits != null && digits.length != 0) {

            // check if the last element < 9 then i will just plus that num
            int lastElementIndex = digits.length - 1;
            if (digits[lastElementIndex] < 9) {
                digits[lastElementIndex]++;
                return digits;
            }

            // getting here means that last element is 9
            // lopping from the end to make digit 9 >> 0 and increment the last not 9 digit and then break to end the loop
            for (int i = lastElementIndex; i >= 0; i--) {
                if (digits[i] == 9) {
                    digits[i] = 0;
                } else {
                    digits[i]++;
                    break;
                }
            }
            // check the first element of the array if it's equal 0 that means that all of them were 9 
            // so i will make another array that have length digits.length +1 and will put the first element to 1 and the rest will remain 0 
            // [9,9,9] >>> [1,0,0,0]
            if (digits[0] == 0) {
                int[] newArray = new int[digits.length + 1];
                newArray[0] = 1;
                return newArray;
            }
            
        }
        return digits;
    }