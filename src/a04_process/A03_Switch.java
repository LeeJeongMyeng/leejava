package a04_process;

import java.util.Scanner;

public class A03_Switch {

	public static void main(String[] args) {
		// 1. if문과 switch는 어떠한 상황에서 구분하여 처리하는가?
		// 2. 반복문은 프로그램에서 어떠한 기능을 수행하고 있을까?
		// 3. 반복문의 형식에 따라 어떤 특성을 가지고 있는가?
		
		// #주요핵심
		// 1. for(초기; 반복조건; 증감연산자),
		// while(조건), do{}while(조건):
		
		// 2. break, continue
		// 3.  반복문에서 나머지 연산자(%)처리
		
		//ex) 4지 선다 문제 정답을 입력하고
         //정답일 경우만 정답표시, 그외는 오답표시처리하세요
		Scanner sc01 = new Scanner(System.in);
		System.out.print("정답을 입력하세요");
        int num02 = sc01.nextInt();
        System.out.println("입력 번호:"+num02);
        switch (num02) {
            case 1:  
            
            case 2:   
            case 4:  
            	System.out.println("오답입니다");
            	
            break;
                    
            case 3:  System.out.println("정답입니다");
                     break;
           
                     default : System.out.println("잘못입력하셨습니다:");
                     break;
        }
        
        
        Scanner sc02 = new Scanner(System.in);
		System.out.print("월을 입력하세요");
		int num03 = sc02.nextInt();
		switch (num03) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:System.out.println("31일 입니다");
        		break;
		case 4:
		case 6:
		case 9:
		case 11:System.out.println("30일 입니다");
        		break;
		case 2:System.out.println("28일 입니다");
        		break;
		default : System.out.println("잘못입력하셨습니다:");
        		break;
		
		}

	}

	}
