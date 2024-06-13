class Solution {
    public int minMovesToSeat(int[] seats, int[] students) {
       Arrays.sort(seats);
       Arrays.sort(students);
       int move = 0; 
       for(int i = 0 ; i< students.length;i++){
        move = move + Math.abs( seats[i] - students[i]);
         //math.abs will give always non-negative regardless of pos or neg
       }
       return move;

    }
}
