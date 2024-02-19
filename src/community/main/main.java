package community.main;

import java.util.Scanner;

import community.controller.MemberController;

public class main {
	private static MemberController memberController=new MemberController();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int menu;
		Scanner scan = new Scanner(System.in);
		do {
			printMenu();
			menu=scan.nextInt();
			runMenu(menu);
		}while(menu !=5);
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:memberController.run();
		break;
		case 2:System.out.println("프로그램을 종료합니다");
		break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
		
	}

	private static void printMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.시작");
		System.out.println("2.프로그램 종료");
		System.out.println("메뉴 선택:");
	}

}
