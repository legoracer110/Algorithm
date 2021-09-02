package hwalgo05_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA9229_SpotMart {

	static String input = "4\r\n" + "3 45\r\n" + "20 20 20\r\n" + "6 10\r\n" + "1 2 5 8 9 11\r\n" + "4 100\r\n"
			+ "80 80 60 60\r\n" + "4 20\r\n" + "10 5 10 16\r\n" + "";

	static int solution(int[] snacks, int limit, int total, int cnt, int index) {
		int answer = total;

		if (total > limit) {
			return -1;
		}

		if (cnt == 2) {
			return answer;
		}

		if (index >= snacks.length)
			return -1;

		answer = solution(snacks, limit, total, cnt, index + 1);

		int tmp = solution(snacks, limit, total + snacks[index], cnt + 1, index + 1);

		if (tmp > answer)
			answer = tmp;

		return answer;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		int testCase = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= testCase; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken()); // 과자 종류
			int M = Integer.parseInt(st.nextToken()); // 무게 제한

			int[] snacks = new int[N];

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}

			sb.append(solution(snacks, M, 0, 0, 0)).append("\n");
		}
		System.out.println(sb.toString());
	}

}
