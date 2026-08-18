class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=-1;
        if(nums.length==k){
            for(int num:nums){
                map.put(num,1);
            }
            for(int n:map.keySet()){
                max=Math.max(max,n);
            }
            return max;
        }
        for(int i=0;i<=nums.length-k;i++){
            for(int j=i;j<i+k;j++){
                map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            }
        }
        for(int n:map.keySet()){
            if(map.get(n)==1){
               max=Math.max(n,max);
            }
        }
        return max;
    }
}