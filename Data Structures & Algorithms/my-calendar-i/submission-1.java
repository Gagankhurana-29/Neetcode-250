class MyCalendar {
    List<int[]> timings;
    public MyCalendar() {
        timings = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        if(timings.isEmpty()){
            timings.add(new int[]{startTime,endTime});
        }
        else{
            for(int[] a : timings){
                if(!((startTime<a[0] && endTime <=a[0]) || (startTime>=a[1]))){
                    return false;
                }
            }
        }
             timings.add(new int[]{startTime,endTime});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */