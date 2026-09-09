class Solution {
    public int maxVowels(String s, int k) {
        int max=0;
        int count=0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch=s.charAt(right);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
           count++;
            if(right-left+1>k){
                 char ch1=s.charAt(left);
                 if(ch1=='a'||ch1=='e'||ch1=='i'||ch1=='o'||ch1=='u')
                 count--;
                left++;
            }
            max=Math.max(count,max);
        }
        return max;
    }
}