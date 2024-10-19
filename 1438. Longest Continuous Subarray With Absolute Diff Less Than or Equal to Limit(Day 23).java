class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            // store number and freq
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;// 1 2 3 4
            }
            res = Math.max(res,right - left + 1 );
            right++;//1 2 3 4 break loop
        }
        return res;
    }
}
