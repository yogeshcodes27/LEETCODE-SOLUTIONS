class Solution {
    public int countGoodSubstrings(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int left=0;
        int count=0;
        for(int right=0;right<s.length();right++){
            map.put(s.charAt(right),map.getOrDefault(s.charAt(right),0)+1);
            if(right-left+1==3){
                if(map.size()==3){
                    count++;
                }
                map.put(s.charAt(left),map.get(s.charAt(left))-1);
                if(map.get(s.charAt(left))==0)
                map.remove(s.charAt(left));
                
                left++;
            }
        }
        return count;
    }
}