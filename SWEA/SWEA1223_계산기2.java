package hwalgo14_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class SWEA1223_계산기2 {

	static String input = "101\r\n"
			+ "9+5*2+1+3*3*7*6*9*1*7+1+8*6+6*1*1*5*2*4*7+4*3*8*2*6+7*8*4*5+3+7+2+6+5+1+7+6+7*3*6+2+6+6*2+4+2*2+4*9*3\r\n"
			+ "79\r\n" + "4+4*3*4*9+2+7*4*7+7*7*9*5*2+8*8+2*6*7*3*7*9*3*4+8+8*9+3+9+6+9+4*1+6*3+5+1+7+5*1\r\n"
			+ "113\r\n"
			+ "2+3+9*9+8+2*1+3*2*3*1+3*3+1+2+3*6*2*7*4+9+1+4+6+9*9*5+7+8+6+3+9*2+1+7+4+3+9*3*1+4*4+4*3*1+9*3+9*5*1*7*8+2+8+8*7+9\r\n"
			+ "89\r\n" + "4*9+1+1*8+8*9*7+1*4*5*2*5+8*3*5+5+2*4+2+8+6*2*2+9+3*1*2+2*5+9*2*3*9+6+7*9+9*4+7+6+6*6+3+8\r\n"
			+ "77\r\n" + "5+4+9+9*9*2+6*6*5+9+3*5+5*7*8*3*7*1*9*9+8+3+8*9*6+2*9*3+6*5+6*7*2+5+5*3+4*6+7\r\n" + "119\r\n"
			+ "5+7+1+6+3+6*7+7+5*5*3*5*6*9+5*9*5*9+8+8+5*1*6*2+3+2+8+6+2+2*3*4+5*8*3*6*2*9+1*7*7*4*2+2*5+6+7+2*7*4+9*6*4*3*1*3*5+3*7+8\r\n"
			+ "115\r\n"
			+ "8*6+3*9*8*7*6*3+5*7*6*6+3*5+2*4*9*3+5+2+1*4*1*7+6*8+9+3+2+8*3+8*2+6*9+2*2*7+8*1*2+9*3+1+5*5*8+4*1*2*4*2*6*3*8*8+4+1\r\n"
			+ "91\r\n"
			+ "5*8*4+5*7+9*2+6+5*7+1*7*9+8+6*1*2+7+5*9*6*3+4*8*9*6*1*3+7*1+2+5+1*4*9+6*4+7*1*2*4*2+3+3*4+9\r\n"
			+ "107\r\n"
			+ "7*1+7+5+3*7*1*7+8*3*8+7+3*2*6*2+3+6*4+3+8+9*4+1+5*7*8+9+1+2+5+6*7+4*5*2+4+8*4+7+9*1*3*1+1*2*8+3+2+9*1*5*9+7\r\n"
			+ "109\r\n"
			+ "1+1+7+3*2+1+3*7*8+9*6+1+8*3*7+8*5*7*7+4*3*7*4+7+3+2*2+7+8*8*6+6*6*7+7*1*5*7+3+1*5+1*8*4+9+6+7*5+3+1*8*8*9+4+7\r\n"
			+ "";

	static String input2 = "9\r\n3+4+5*6+7\n";

	static int length;
	static String str;

	static Stack<Integer> num;
	static Stack<Character> sign;

	static int answer = 0;

	static void solution() {

		num = new Stack<Integer>();
		sign = new Stack<Character>();

		int index = 0;
		boolean popCheck = false;

		while (index < length) {
			char c = str.charAt(index);

			if (c == '*' || c == '/' || c == '+' || c == '-') {
				// 기호면
				sign.push(c);
				if (c == '*' || c == '/') {
					// 곱셈이나 나눗셈이면 다음 숫자 뽑을 준비
					popCheck = true;
				}
			} else {
				// 아니면 (숫자)
				int tmpInt = Integer.parseInt(String.valueOf(c));

				if (popCheck) {
					char tmpC = sign.pop();
					if (tmpC == '*') {
						tmpInt *= num.pop();
					} else if (tmpC == '/') {
						tmpInt = num.pop() / tmpInt;
					}
					num.push(tmpInt);
					popCheck = false;
				} else {
					num.push(tmpInt);
				}
			}

			index++;
		}

//		System.out.println(num.toString());
//		System.out.println(sign.toString());

		while (true) {

			if (sign.isEmpty()) {
				answer += num.pop();
				break;
			}

			char tmpC = sign.pop();
			if (tmpC == '+') {
				answer += num.pop();
			} else {
				answer -= num.pop();
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");
			answer = 0;

			length = Integer.parseInt(in.readLine());
			str = in.readLine();

			solution();

			sb.append(answer).append("\n");
		}

		System.out.println(sb.toString());
	}

}
