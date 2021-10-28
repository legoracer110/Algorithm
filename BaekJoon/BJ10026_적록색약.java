package hwalgo17_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

public class BJ10026_적록색약 {

	static String input = "5\r\n" + "RRRBB\r\n" + "GGBBB\r\n" + "BBBRR\r\n" + "BBRRR\r\n" + "RRRRR";

	static int size;
	static char[][] map1;
	static char[][] map2;

	static boolean[][] visited;//

	static int cnt1;
	static int cnt2;

	static void dfs(boolean isPatient, int x, int y) {

		if (!isPatient) {
			if (x - 1 >= 0 && !visited[x - 1][y] && map1[x][y] == map1[x - 1][y]) {
				visited[x - 1][y] = true;
				dfs(false, x - 1, y);
			}
			if (x + 1 < size && !visited[x + 1][y] && map1[x][y] == map1[x + 1][y]) {
				visited[x + 1][y] = true;
				dfs(false, x + 1, y);
			}
			if (y - 1 >= 0 && !visited[x][y - 1] && map1[x][y] == map1[x][y - 1]) {
				visited[x][y - 1] = true;
				dfs(false, x, y - 1);
			}
			if (y + 1 < size && !visited[x][y + 1] && map1[x][y] == map1[x][y + 1]) {
				visited[x][y + 1] = true;
				dfs(false, x, y + 1);
			}
		} else {
			if (x - 1 >= 0 && !visited[x - 1][y] && map2[x][y] == map2[x - 1][y]) {
				visited[x - 1][y] = true;
				dfs(true, x - 1, y);
			}
			if (x + 1 < size && !visited[x + 1][y] && map2[x][y] == map2[x + 1][y]) {
				visited[x + 1][y] = true;
				dfs(true, x + 1, y);
			}
			if (y - 1 >= 0 && !visited[x][y - 1] && map2[x][y] == map2[x][y - 1]) {
				visited[x][y - 1] = true;
				dfs(true, x, y - 1);
			}
			if (y + 1 < size && !visited[x][y + 1] && map2[x][y] == map2[x][y + 1]) {
				visited[x][y + 1] = true;
				dfs(true, x, y + 1);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(input));

		size = Integer.parseInt(in.readLine());
		map1 = new char[size][size];
		map2 = new char[size][size];
		visited = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			String line = in.readLine();
			for (int j = 0; j < size; j++) {
				map1[i][j] = line.charAt(j);
				if (map1[i][j] == 'G')
					map2[i][j] = 'R';
				else
					map2[i][j] = map1[i][j];
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j]) {
					cnt1++;
					visited[i][j] = true;
					dfs(false, i, j);
				}
			}
		}

		visited = new boolean[size][size];

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (!visited[i][j]) {
					cnt2++;
					visited[i][j] = true;
					dfs(true, i, j);
				}
			}
		}

		sb.append(cnt1).append(" ").append(cnt2);

		System.out.println(sb.toString());
	}

}
