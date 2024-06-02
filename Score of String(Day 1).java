class Solution {
    public int scoreOfString(String s) {
        int score= 0;
        for(int i = 0 ; i< s.length() - 1;i++){
            score += (int)Math.abs(s.charAt(i) - s.charAt(i+1));//if char is typecasted into int then it will give ascii value
        }
        return score;
    }
}
