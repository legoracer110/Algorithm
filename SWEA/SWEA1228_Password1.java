package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

class PW {
	public String data;
	public PW link;

	public PW(String data) {
		super();
		this.data = data;
	}

	public PW(String data, PW link) {
		this(data);
		this.link = link;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
}

class PWLinkedList {
	private PW head;

	public PW getLastPW() {
		for (PW currPW = head; currPW != null; currPW = currPW.link) {
			if (currPW.link == null) {
				return currPW;
			}
		}
		return null;
	}

	public void insertIndex(int index, String data) {
		PW tmp = head;
		for (int i = 0; i < index; i++) {
			tmp = tmp.link;
		}
		PW newPW = new PW(data, tmp.link);
		tmp.link = newPW;
	}

	public void addLastNode(String data) {
		if (head == null) {
			PW pw = new PW(data, head);
			head = pw;
		}

		PW lastPW = getLastPW();
		PW newPW = new PW(data);

		lastPW.link = newPW;
	}

	public void printList() {
		System.out.print("L = ( ");
		for (PW currPW = head; currPW != null; currPW = currPW.link) {
			System.out.print(currPW.data + " ");
		}
		System.out.println(" ) ");
	}

	public String TopTen() {
		StringBuilder sb = new StringBuilder();
		PW currPW = head;
		// sb.append(head.data).append(" ");
		for (int i = 1; i <= 10; i++) {
			head = head.link;
			sb.append(head.data).append(" ");
		}
		return sb.toString();
	}
}

public class SWEA1228_Password1 {

