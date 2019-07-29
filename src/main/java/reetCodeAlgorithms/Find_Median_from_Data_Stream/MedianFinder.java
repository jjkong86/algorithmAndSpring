package reetCodeAlgorithms.Find_Median_from_Data_Stream;

import java.util.*;
class MedianFinder {

    /** initialize your data structure here. */
    List<Integer> list;
    
    public MedianFinder() {
        this.list = new ArrayList<>();
    }
    
    public void addNum(int num) {
        list.add(num);
    }
    
    public double findMedian() {
        int size = list.size();
        if (size == 0) return 0.0d;
        
        int mid = size/2;
        return size%2 == 0 ? 
            Double.valueOf((list.get(mid) + list.get(mid-1)))/2 : list.get(mid);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
