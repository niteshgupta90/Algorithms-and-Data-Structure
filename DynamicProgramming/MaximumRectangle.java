//Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int nRow = matrix.length;
        if(nRow==0){
            return 0;
        }
        int nCol = matrix[0].length;
        int curArea = 0;
        int[] height = new int[nCol];
        
        for(int i=0;i<nCol;i++){
            if(matrix[0][i]=='0')
                height[i] = 0;
            else
                height[i] = 1;
        }
        
        curArea  = largestRectangleArea(height);
        if(curArea>maxArea){
            maxArea = curArea;
        }
        for(int i=1;i<nRow;i++){
            for(int j=0;j<nCol;j++){
                if(matrix[i][j]=='1'){
                    height[j] += 1;
                }
                else{
                    height[j]=0;
                }
            }
            curArea  = largestRectangleArea(height);
            if(curArea>maxArea){
                maxArea = curArea;
            }
        }
        return maxArea;
    }
    
    
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
