package codility.train.test;

public class StringLength {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < 1000; i++) {
			sb.append('a');
			sb.append('b');
			sb.append('a');
		}
		System.out.println(sb.length());
	}
}