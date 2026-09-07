class Solution {
    public int removeDuplicates(int[] nums) {
     int left=0;
     int right=1;
     while(left<right&&right<nums.length){
        if(nums[left]!=nums[right])
        left++;
        nums[left]=nums[right];
        right++;
     }
     return left+1;
    }
}