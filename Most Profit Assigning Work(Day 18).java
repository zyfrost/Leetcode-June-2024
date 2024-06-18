class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] diff = new int[difficulty.length][2];
        // row will be according to difficuly length and col will be 2 for diff and
        // profit
        for (int i = 0; i < difficulty.length; i++) {
            diff[i][0] = difficulty[i];
            diff[i][1] = profit[i];
        }

        Arrays.sort(diff, (a, b) -> a[0] - b[0]);
        Arrays.sort(worker);

        int totalProfit = 0;
        int maxProfit = 0;
        int j = 0;

        for (int i = 0; i < worker.length; i++) {
            int ability = worker[i];
            while (j < diff.length && ability >= diff[j][0]) {
                maxProfit = Math.max(maxProfit, diff[j][1]);
                j++;
            }
            totalProfit += maxProfit;

        }
        return totalProfit;
    }

}
