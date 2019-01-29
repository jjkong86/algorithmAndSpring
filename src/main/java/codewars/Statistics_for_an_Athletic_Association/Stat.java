package codewars.Statistics_for_an_Athletic_Association;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Stat {
	static SimpleDateFormat formatter = new SimpleDateFormat("HH|mm|ss");

	public static String stat(String strg) {
		// your code
		long[] array = formatterDate(strg);
		int len = array.length;

		String avg = calAvg(array);
		String range = calRange(array, len);
		String median = calMedian(array, len);

		return new StringBuilder().append("Range: ").append(range).append(" Average: ").append(avg).append(" Median: ").append(median).toString();
	}

	public static long[] formatterDate(String str) {
		long[] array = Stream.of(str.split(", ")).mapToLong(i -> {
			try {
				return formatter.parse(i).getTime();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			return 0;
		}).toArray();
		Arrays.sort(array);
		return array;
	}

	public static String calAvg(long[] array) {
		return formatter.format(LongStream.of(array).average().getAsDouble());
	}

	public static String calRange(long[] array, int len) {
		long standard = 0;
		try {
			standard = formatter.parse("00|00|00").getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return formatter.format(array[len - 1] < 0 ? array[len - 1] - array[0] + standard
				: array[len - 1] - array[0]);
	}

	public static String calMedian(long[] array, int len) {
		return formatter.format(len % 2 == 0 ? (array[len / 2] + array[len / 2 - 1]) / 2 : array[len / 2]);
	}
}
