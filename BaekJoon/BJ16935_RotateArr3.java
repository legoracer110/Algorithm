package hwalgo07_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ16935_RotateArr3 {

	static String input = "6 8 1\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n"
			+ "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "1\n6 8 1\r\n"
			+ "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n" + "2 1 3 8 6 3 9 2\r\n"
			+ "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "2\n6 8 1\r\n" + "3 2 6 3 1 2 9 7\r\n"
			+ "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n" + "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n"
			+ "4 5 1 9 8 2 1 3\r\n" + "3\n6 8 1\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n"
			+ "5 9 2 1 9 6 1 8\r\n" + "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n"
			+ "4\n6 8 1\r\n" + "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n"
			+ "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "5\n" + "6 8 1\r\n"
			+ "3 2 6 3 1 2 9 7\r\n" + "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n" + "2 1 3 8 6 3 9 2\r\n"
			+ "1 3 2 8 7 9 2 1\r\n" + "4 5 1 9 8 2 1 3\r\n" + "6\n" + "6 8 6\r\n" + "3 2 6 3 1 2 9 7\r\n"
			+ "9 7 8 2 1 4 5 3\r\n" + "5 9 2 1 9 6 1 8\r\n" + "2 1 3 8 6 3 9 2\r\n" + "1 3 2 8 7 9 2 1\r\n"
			+ "4 5 1 9 8 2 1 3\r\n" + "1 2 3 4 5 6";

	static String[][] solution(String[][] arr, int N, int M, int cal) {

		if (cal == 1) {
			// 상하 반전

			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M; j++) {
					String tmp = arr[i][j];
					arr[i][j] = arr[N - 1 - i][j];
					arr[N - 1 - i][j] = tmp;
				}
			}
			return arr;

		} else if (cal == 2) {
			// 좌우 반전

			for (int j = 0; j < M / 2; j++) {
				for (int i = 0; i < N; i++) {
					String tmp = arr[i][j];
					arr[i][j] = arr[i][M - 1 - j];
					arr[i][M - 1 - j] = tmp;
				}
			}
			return arr;

		} else if (cal == 3) {
			// 오른쪽 90도

			String[][] rotateArr = new String[M][N];
			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					rotateArr[i][j] = arr[j][i];
				}
			}

			return solution(rotateArr, M, N, 2);

		} else if (cal == 4) {
			// 왼쪽 90도 (반시계)

			String[][] rotateArr = new String[M][N];

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < N; j++) {
					rotateArr[i][j] = arr[j][i];
				}
			}

			return solution(rotateArr, M, N, 1);
		} else if (cal == 5) {
			// 배열을 4등분의 부분배열 후, 시계방향으로 이동

			String[][] rotateArr = new String[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i < N / 2) {
						if (j < M / 2) {
							rotateArr[i][j] = arr[i + N / 2][j];
						} else {
							rotateArr[i][j] = arr[i][j - M / 2];
						}
					} else {
						if (j < M / 2) {
							rotateArr[i][j] = arr[i][j + M / 2];
						} else {
							rotateArr[i][j] = arr[i - N / 2][j];
						}
					}
				}
			}

			return rotateArr;
		} else if (cal == 6) {
			// 배열을 4등분의 부분배열 후, 반시계방향으로 이동

			String[][] rotateArr = new String[N][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (i < N / 2) {
						if (j < M / 2) {
							rotateArr[i][j] = arr[i][j + M / 2];
						} else {
							rotateArr[i][j] = arr[i + N / 2][j];
						}
					} else {
						if (j < M / 2) {
							rotateArr[i][j] = arr[i - N / 2][j];
						} else {
							rotateArr[i][j] = arr[i][j - M / 2];
						}
					}
				}
			}

			return rotateArr;
		}

		return arr;
	}

	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

//		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int R = Integer.parseInt(st.nextToken()); // 연산 시행 횟수

		String[][] arr = new String[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = st.nextToken();
			}
		}

		int[] commands = new int[R];

		st = new StringTokenizer(in.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int cal = Integer.parseInt(st.nextToken());
			commands[i] = cal;
		}

		for (int i = 0; i < R; i++) {
			arr = solution(arr, arr.length, arr[0].length, commands[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}

		System.out.println(sb.toString());
	}
}
