//Median of Two Sorted Arrays

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        
        if(len1 == 0){
            return getMedian(nums2,len2);
        }
        if(len2 == 0){
            return getMedian(nums1,len1);
        }
        if(len1<=len2)
            return findMedian(nums1,nums2,nums1.length,nums2.length);
        else
            return findMedian(nums2,nums1,nums2.length,nums1.length);
        
    }
    
    public double findMedian(int[] nums1, int[] nums2, int len1, int len2) {
        
        
        if(len1==1 && len2 ==1){
            return (nums1[0]+nums2[0])/2.0;
        }
        
        if(len1==1 && (len2%2==1)){
            return (getMedianOfThree(nums1[0],nums2[len2/2-1],nums2[len2/2+1])+nums2[len2/2])/2.0;
        }
        
        if(len1==1 && (len2%2==0)){
            return getMedianOfThree(nums1[0],nums2[len2/2-1],nums2[len2/2]);
        }
        
        if(len1 == 2 && len2 == 2){
            return getMedianOfFour(nums1[0],nums2[0],nums1[1],nums2[1]);
        }
        
        if(len1==2 && (len2%2==1)){
            return getMedianOfThree(Math.max(nums1[0],nums2[len2/2-1]),Math.min(nums1[1],nums2[len2/2+1]),nums2[len2/2]);
        }
        
        if(len1 == 2 && (len2%2==0)){
            return getMedianOfFour(Math.max(nums1[0],nums2[len2/2-2]),Math.min(nums1[1],nums2[len2/2+1]),nums2[len2/2],nums2[len2/2-1]);
        }
        
        int m1 = (len1-1)/2 ;
        int m2 = (len2-1)/2 ;
        
        
        if(nums1[m1]<=nums2[m2]){
            int[] new1 = Arrays.copyOfRange(nums1, m1, len1);
            return findMedian(new1,nums2,len1/2+1,len2-m1);
        }
        
        else{
            int[] new2 = Arrays.copyOfRange(nums2, m1, len2);
            return findMedian(nums1,new2,len1/2+1,len2-m1);
        }
        
    }
    
    public double getMedian(int[] arr, int len){
        if(len%2==1)
            return arr[len/2] ;
        else
            return (arr[len/2 - 1]+arr[len/2])/2.0;
        
    }
    
    public double getMedianOfThree(int a, int b, int c){
        return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
    }
    
    public double getMedianOfFour(int a, int b, int c, int d)
    {
        int Max = Math.max( a, Math.max( b, Math.max( c, d ) ) );
        int Min = Math.min( a, Math.min( b, Math.min( c, d ) ) );
        return ( a + b + c + d - Max - Min ) / 2.0;
    }
    
}
