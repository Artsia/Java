import java.util.ArrayList;

class Solution {
    /**
     * Find longest length for a subString
     */
    public int lengthOfLongestSubstring(String s) {
        ArrayList<String> arr = new ArrayList<String>();


        if (s.length() < 2) {
            return  s.length(); // If the string has 0 or 1 character, it's already a palindrome.
        }

        //when all letters are same in string
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(0)== s.charAt(i) ){
                //for consecutive characters in string s that are the same 
                counter++;
            }
        }

       
        if(counter == s.length()){
            return 1;
        }

        // compare i=0 value with i=n value
        // if they match, create that sub string, store into variable, see if a palindrome, and
        // if so, store it in an ArrayList (because I don't know possible palindromes I need to store from the original string)

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String subSp = s.substring(i, j);
                System.out.println("SubString: "+subSp);

                if (isPalindrome(subSp)) {
                    arr.add(subSp);
                }
            }
        }

        // check which palindrome has the longest length and return it
        int biggest = arr.get(0).length();
        int indexOfPdmSubString = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).length() > biggest) {
                biggest = arr.get(i).length();
                indexOfPdmSubString = i;
            }
        }
        System.out.print(arr.get(indexOfPdmSubString));

        return biggest;
    }

    /** check if str is palindrome */
    /** A palindrome is a word, phrase, or sentence that reads the same backward or forward */
    private boolean isPalindrome(String str) {
        String clean = str.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar)
                return false;
        }
        return true;
    }
}
