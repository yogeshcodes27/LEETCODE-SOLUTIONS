class Solution {
    public int maxArea(int[] height) {
        int width=0;
        int i=0;
        int j=height.length-1;
        int maxarea=0;
        int h=0;
        while(i<j){
            width=j-i;
            h=Math.min(height[i],height[j]);
            maxarea=Math.max(maxarea,h*width);
            if(height[i]<height[j])
            i++;
            else 
            j--;
        }
        return maxarea;

        
    }
}