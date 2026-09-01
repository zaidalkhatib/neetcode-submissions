class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left=1;
        int right = piles[0];
        for(int pile : piles){
            left=Math.min(pile,left);
            right = Math.max(pile,right);
        }
        // System.out.print(left + " "+ right);
        int res=Integer.MAX_VALUE;
        while(left<=right){
            int mid = (left+right)/2;
            System.out.println(mid);
            boolean canFinish = canFinish(mid,piles,h);
            if(canFinish){
                res=Math.min(mid,res);
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    private static boolean canFinish(int k, int [] piles,int h){
        for(int pile : piles){
            // System.out.println("cut "+Math.ceil((double)pile/k)+" h "+h);
            h-=Math.ceil((double)pile/k);
        }
        // System.out.println("h"+h);
        return h>=0;
    }
}
