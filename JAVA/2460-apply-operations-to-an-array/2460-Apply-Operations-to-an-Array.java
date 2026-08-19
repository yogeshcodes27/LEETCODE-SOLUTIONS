class Solution {
    public int[] applyOperations(int[] nums) {
        int left=0;
        for(int i=1;i<nums.length;i++){
            if(nums[left]==nums[i]){
                nums[left]=nums[left]*2;
                nums[i]=0;
            }
            left++;
        }
         int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                index++;
            }
        }
        return nums;
    }
}