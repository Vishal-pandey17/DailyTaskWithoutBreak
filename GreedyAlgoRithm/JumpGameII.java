public class Solution {
    public int jump(int[] nums) {
        int stepCount = 0;
        int end = 0;
        int max = 0;

        for(int i=0;i<nums.length-1;i++){
            max = Math.max(max, nums[i]+i);
            if(i == end){
                stepCount++;
                end = max;
            }  
        }
        return stepCount;
    }
}{

}
