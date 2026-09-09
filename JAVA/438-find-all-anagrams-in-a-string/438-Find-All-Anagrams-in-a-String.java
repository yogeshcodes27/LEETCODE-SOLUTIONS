class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res=new ArrayList<>();
        int freq1[]=new int[26];
        int freq2[]=new int[26];
        for(char ch:p.toCharArray())
        freq1[ch-'a']++;
        int left=0;
        for(int right=0;right<s.length();right++){
            freq2[s.charAt(right)-'a']++;
            if(right-left+1>p.length()){
                freq2[s.charAt(left)-'a']--;
                left++;
            }
            if(Arrays.equals(freq1,freq2)){
            res.add(left);
            }
        }
        return res;
    }
}