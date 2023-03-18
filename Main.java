import java.util.HashMap;
import java.util.Scanner;

public class Main
{

    public static String reverseString(String str) {
        String reversedStr = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversedStr += str.charAt(i);
        }
        return reversedStr;
    }

    public static int[] swapNumbers(int num1, int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;
        int[] result = {num1, num2};
        return result;
    }

    public static void swapNumbers(int num1, int num2) {
        num1 = num1 + num2;
        num2 = num1 - num2;
        num1 = num1 - num2;
    }

    /**
     * @ str string to be decifered
     */

    public static HashMap<String, Integer> countWords(String str) {
        String[] words = str.split("\\s+");
        HashMap<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }
        return wordCount;
    }

    public static boolean checkPrime(int num) {
        if (num <= 1) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        
        return true;
    }


    public static boolean checkPalindrome(int num) {
        int reverse = 0;
        int original = num;
        
        while (num != 0) {
            int digit = num % 10;
            reverse = reverse * 10 + digit;
            num /= 10;
        }
        
        return original == reverse;
    }

    public static void findDuplicates()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        
        HashMap<Character, Integer> charCountMap = new HashMap<>();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (charCountMap.containsKey(ch)) {
                charCountMap.put(ch, charCountMap.get(ch) + 1);
            } else {
                charCountMap.put(ch, 1);
            }
        }
        
        System.out.print("Duplicate characters: ");
        for (char ch : charCountMap.keySet()) {
            if (charCountMap.get(ch) > 1) {
                System.out.print(ch + " ");
            }
        }
    }
    












    public static void main(String[] args) {
        
    }
}
