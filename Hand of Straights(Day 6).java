class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int val : hand){
            pq.add(val);
        }
        
//empty the pq to find the seq
        while(!pq.isEmpty()){
            int small_val = pq.poll();//smallest val in pq 
            for(int i = 1;i<groupSize;i++){
                if(pq.remove(small_val+i)) continue;
                else return false;
            } 



        }
        return true;
    }
}
