class Solution {
    public int longestOnes(int[] nums, int k) {
      int n = nums.length;
      int max =0;
      for(int i=0; i<n; i++){
        int zero=0;
        int j=0;
        for(j=i; j<n; j++){
            if(nums[j]==0) zero++;
            if(zero>k) break;
        }
        int len =j-i;
        if(len>max) max= len;
      }  
      return max;
    }
}