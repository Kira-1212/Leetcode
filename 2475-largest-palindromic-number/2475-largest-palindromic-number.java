class Solution {
    public String largestPalindromic(String num) {
        // Step 1: Count digit frequencies
        Map<Character, Integer> freq = new HashMap<>();
        for (char digit : num.toCharArray()) {
            freq.put(digit, freq.getOrDefault(digit, 0) + 1);
        }

        // Step 2: Form the left half of the palindrome, avoiding leading zeros
        StringBuilder leftHalf = new StringBuilder();
        for (char digit = '9'; digit >= '0'; digit--) {
            if (freq.containsKey(digit) && freq.get(digit) > 1) {
                // Only add zeros if leftHalf is not empty to avoid leading zeros
                if (digit == '0' && leftHalf.length() == 0) {
                    continue;
                }
                int pairs = freq.get(digit) / 2;
                for (int i = 0; i < pairs; i++) {
                    leftHalf.append(digit);
                }
                // Reduce count by the number of pairs used
                freq.put(digit, freq.get(digit) % 2);
            }
        }

        // Step 3: Choose the middle digit
        String middle = "";
        for (char digit = '9'; digit >= '0'; digit--) {
            if (freq.containsKey(digit) && freq.get(digit) > 0) {
                middle = Character.toString(digit);
                break;
            }
        }

        // Step 4: Build the full palindrome
        String leftHalfStr = leftHalf.toString();

        // Edge case: If everything is zero, return "0"
        if (leftHalfStr.isEmpty() && middle.isEmpty()) {
            return "0";
        }

        // Combine leftHalf + middle + reversed(leftHalf) to form the palindrome
        String result = leftHalfStr + middle + leftHalf.reverse().toString();
        
        return result;
    }
}