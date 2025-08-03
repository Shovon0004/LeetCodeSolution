// Maximum Fruits Harvested After at Most K Steps

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int total=0;
        int max=Integer.MIN_VALUE;
        int left=0;
        for(int right=0;right<fruits.length;right++){
            total+=fruits[right][1];
            while(left<=right && !valid(fruits,left,right,startPos,k)){
                total-=fruits[left][1];
                left++;
            }
            max=Math.max(max,total);
        }

        return max;
        
    }

    public boolean valid(int[][] fruits,int left,int right,int start,int k){
        int leftPos=fruits[left][0];
        int rightPos=fruits[right][0];
        int goalLeftFirst=Math.abs(start-leftPos)+(rightPos-leftPos);
        int goalrightFirst=Math.abs(start-rightPos)+(rightPos-leftPos);
        return Math.min(goalLeftFirst, goalrightFirst) <= k;
    }
}