class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        LinkedList<int[]> list = new LinkedList<>();
        boolean inserted=false;
        for(int [] interval : intervals){
            if(!inserted&&newInterval[0]<=interval[0]){
                list.add(newInterval);
                list.add(interval);
                inserted=true;
            }else{
                list.add(interval); 
            }
        }
        // System.out.print(list);
        if(!inserted){
            list.add(newInterval);
            inserted=true;
        }
        
        LinkedList<int[]> list2 = new LinkedList<>();

        for(int [] interval : list){
            if(list2.isEmpty()){
                list2.addLast(interval);
            }else if(isOverLap(list2.getLast(),interval)){
                list2.getLast()[0]=Math.min(list2.getLast()[0],interval[0]);
                list2.getLast()[1]=Math.max(list2.getLast()[1],interval[1]);
            }else{
                list2.addLast(interval);
            }
        }

        int [] [] res = new int [list2.size()][2];
        int index=0;
        for(int[] interval : list2){
            res[index++]=interval;
        }
        return res;
    }

    private static boolean isOverLap(int [] a, int [] b){
        int start =Math.max(a[0],b[0]);
        int end = Math.min(a[1],b[1]);
        return start<=end;
    }
}
