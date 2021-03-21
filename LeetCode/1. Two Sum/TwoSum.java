class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] output = null;
        
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j] == target){
                    output = new int[2];
                    output[0] = i;
                    output[1] = j;
                }
            }
        }
        
        if(output == null){
            return null;
        }
        else{
            return output;
        }
    }
}