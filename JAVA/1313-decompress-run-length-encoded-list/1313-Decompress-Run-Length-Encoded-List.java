class Solution {
    public int[] decompressRLElist(int[] nums) {
         int size = 0;
        for (int i = 0; i < nums.length; i += 2) {
            size += nums[i];
        }
        int[] arr=new int[size];
        int k=0;
        for(int i=0;i<nums.length/2;i++){
            int freq=nums[2*i];
            while(freq!=0){
                arr[k]=nums[2*i+1];
                freq--;
                k++;
            }
        }
        return arr;
    }
}