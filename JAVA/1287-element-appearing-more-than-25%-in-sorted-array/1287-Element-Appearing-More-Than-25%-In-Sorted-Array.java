class Solution {
    public int findSpecialInteger(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:arr){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(int n: map.keySet()){
            if(map.get(n)>arr.length/4)
            return n;
        }
        return -1;

    }
}