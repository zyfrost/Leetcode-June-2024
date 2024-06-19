class Solution {


    private boolean isPossible(int arr[], int days , int m , int k){
        int n= arr.length;
        int count = 0;
        int ans = 0;
        for(int i = 0 ; i< n ;i++){
            if(arr[i] <= days){
                count++;
            } else {
                count = 0;
            }

            if(count == k ){
                ans++;
                count = 0;
            }
        }
        return ans>= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE;
        int high= Integer.MIN_VALUE;
        int n = bloomDay.length;
    for(int i = 0 ; i< n ;i++){
        low = Math.min(low,bloomDay[i]);
        high = Math.max(high,bloomDay[i]);

    }
    int ans = -1;
    int totalFlowers = m * k;

    if(totalFlowers >n){
        return ans;
    }
        while(low <= high){
            int mid = low + (high - low )/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans = mid ;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;
    }
}
