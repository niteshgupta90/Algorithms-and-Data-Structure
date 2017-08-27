//Given Coordinates. Find the container which contains the most water.
public class Solution {
    public int maxArea(int[] height) {
        int area = 0 , val = 0;
        int l = 0;
        int r = height.length-1;
        while(l<r)
        {
            val = Math.min(height[l],height[r]) * (r-l);
            if(area<val)
                area =  val;
            if(height[l]<height[r])
                l++;
            else
                r--;
        }
        return area;
    }
}
