package com.ssafy.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class SWEA3289_disjoint {

	static String input = "1\r\n" + "7 8\r\n" + "0 1 3\r\n" + "1 1 7\r\n" + "0 7 6\r\n" + "1 7 1\r\n" + "0 3 7\r\n"
			+ "0 4 2\r\n" + "0 1 1\r\n" + "1 1 1\r\n" + "";

	static int T;
	static int n, m;
	static int[] parents;

	static int find(int num) {
		if (num == parents[num])
			return num;
		return parents[num] = find(parents[num]);
	}

	static void union(int num1, int num2) {
		int root1 = find(num1);
		int root2 = find(num2);

		if (root1 == root2)
			return;

		parents[root2] = root1;
	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		T = Integer.parseInt(in.readLine());

		StringBuilder sb = new StringBuilder();

		// 0 1 3 : 1이 포함된 집합과 3이 포함된 집합을 합침
		// 1 2 4 : 2와 4가 같은 집합에 포함되어 있는지 확인 (0:아님, 1:같음)

		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n + 1];
			for (int i = 0; i < n; i++) {
				parents[i] = i; // 시작할 땐 집합 대표자 자기 자신 (집합 사이즈 1)
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(in.readLine(), " ");
				int key = Integer.parseInt(st.nextToken());
				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());

				if (key == 0) {
					union(num1, num2);
				} else {
					if (find(num1) == find(num2))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
