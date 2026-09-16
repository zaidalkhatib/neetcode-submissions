class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if(firstList.length==0||secondList.length==0) return new int [][]{};
        List<int []> res = new ArrayList<>();
        int i=0;
        int j=0;
        while(i<firstList.length&&j<secondList.length){
            if(isOverLap(firstList[i],secondList[j])){
                int left = Math.max(firstList[i][0],secondList[j][0]);
                int right = Math.min(firstList[i][1],secondList[j][1]);
                res.add(new int []{left,right});
            }
            if(firstList[i][1]>secondList[j][1]){
                j++;
            }else{
                i++;
            }
        }

        int [][] resArr = new int[res.size()][2];
        for(int k=0 ;k<res.size() ;k++){
            resArr[k]=res.get(k);
        }
        return resArr;
    }

    private boolean isOverLap(int [] a, int [] b){
        int start = Math.max(a[0],b[0]);
        int end = Math.min(a[1],b[1]);
        return start<=end;
    }
}