class DynamicArray {
    Integer [] arr;
    int counter=0;
    public DynamicArray(int capacity) {
        arr = new Integer [capacity];
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i]=n;
    }

    public void pushback(int n) {
        if(counter==arr.length){
            resize();
        }
        arr[counter]=n;
        counter++;
    }

    public int popback() {
        int val = arr[counter-1];
        arr[counter-1]=null;
        counter--;
        return val;
    }

    private void resize() {
        int newSize = arr.length *2;
        Integer[] newArr = new Integer [newSize];
        for(int i=0 ;i<arr.length ;i++){
            newArr[i]= arr[i];
        }
        arr = newArr; 
    }

    public int getSize() {
        return counter;
    }

    public int getCapacity() {
        System.out.println(Arrays.toString(arr));
        return arr.length;
    }
}
