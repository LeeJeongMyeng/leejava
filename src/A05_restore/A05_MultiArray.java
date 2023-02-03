package A05_restore;

public class A05_MultiArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			/*
			 # 다차원 배열
			 1. 2차원 배열 이상의 배열을 말한다.
			  	- 수학의 행렬과 같은 자료구조
			  	
			 2. 자바는 1차원 배열을 이용해 2차원 배열 구현한다.
			 	int[][]scores = new int[2][3]; 
			 	scores[0][0] = 1000;
			 	scores[0][1] = 2000;
			 	scores[0][2] = 3000;
			 	scores[1][0] = 4000;
			 	scores[1][1] = 5000;
			 	scores[1][2] = 6000;
			 3. 2차원 배열의 선언/할당
			 1차원- int[] price = {1000,2000,3000};
			 2차원 - int[][] prices = {{1000,2000,3000},{4000,5000,6000}};
			 */
		//기차의 구조
		String[][] trains = new String[6][70];
		//1호차에 1번좌석
		trains[0][0]="★";
		//2호차에 3번좌석
		trains[1][2]="★";
		for(int idx=0;idx<trains.length;idx++) {
			System.out.println(idx+1+"호차");
			//각호차 좌석 번호
			for(int idx2=0;idx2<trains[idx].length;idx2++) {
			System.out.print(idx2+1+"번 "+trains[idx][idx2]+" ");
			}
		}
		System.out.println();
		
		//ex) 고등학교 1~3학년, 1~10반을 2차원 배열로 선언하여
		//		각 반에 학생을 기본값을 30명씩 할당하여 처리
int[][] sutgrade1 = new int[3][10];	
	
	for(int idx3=0;idx3<sutgrade1.length;idx3++) {
		System.out.println("\n"+(idx3+1)+"학년");
		for(int idx4=0;idx4<sutgrade1[idx3].length;idx4++) {
			sutgrade1[idx3][idx4]=30;
			System.out.print(idx4+1+"반-"+sutgrade1[idx3][idx4]+"명, ");
		}	
	}
	
	// ex) 3개 부서별로 팀원 3명씩 할당된 내용을 2차원 배열로로 나타내세요.
		String[][] team = {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		for(int idx5=0;idx5<team.length;idx5++) {
			System.out.println(idx5+1+"팀====");
			for(int idx6=0;idx6<team[idx5].length;idx6++) {
				System.out.println("이름 : "+team[idx5][idx6]);
			}
		}
	}

}
