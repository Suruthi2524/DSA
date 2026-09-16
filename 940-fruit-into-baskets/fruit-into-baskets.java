class Solution {
    public int totalFruit(int[] fruits) {
        int n= fruits.length;
        int l=0;
        int r=0;
        int max=0;
        HashMap<Integer,Integer> basket = new HashMap();
        while(r<n){
            basket.put(fruits[r],basket.getOrDefault(fruits[r],0)+1);
            if(basket.size() >2){
                basket.put(fruits[l],basket.get(fruits[l])-1);
            // basket.put(fruits[l],basket.getOrDefault(fruits[l],0)-1);
            if(basket.get(fruits[l]) ==0){
                basket.remove(fruits[l]);
            }
            l++;
            }
            int len = r-l+1;
            if(max < len) max=len;
            r++;
        }
        return max;
    }
}