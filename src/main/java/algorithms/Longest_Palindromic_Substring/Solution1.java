package algorithms.Longest_Palindromic_Substring;

public class Solution1 {
	public String test(String s) {
		s = "abcaacb";
		int start, end, len;            
        String o ="";            
        String r ="";                        
        int Result= 0;
        int L = s.length();
        
        for(int i=0; i< L; i++){                
            for(int j = L-1; j>i; j--){                    
                start = i;                    
                end = j;                    
                len = 0;                    
 
                o = s.substring(start, end);                    
                r = reverse(o);                                        
 
                if(o.equals(r)){                         
                    len = end - start + 1;                        
                    System.out.println(r + " " + o);                        
                    System.out.println(start + " " + end + " " + len);                    
                 }
                if(len >= 3 && len > Result){                        
                    Result= len;                    
                }
            }            
        }

		
		return Result;
	}
	public static String reverse(String o){        
        return new StringBuffer(o).reverse().toString();    
    }
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		System.out.println();
	}
}
