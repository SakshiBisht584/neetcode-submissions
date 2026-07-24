class Solution {
    public int maxArea(int[] heights) {
        int i=0; 
        int j=heights.length-1;
        int area=0;
        while(i<j){
            int l=j-i;
            int b=Math.min(heights[i],heights[j]);
            area=Math.max(area,l*b);
            if(heights[i]<heights[j]) i++;
            else if(heights[i]>heights[j]) j--;
            else{
                i++;
                j--;
            }
        }
        return area;
    }
}
