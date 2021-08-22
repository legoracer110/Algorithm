package hwalgo02_서울_07반_문성환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA1954_SnailNumber {
	
	static int[][] snail(int size) {
		int[][] arr = new int[size][size];
		boolean[][] check = new boolean[size][size];
		
		int dir = 0;	//	우 : 0  하 : 1  좌 : 2  상 : 3
		int key = 2;	//  넣을 값
		int row = 0;	//	행
		int col = 1;	//	열
		
		arr[0][0] = 1;
		check[0][0] = true;
		
		while(key<=size*size) {
			if(dir==0) {
				if(col+1<=size-1 && check[row][col+1]==false) {
					arr[row][col++]=key;
					check[row][col]=true;
				}else {
					dir = 1;
					arr[row++][col] = key;
					check[row][col] = true;
				}
			}else if(dir==1) {
				if(row+1<=size-1 && check[row+1][col]==false) {
					arr[row++][col]=key;
					check[row][col]=true;
				}else {
					dir = 2;
					arr[row][col--] = key;
					check[row][col] = true;
				}
			}else if(dir==2) {
				if(col-1>=0 && check[row][col-1]==false) {
					arr[row][col--]=key;
					check[row][col]=true;
				}else {
					dir = 3;
					arr[row--][col] = key;
					check[row][col] = true;
				}
			}else if(dir==3) {
				if(row-1>=0 && check[row-1][col]==false) {
					arr[row--][col]=key;
					check[row][col]=true;
				}else {
					dir = 0;
					arr[row][col++] = key;
					check[row][col] = true;
				}
			}
			key++;
		}						
		
		return arr;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(in.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1; i<=tc; i++) {
			sb.append("#").append(i).append("\n");
			
			int size = Integer.parseInt(in.readLine());
			int[][] arr = snail(size);
			
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					sb.append(arr[j][k]).append(" ");
				}
				sb.append("\n");
			}			
			
		}
		
		System.out.println(sb.toString());
	}

}
