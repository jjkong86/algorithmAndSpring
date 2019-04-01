package codewars.Molecule_to_atoms;

import java.util.Map;
import java.util.HashMap;

class ParseMolecule {

	public static Map<String,Integer> getAtoms(String formula) {
    	  // Mg(OH)2 -> M -> g -> 소문자? -> Mg -> ( -> Mg=1, OH -> ) -> 숫자? -> OH * 숫자
        // 소문자는 Character.isLowerCase();
        // ) ] 나오면 문자열의 처음부터 검색하여 (와 [ 를 찾아서 map replace 해주면 될듯
        
        Map<String, Integer> map = new HashMap<>();
        int len = formula.length();
        for (int i=0; i<len; i++) {
          char c = formula.charAt(i);
          if (Character.isUpperCase(c)) {
            if (i != len -1 && Character.isLowerCase(formula.charAt(i+1))) {
              map.put(formula.substring(i, i+2), 1);
              continue;
            }
            map.put(String.valueOf(c), 1);
          } else if (Character.isLowerCase(c)) {
            if (i == 0) {
               throw new NumberFormatException();
            }
          } else if (inNumberic(String.valueOf(c))) {
            
          } else if (c == '(') {
          
          } else if (c == '[') {
          
          } else if (i == 0 && Character.isLowerCase(c)) {
          
          }
          
        }
        
        
        
        return new HashMap<String,Integer>();
    }

	public static boolean inNumberic(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
