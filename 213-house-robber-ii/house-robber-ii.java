class Solution {
    public int solve(int[] nums,int s,int e){
        int len = e -s +1;
        if(len==1) return nums[s];
        if(len==2) return Math.max(nums[s],nums[s+1]);
        int[] dp = new int[len];
        dp[0] = nums[s];
        dp[1] = Math.max(nums[s],nums[s+1]);
        for(int i =2;i<len;i++){
            int loot = nums[s+i] + dp[i-2];
            int notloot = dp[i-1];
            dp[i] = Math.max(loot,notloot);
        }
        return dp[len-1];
    }

    public int rob(int[] nums) {
        int  n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int pos1 = solve(nums,0,n-2);
        int pos2 = solve(nums,1,n-1);

        return Math.max(pos1,pos2);
    
    }
}