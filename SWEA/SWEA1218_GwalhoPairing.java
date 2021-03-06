package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Stack;

public class SWEA1218_GwalhoPairing {

	static String input = "182\r\n"
			+ "(({<(({{[[[[<<[[(<[[{([{{{[<[[[{<<(<[[{}[]{}{}[]]]><><>{})[]{}><>[]<>><>}][]]<>{}]>]()}()()(){}}}{}][])(){}<>()}]{}[]]>()[][][]){}]]{}[]<>><>{}[]{}<>>]]]][]{}{}[]()}}))>}<>{}()))[][]\r\n"
			+ "298\r\n"
			+ "{({{[({([{(<[([(([<({[{{[[({{[({([<{(<[[(<((<[{[<[([((<{{[([{<<[{(<({[<{}()>[]<>][]})>[])<>()[]}]>><>(){}()[]}]{}()<>[]<>)<>{}<>{}{}]}()}<>>)[]){}])]>[][]{}]()}][]()>[]))[]>)]][]>)[]{}}[]<><>>]()[])}{}){}]}}<><>){}][]{}{}]<>[]}(){}<>}][]})[]()><>]))])]>{}{}())}{}])<>}{})]{}{}}[])())<>{}[]<><>}[]{}\r\n"
			+ "230\r\n"
			+ "[({([<[<[<<(([{([<((({<{([{[<[<<<([<[<([[{([<[{({([<(<[[][]]<>{}<>[]>){}{}<>>]{}())})}[]]{}>[][][]]()[][]<><>()<>){}}]])[][][]>]>()](){}[])>>><><>{}]>]{}[]}<>][]())}[][]>}<>)()))>{}[]()])[][]}]<>()<>))>>()][]>][][]>]())}<><>{}<>)]\r\n"
			+ "226\r\n"
			+ "[[[{{[[<[([((([({{[{<<([[[([[{<[{{<{[<[([<<<((([{(<({<([(<><>){}])()[]>}<>())>){}}]))){}>()<><>>>[]]<>)]>]{}()}(){}>()<><>}}]()>}<>{}]])<>{}]()(){}][]()])[]{}(){}<>>[]>}{}{}](){}}})()])(){}<>))][])[]()<>]<><>>]()][]{}}}[]]]]()\r\n"
			+ "242\r\n"
			+ "((([<[{{<[<{<{({(({({({<{{{((([{[({[{<{{(([[{([{<<({<[]>}){}[]()()>>}[][]()][]<>){}<>}]]))}[]}()><>[]}(){}]()[][][]})]<>}{}<>](){}){}){})<><><>{}<>[]}}<>{}{}}{}[]>{}}(){}){}<>})}))[]})()}>[]{}{}()}>]>{}[][][][]}}][][][]{}<>>][])()[]))()()[]{}\r\n"
			+ "138\r\n"
			+ "{[<(({[{(({[(({{{]{<[([[({[[[[<>]]]{}]{}})]]()<>{}{}<>()<>)()<>{}[]<>]>{}})<>()<><><>}{}}}())){}]}))}()<>()[]{}]})<><><><>)>[][][]]}<>[]{}\r\n"
			+ "238\r\n"
			+ "{<[[({[([{{(({{((<({(<{{([<{<([((<<(<{[<<([{{[<[{<{{{[<[{<{[[]]}()[][]}()}]>]}{}{}}<>[]<>{}(){}}>}]{}{}><>[]]}[]{}()[]{}}]{}())()<><>()>>]()<>}>{}[])<>()>>()))()])>{}}>])}{}{}}>)()<>[]}){}>)<>)()}}())){}<>()}[][]}]){}<>[]<>]}[])]()]()>}<>\r\n"
			+ "272\r\n"
			+ "([{[<[[([([{[[([[({([(<[[[<{(({<([{([{<{[<<((({(<{<[({<{<<([[{<[[{{[<(([{}])<>)[]>]()<>}<>}[]]]{}()>}][]]{})<>{}[]>>}>{}<>}{})()]<>><>}[][]>)<>{}}[]<>))){}[]>>[]]}[]>}][])[]}]())>[]{}{}}[]{}))}>(){}[]{}]<>{}]]()>)<><><><>[]])}{})[]()]])]]}])<>][]{}<>)()]<><>()]>]<>}<>()])\r\n"
			+ "218\r\n"
			+ "[{({[<{[<{[[[<[{[[[[{([{[<[[<<[{{((<[([[<[(<[({}[]<>[]()[]()(){}){})<>()>[][]<>[])<><>[](){}[]{}<>]><>]])]>[]){}<>)[][]}}<><>()<>]<>><>{}>[]<>]{}]>]<>}]{}())[]}[]]<>]]]}]()>]<>(){}]()<>()]()}>{}<>]{}}>]()[]()[]})()}]()\r\n"
			+ "258\r\n"
			+ "({{[({<{<<{{([[<{({{{[[({[<(<{<<{<<{{{{([{[{<{{[<<[[[<[{<(<[({(<>)})]><>[])()>{}}[]]{}<>><>]]]<>>{}>]}{}[]}>}]<>[]}]){}<>{}}[]}}}{}<>>>}>[]><><>()<>[]}><>)><><><>]}){}]]<>[]<>}[]<>{}}}()<>)}<>{}[]>][]{}])<>[][]{}}()}>[]<>>}<><>>()}{}<><>[]()())<>]}{}{}[]}[])\r\n"
			+ "";

	private static int checkByStack(int size, String str) {
		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < size; i++) {
			if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[' || str.charAt(i) == '<') {
				stack.push(str.charAt(i));
			} else if (str.charAt(i) == ')') {
				if (stack.lastElement() != '(') {
					return 0;
				}
				stack.pop();
			} else if (str.charAt(i) == '}') {
				if (stack.lastElement() != '{') {
					return 0;
				}
				stack.pop();
			} else if (str.charAt(i) == ']') {
				if (stack.lastElement() != '[') {
					return 0;
				}
				stack.pop();
			} else if (str.charAt(i) == '>') {
				if (stack.lastElement() != '<') {
					return 0;
				}
				stack.pop();
			}

		}

		return 1;
	}

	private static int checkByArr(int size, String str) {

		int[] gwalho = new int[4];
		// ???????????? ( [ { <

		for (int i = 0; i < size; i++) {
			if (str.charAt(i) == '(') {
				gwalho[0]++;
			} else if (str.charAt(i) == '[') {
				gwalho[1]++;
			} else if (str.charAt(i) == '{') {
				gwalho[2]++;
			} else if (str.charAt(i) == '<') {
				gwalho[3]++;
			}
			///////////////////////////
			else if (str.charAt(i) == ')') {
				gwalho[0]--;
				if (gwalho[0] < 0)
					return 0;
			} else if (str.charAt(i) == ']') {
				gwalho[1]--;
				if (gwalho[1] < 0)
					return 0;
			} else if (str.charAt(i) == '}') {
				gwalho[2]--;
				if (gwalho[2] < 0)
					return 0;
			} else if (str.charAt(i) == '>') {
				gwalho[3]--;
				if (gwalho[3] < 0)
					return 0;
			}
		}

		return 1;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10; i++) {
			sb.append("#").append(i).append(" ");

			int size = Integer.parseInt(in.readLine());
			String str = in.readLine();

			sb.append(checkByArr(size, str)).append("\n");
		}

		System.out.println(sb.toString());
	}

}
