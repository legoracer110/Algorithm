package hwalgo15_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759_암호만들기 {

	static String input = "4 6\r\n" + "a t c i s w";

	static int L;
	static int C;
	static char[] cha;
	static boolean[] visited;

	static void solution(StringBuilder sb, char start, int cnt, int m, int j) {

		if (cnt == L) {
			if (m >= 1 && j >= 2)
				System.out.println(sb.toString());

			return;
		}

		for (int i = 0; i < C; i++) {
			if (!visited[i] && cha[i] > start) {
				sb.append(cha[i]);
				visited[i] = true;
				if (cha[i] == 'a' || cha[i] == 'e' || cha[i] == 'i' || cha[i] == 'o' || cha[i] == 'u')
					solution(sb, cha[i], cnt + 1, m + 1, j);
				else
					solution(sb, cha[i], cnt + 1, m, j + 1);
				sb.deleteCharAt(sb.length() - 1);
				visited[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");

		StringBuilder sb = new StringBuilder();

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		cha = new char[C];
		visited = new boolean[C];

		st = new StringTokenizer(in.readLine(), " ");

		for (int i = 0; i < C; i++) {
			cha[i] = st.nextToken().charAt(0);
		}

		Arrays.sort(cha);

		for (int i = 0; i < C; i++) {
			sb.append(cha[i]);
			visited[i] = true;
			if (cha[i] == 'a' || cha[i] == 'e' || cha[i] == 'i' || cha[i] == 'o' || cha[i] == 'u')
				solution(sb, cha[i], 1, 1, 0);
			else
				solution(sb, cha[i], 1, 0, 1);
			sb.deleteCharAt(sb.length() - 1);
			visited[i] = false;
		}
	}

}
