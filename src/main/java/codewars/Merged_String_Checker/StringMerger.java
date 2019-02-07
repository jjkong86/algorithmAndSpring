package codewars.Merged_String_Checker;

public class StringMerger {

	public static boolean isMerge(String s, String part1, String part2) {
		System.out.println(s + "::" + part1 + "::" + part2);
		if (s == null || s.equals(""))
			return false;

		int len = s.length();
		int part1Index = 0;
		int part2Index = 0;
		int sucessFlag = 0;
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (part1.length() > part1Index && c == part1.charAt(part1Index)) {
				part1Index++;
			} else if (part2.length() > part2Index && c == part2.charAt(part2Index)) {
				part2Index++;
			} else {
				return false;
			}
			sucessFlag++;
		}
		System.out.println(sucessFlag + "::" + len);
		System.out.println(sucessFlag == len);
		return sucessFlag == len;
	}
}
