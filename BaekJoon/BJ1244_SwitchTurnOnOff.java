package hwalgo01_서울_07반_문성환;

import java.util.Scanner;
public class BJ1244_SwitchTurnOnOff {
	
	private static void display_arr(int[] arr) {
		for(int i=1; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
			if(i%20==0)
				System.out.println();
		}
	}
	
	private static int[] changeSwitch(int[] switches, int sex, int num) {
		int[] results = switches;
		if(sex==1) {
			for(int i=1; i<results.length; i++) {
				if(i%num==0) {
					if(results[i]==0)
						results[i]=1;
					else
						results[i]=0;
				}
			}
			
		}else if(sex==2) {
			if(results[num]==0)
				results[num]=1;
			else
				results[num]=0;
			
			for(int i=1; i<results.length; i++) {
				if(num+i>=results.length || num-i <= 0 
						|| results[num+i]!=results[num-i]) {
					break;
				}				
				
				
				if(results[num+i]==0)
					results[num+i]=1;
				else
					results[num+i]=0;
				
				if(results[num-i]==0)
					results[num-i]=1;
				else
					results[num-i]=0;
				
			}
		}
		
		return results;
	}

	public static void main(String[] args) {
		
		int[] switches;	//	스위치 상태 배열
		int numOfStudents = 0;
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		switches = new int[num+1];
		
		for(int i=1; i<num+1; i++)
			switches[i]=sc.nextInt();
		
		numOfStudents = sc.nextInt();
		
		for(int i=0; i<numOfStudents; i++) {
			int sex = sc.nextInt();
			int number = sc.nextInt();
			switches = changeSwitch(switches, sex, number);
		}
		
		display_arr(switches);
		
		
	
	}

}
