class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int sum=0;
        int product=1;
        while(temp!=0){
            int dig=temp%10;
            sum+=dig;
            product*=dig;
            temp/=10;
        }
        int tot=sum+product;
        return n%tot==0;
    }
}