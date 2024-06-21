class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int start = 0;
        int currSum = 0;
        int end = start + minutes;
        int maxSum = 0;
        int maxStart = -1;

        for (int i = start; i < end; i++) {
            currSum += grumpy[i] == 1 ? customers[i] : 0;
        }

        maxSum = currSum;
        maxStart = start;

        while (end < n) {
            currSum -= grumpy[start] == 1 ? customers[start] : 0;
            start++;
            currSum += grumpy[end] == 1 ? customers[end] : 0;
            if (currSum > maxSum) {
                maxSum = currSum;
                maxStart = start;
            }
            end++;
        }
        int satisfied = 0;

        for (int i = 0; i < n; i++) {
            satisfied += (i >= maxStart && i < (maxStart + minutes) || grumpy[i] == 0) ? customers[i] : 0;
        }
        return satisfied;
    }
}
