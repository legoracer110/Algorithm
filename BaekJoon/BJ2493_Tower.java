package hwalgo04_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ2493_Tower {

	// 아예 예제 입력값 써주기
	private static String input = "5\n6 9 5 7 4";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// 이 부분은 위에 input 받아오는거니까 안 받아오고 실행할거면 주석 달면 댐
		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(in.readLine());

		StringTokenizer st = new StringTokenizer(in.readLine());

		Stack<Integer> heights = new Stack<Integer>();
		Stack<Integer> indexStack = new Stack<Integer>();

		int first = Integer.parseInt(st.nextToken());
		heights.push(first);
		indexStack.push(1);
		sb.append("0 ");

		for (int i = 1; i < N; i++) {
			int tmp = Integer.parseInt(st.nextToken());

			while (!heights.isEmpty()) {
				if (tmp < heights.peek()) {
					sb.append(indexStack.peek() + " ");
					break;
				}
				heights.pop();
				indexStack.pop();
			}
			if (heights.isEmpty()) {
				sb.append("0 ");
			}
			heights.push(tmp);
			indexStack.push(i + 1);
		}
		System.out.println(sb.toString());
	}

}
