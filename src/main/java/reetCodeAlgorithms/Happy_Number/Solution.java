package reetCodeAlgorithms.Happy_Number;

import java.util.HashSet;
import java.util.Set;
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 0 && n != 1) {
            int temp = 0;
            while (n != 0) {
                temp += (n%10)*(n%10);
                n /= 10;
            }
            n = temp;
            if (set.contains(n)) {
                return n == 1;
            }
            set.add(n);
            //System.out.println(n);
        }
        
        return n == 1;
    }
}
