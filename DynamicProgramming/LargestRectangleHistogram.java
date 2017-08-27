//Largest Rectangle in Histogram
class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int len = heights.length;
        if(len==0)
            return 0;
        int[] leftLimit = new int[len];
        int[] rightLimit = new int[len];
        int[] area = new int[len];
        
        List<Integer> list = new LinkedList<Integer>();
        
        leftLimit[0] = -1;
        rightLimit[len-1] = len;
        
        for(int i=1;i<len;i++){
            int index = i-1;
            while(index>=0 && heights[index]>=heights[i]){
                index = leftLimit[index];
            }
            leftLimit[i] = index;
        }
        for(int i=len-2;i>=0;i--){
            int index = i+1;
            while(index<len && heights[index]>=heights[i]){
                index = rightLimit[index];
            }
            rightLimit[i] = index;
        }
        for(int i=0;i<len;i++){
            maxArea = Math.max(maxArea, heights[i]*(rightLimit[i] - leftLimit[i] - 1) );
        }
        return maxArea;
    }
}
