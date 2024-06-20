Magnetic Force Between Two Balls
  class Solution {

    private boolean isAllocationPossible(int minDist, int arr[], int m) {
        int ballsPlaced = 1;
        int lastPos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - lastPos >= minDist) {
                ballsPlaced++;
                lastPos = arr[i];
            }
            if (ballsPlaced >= m)
                return true;
        }
        return false;
    }

    public int maxDistance(int[] position, int m) {
        // similiar to aggresive cows
        // minimum question with maximum is given then use binary search
        // for monotonic sequence , binary search on ans concept will be used

        if (m > position.length) {
            return -1;
        }
        Arrays.sort(position);
        int n = position.length;
        int low = 0;
        int high = position[n - 1] - position[0];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isAllocationPossible(mid, position, m)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }
}
