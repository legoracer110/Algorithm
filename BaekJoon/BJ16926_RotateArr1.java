package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class BJ16926_RotateArr1 {

	static String input = "4 4 2\n1 2 3 4\n5 6 7 8\n9 10 11 12\n13 14 15 16\n";

	static int[] dx = { 0, 1, 0, -1 }; // 우상좌하
	static int[] dy = { 1, 0, -1, 0 };

	static void showArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static int[][] rotate(int N, int M, int[][] arr, int count) {
		if (count == 0) {
			return arr;
		}

		int[][] rotateArr = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (i >= M - j - 1 && i < N - 1) {
					// 위로 이동
					rotateArr[i][j] = arr[i + 1][j];
				}
				if (i > j && i <= N - j - 1) {
					// 아래로 이동
					rotateArr[i][j] = arr[i - 1][j];
				}
				if (i < N / 2) {
					// 절반 기준 위쪽 행
					if (j >= i && j < M - i - 1) {
						// 왼쪽으로 이동
						rotateArr[i][j] = arr[i][j + 1];
					}
				} else {
					// 절반 기준 아래쪽 행
					if (j >= N - i && j <= M - N + i) {
						// 오른쪽으로 이동
						rotateArr[i][j] = arr[i][j - 1];
					}
				}

			}
		}

		rotateArr = rotate(N, M, rotateArr, count - 1);

		return rotateArr;
	}

	static int[][] solution2(int N, int M, int arr[][], int rot) {
		int group = Math.min(N, M) / 2;

		int[][] answer = arr;

		for (int i = 0; i < rot; i++) {
			// 회전 횟수
			for (int j = 0; j < group; j++) {
				// 그룹 개수만큼
				int n = j;
				int m = j;

				int value = arr[n][m];
				int dir = 0; // 방향 : 하우상좌 순

				while (dir < 4) {
					int x = n + dx[dir];
					int y = m + dy[dir];

					if (x >= j && y >= j && x < N - j && y < N - j) {
						answer[n][m] = answer[x][y];
						n = x;
						m = y;
					} else
						dir++;
				}
				answer[j + 1][j] = value;
			}
		}

		return answer;
	}

	static int[][] solution3(int[][] arr, int y, int x, int d, int l, int c, int N, int M) {
		int cur = arr[y][x];
		arr[y][x] = l;
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (d == 3 && (ny == c && nx == c))
			return arr;
		if (ny >= c && ny < N - c && nx >= c && nx < M - c && !(ny == c && nx == c)) {
			arr = solution3(arr, ny, nx, d, cur, c, N, M);
		} else if (d + 1 < 4) {
			ny = y + dy[d + 1];
			nx = x + dx[d + 1];
			if (d == 3 && (ny == c && nx == c))
				return arr;
			arr = solution3(arr, ny, nx, d + 1, cur, c, N, M);
		}
		return arr;
	}

	private static int[][] solution4(int[][] arr, int N, int M) {

		int num = Math.min(N, M);

		for (int i = 1; i <= num; i++) {
			// 네모들의 왼쪽 맨위의 좌표는 1,1 || 2,2 || 3,3 || ...
			int x = i;
			int y = i;
			int temp = arr[x][y]; // 첫번째 값을 담아놓고 연산 후에 넣어준다.

			int index = 0;

			while (index < 4) {

				int nx = x + dx[index];
				int ny = y + dy[index];

				if (nx < i || ny < i || nx > N - i + 1 || ny > M - i + 1) {
					index++;
				} else {
					System.out.println(x + "/" + y);
					arr[x][y] = arr[nx][ny];

					x = nx;
					y = ny;
				}

			}
			arr[i + 1][i] = temp;
		}
		return arr;

	}

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int rot = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][M + 1];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		for (int i = 0; i < rot; i++)
//			arr = solution4(arr, N, M);

		arr = rotate(N, M, arr, rot);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
