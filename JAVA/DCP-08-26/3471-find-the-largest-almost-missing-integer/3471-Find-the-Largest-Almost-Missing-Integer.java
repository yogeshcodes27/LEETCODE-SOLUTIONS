class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int max=-1;
        for(int i=0;i<=nums.length-k;i++){
           HashMap<Integer,Integer> map1=new HashMap<>();
            for(int j=i;j<i+k;j++){
                map1.put(nums[j],1);
            }
            for(int n:map1.keySet()){
                map.put(n,map.getOrDefault(n,0)+1);
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