	static String input = "11\r\n" + "449047 855428 425117 532416 358612 929816 313459 311433 472478 589139 568205 \r\n"
			+ "7\r\n"
			+ "I 1 5 400905 139831 966064 336948 119288 I 8 6 436704 702451 762737 557561 810021 771706 I 3 8 389953 706628 552108 238749 661021 498160 493414 377808 I 13 4 237017 301569 243869 252994 I 3 4 408347 618608 822798 370982 I 8 2 424216 356268 I 4 10 512816 992679 693002 835918 768525 949227 628969 521945 839380 479976 \r\n"
			+ "19\r\n"
			+ "566753 244528 233616 328235 268163 292641 646305 944392 643695 385788 444752 939244 637877 325283 779273 712343 953523 846222 204307 \r\n"
			+ "5\r\n"
			+ "I 0 4 600576 565945 486128 594841 I 0 1 150706 I 8 8 556294 697547 932203 845517 116062 300371 621038 358830 I 10 8 747039 701738 805438 502654 476665 919177 367272 859931 I 15 3 844423 973297 658751 \r\n"
			+ "13\r\n"
			+ "451142 546015 819803 736474 501825 922551 132847 325303 352270 405801 443509 695840 793145 \r\n"
			+ "8\r\n"
			+ "I 9 3 317716 271430 214233 I 12 10 586547 213477 791036 913924 155028 547823 355341 992986 350549 223108 I 0 3 973313 438559 139738 I 3 2 948108 703906 I 6 9 885653 293849 568546 969155 635245 266286 826549 816653 886264 I 1 6 271510 434200 132826 186343 308937 115088 I 19 4 589129 732043 598989 724153 I 39 4 710782 753918 310897 705557 \r\n"
			+ "12\r\n" + "505428 811504 283809 983962 248330 314510 258537 739809 487960 266514 941766 641216 \r\n"
			+ "5\r\n"
			+ "I 4 3 113251 177288 894062 I 8 7 685426 394121 192542 996838 883266 275726 320872 I 2 9 655028 878767 259061 870009 141255 898646 151553 145048 799412 I 11 4 176705 614463 574755 318804 I 2 3 426664 713940 855599 \r\n"
			+ "10\r\n" + "136495 493509 581882 909420 644512 224052 159772 514304 122892 293858 \r\n" + "9\r\n"
			+ "I 8 7 870665 974627 336123 806823 745062 774397 683618 I 7 7 558732 233785 690180 275194 802243 120772 537301 I 7 6 268202 638180 120263 873814 540718 276318 I 5 10 203665 803288 627905 344928 785272 115937 413820 304013 241809 583597 I 11 4 857040 502150 737198 406670 I 8 9 424999 837878 312467 133061 134122 494506 547280 521067 751583 I 2 7 670789 236851 328354 715849 446182 646977 613629 I 0 10 267162 670435 488135 605710 353909 276272 171102 871819 129966 404856 I 43 8 375211 311612 265847 723489 772383 711086 813635 413043 \r\n"
			+ "19\r\n"
			+ "192530 407162 909225 286381 776616 949894 746578 808786 200965 908553 576477 912147 641753 303286 495887 117431 857217 515544 436621 \r\n"
			+ "5\r\n"
			+ "I 17 1 596183 I 3 1 863939 I 13 6 455605 422698 325250 408276 960386 125073 I 6 8 258181 756295 622123 704788 635995 611599 579332 584033 I 2 4 275094 303667 851080 385930 \r\n"
			+ "16\r\n"
			+ "136752 320395 397751 875871 683248 914031 813127 105151 151221 182983 748572 953449 333014 455760 153890 478409 \r\n"
			+ "5\r\n"
			+ "I 5 3 246614 942192 856739 I 9 8 556177 806231 209447 640911 890791 353133 688959 963159 I 26 9 433189 527293 737167 765206 659027 906523 357518 827329 183639 I 26 1 921567 I 20 6 783145 931290 140925 603375 111230 227818 \r\n"
			+ "19\r\n"
			+ "482032 121855 272889 730597 443510 894923 944094 332358 589171 633923 520438 570121 685086 323759 332002 127786 629597 118031 274202 \r\n"
			+ "8\r\n"
			+ "I 10 2 239617 740373 I 1 3 117720 663070 616591 I 1 2 518037 497171 I 14 10 105810 380829 163741 168086 882017 741655 132383 941037 298987 785919 I 3 7 841413 364367 572438 104109 354943 999898 765480 I 10 4 815600 953791 681560 525427 I 19 6 455389 405185 965143 804071 825501 687238 I 2 3 513679 145989 422525 \r\n"
			+ "10\r\n" + "438278 128145 818986 814573 158221 243776 483819 441179 351925 920976 \r\n" + "6\r\n"
			+ "I 7 10 834448 349208 140538 477525 114044 182045 967418 483789 589082 528694 I 9 5 884704 641228 918396 822546 678301 I 4 4 812165 774081 789114 205230 I 22 3 151633 893912 202312 I 4 3 692305 541108 569934 I 15 7 403269 476915 186572 990364 448678 726973 237037 \r\n"
			+ "17\r\n"
			+ "376463 344210 520543 173961 644251 888643 564430 812181 501113 579019 976154 231393 225736 760717 684571 271257 500013 \r\n"
			+ "5\r\n"
			+ "I 8 1 141946 I 9 1 199979 I 0 1 596308 I 14 3 719634 168119 401905 I 7 3 787798 136503 153477 \r\n" + "";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		in = new BufferedReader(new StringReader(input));

		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			sb.append("#").append(tc).append(" ");

			int size = Integer.parseInt(in.readLine());

			StringTokenizer st = new StringTokenizer(in.readLine(), " ");

			PWLinkedList pl = new PWLinkedList();

			for (int i = 0; i < size; i++) {
				pl.addLastNode(st.nextToken());
			}
			int numCmd = Integer.parseInt(in.readLine());

			st = new StringTokenizer(in.readLine(), " ");
			for (int i = 0; i < numCmd; i++) {
				st.nextToken();
				int index = Integer.parseInt(st.nextToken());
				int counts = Integer.parseInt(st.nextToken());

				for (int j = 0; j < counts; j++) {
					pl.insertIndex(index + j, st.nextToken());
				}

			}

			sb.append(pl.TopTen());
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
