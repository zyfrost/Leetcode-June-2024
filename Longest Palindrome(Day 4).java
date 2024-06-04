class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char ch : s.toCharArray()) {
            count[ch]++;
        }

        int result = 0;
        for (Integer char_count : count) {
            result += char_count / 2 * 2;
            if (result % 2 == 0 && char_count % 2 == 1) {
                result += 1;
            }
        }
        return result;

    }
}
