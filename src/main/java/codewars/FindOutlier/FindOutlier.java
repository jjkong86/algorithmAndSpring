package codewars.FindOutlier;

import java.util.ArrayList;
import java.util.List;

public class FindOutlier {
	static int find(int[] integers){
	    List<Integer> evenList = new ArrayList<>();
	    List<Integer> oddList = new ArrayList<>();
	    for (int i=0; i<integers.length; i++) {
		  int temp = integers[i];
	      if(temp % 2 == 0) {
	        evenList.add(integers[i]);
	      } else {
	        oddList.add(integers[i]);
	      }
	    }
	    if (evenList.size() == 1) {
	      return evenList.get(0);
	    } else {
	      return oddList.get(0);
	    }
	}
}
