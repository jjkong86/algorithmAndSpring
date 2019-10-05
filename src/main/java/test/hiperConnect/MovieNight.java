package test.hiperConnect;

import java.util.*;
import java.text.SimpleDateFormat;

public class MovieNight {
    public static Boolean canViewAll(Collection<Movie> movies) {
    	ArrayList<Movie> list = (ArrayList<Movie>) movies;
    	Collections.sort(list);
    	for (int i = 1; i < list.size(); i++) {
    		if (list.get(i-1).getEnd().getTime() > list.get(i).getStart().getTime()) {
//    			System.out.println(list.get(i-1).getEnd().getTime());
//    			System.out.println(list.get(i).getStart().getTime());
    			return false;
    		}
		}
        return true;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
        movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));
        
        System.out.println(MovieNight.canViewAll(movies));
    }
}

class Movie implements Comparable<Movie>{
    private Date start, end;
    
    public Movie(Date start, Date end) {
        this.start = start;
        this.end = end;
    }
    
    public Date getStart() {
        return this.start;
    }
    
    public Date getEnd() {
        return this.end;
    }
    
    @Override
    public int compareTo(Movie o) {
    	return Long.compare(start.getTime(), o.getStart().getTime());
    }
}
