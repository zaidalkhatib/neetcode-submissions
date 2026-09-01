class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < speed.length; i++) {
            list.add(new Pair(position[i],speed[i]));
        }
        Collections.sort(list,(a,b)->b.position-a.position);
        Stack<Double> stack = new Stack<>();
        for(int i=0 ;i<list.size() ;i++){
            double timeToFinish = ((double)(target-list.get(i).position))/list.get(i).speed;
            stack.push(timeToFinish);
            if(stack.size()>=2&&stack.peek()<=stack.get(stack.size()-2)){
                stack.pop();
            }
        }
        return stack.size();
    }

    public static class Pair {
        int position;
        int speed;
        public Pair(int position, int speed) {
            this.position = position;
            this.speed = speed;
        }
    }
}
