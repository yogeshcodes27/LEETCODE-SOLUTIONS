class Solution {
    public boolean areOccurrencesEqual(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int val=map.get(s.charAt(0));
        for(char ch:map.keySet()){
            if(map.get(ch)!=val)
            return false;
            val=map.get(ch);
        }
        return true;    }
}