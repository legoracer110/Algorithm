package hwalgo13_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_BJ1987_Alphabet {

	static String input1 = "2 4\r\n" + "CAAB\r\n" + "ADCB";

	static String input2 = "3 6\r\n" + "HFDFFB\r\n" + "AJHGDH\r\n" + "DGAGEH";

	static String input3 = "5 5\r\n" + "IEFCJ\r\n" + "FHFKC\r\n" + "FFALF\r\n" + "HFGCF\r\n" + "HMCHH";

	static int R;
	static int C;
	static char[][] map;
	static boolean[][] visited;

	static ArrayList<Character> moveList;

	static int answer = 0;

	static boolean checkAvailable(char c, ArrayList<Character> m) {

		if (m.contains(c))
			return false;

		return true;
	}

	static void solution(int x, int y, int cnt, ArrayList<Character> moveList) {

		if (x - 1 >= 0 && !visited[x - 1][y] && checkAvailable(map[x - 1][y], moveList)) {
			moveList.add(map[x - 1][y]);
			visited[x - 1][y] = true;
			solution(x - 1, y, cnt + 1, moveList);

			moveList.remove(moveList.size() - 1);
			visited[x - 1][y] = false;
		}
		if (x + 1 < R && !visited[x + 1][y] && checkAvailable(map[x + 1][y], moveList)) {
			moveList.add(map[x + 1][y]);
			visited[x + 1][y] = true;
			solution(x + 1, y, cnt + 1, moveList);

			moveList.remove(moveList.size() - 1);
			visited[x + 1][y] = false;
		}
		if (y - 1 >= 0 && !visited[x][y - 1] && checkAvailable(map[x][y - 1], moveList)) {
			moveList.add(map[x][y - 1]);
			visited[x][y - 1] = true;
			solution(x, y - 1, cnt + 1, moveList);

			moveList.remove(moveList.size() - 1);
			visited[x][y - 1] = false;

		}
		if (y + 1 < C && !visited[x][y + 1] && checkAvailable(map[x][y + 1], moveList)) {
			moveList.add(map[x][y + 1]);
			visited[x][y + 1] = true;
			solution(x, y + 1, cnt + 1, moveList);

			moveList.remove(moveList.size() - 1);
			visited[x][y + 1] = false;
		}

		answer = Math.max(answer, cnt);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input2));

		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		moveList = new ArrayList<Character>();

		for (int i = 0; i < R; i++) {
			String str = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		moveList.add(map[0][0]);

		solution(0, 0, 1, moveList);

		System.out.println(answer);
	}

}
