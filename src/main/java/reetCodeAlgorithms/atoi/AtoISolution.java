package reetCodeAlgorithms.atoi;

public class AtoISolution {
	
	public int myAtoi(String str) {
		
		return 0;
    } 
	
	public static void main(String[] args) {
		String str = "419332222222222222222222222222  ";
		int ret = 0;
		boolean flag = true;
		for (int i = 0; i < str.length(); i++) {
			String tempStr = "";
			tempStr = str.substring(i, i+1);
			if (!tempStr.equals(" ") && !tempStr.equals("-")) {
				
				try {
					if(ret*10 + Integer.valueOf(tempStr) > Integer.MAX_VALUE/10) {
						ret = Integer.MAX_VALUE;
						break;
					} else if (!flag && ret*10 + Integer.valueOf(tempStr)*(-1) < Integer.MIN_VALUE/10) {
						ret = Integer.MIN_VALUE*10;
						break;
					}
					ret = ret*10 + Integer.valueOf(tempStr);
				} catch (NumberFormatException e) {
					break;
				}
			} else if (tempStr.equals("-")) {
				flag = false;
			}
		}
		if (!flag) {
			ret *= (-1);
		}
		
		System.out.println(ret + "::"+flag);
	}

}
