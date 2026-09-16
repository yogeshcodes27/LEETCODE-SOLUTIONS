class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
        return "";
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        
        for(char c:t.toCharArray()){
            map1.put(c,map1.getOrDefault(c,0)+1);
        }
        int left=0;
        int start=0;
        int minlen=Integer.MAX_VALUE;
        for(int right=0;right<s.length();right++){
            map2.put(s.charAt(right),map2.getOrDefault(s.charAt(right),0)+1);
            boolean valid=true;
            for(char c:map1.keySet()){
                if(map2.getOrDefault(c,0)<map1.get(c)){
                    valid=false;
                    break;
                }
            }
            while(valid){
                if(right-left+1<minlen){
                    minlen=right-left+1;
                    start=left;
                }
                map2.put(s.charAt(left),map2.get(s.charAt(left))-1);
                left++;
                valid=true;
                for(char c:map1.keySet()){
                    if(map2.getOrDefault(c,0)<map1.get(c)){
                          valid=false;
                          break;
                    }
                }
            }
        }
         return minlen!=Integer.MAX_VALUE?s.substring(start,start+minlen):"";
      
    }
}