//Trapping Rain Water
public class Solution {
    public int trap(int[] height) {
        int[] area = new int[height.length];
        int res = 0;
        int index = 0, val = 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        if(height.length==0 ||height.length==1)
            return 0;
        while(i<height.length-1 && height[i]<=height[i+1]){
            i++;
        }
        while(i<height.length){
            if(s.isEmpty() || height[i]<=height[(int)s.peek()])
            {
                s.push(i++);
            }
            else if(height[i]>height[(int)s.peek()]){
                while(!s.isEmpty()){
                    if(height[i]>=height[(int)s.peek()])
                        index = (int)s.pop();
                    else {
                        index = (int)s.peek();
                        break;
                    }
                }
                area[i] = getArea(height,i,index,s,area);
                s.push(i++);
            }
            
        }
        for(i=0;i<height.length;i++)
            res+=area[i];
        return res;
    }
    
    public int getArea(int[] height, int i, int j, Stack s, int[] area){
        int rainArea = 0;
        int buildingArea = 0;
        int prevArea = 0;
        for(int k = j+1;k<i;k++){
            buildingArea += height[k];
            prevArea += area[k];
        }
        
        rainArea = s.isEmpty()?(height[j]*(i-j-1)):(height[i]*(i-j-1));
        return rainArea-buildingArea-prevArea;
    }
}
