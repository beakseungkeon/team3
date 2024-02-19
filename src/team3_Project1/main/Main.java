package team3_Project1.main;

import java.util.Scanner;

import team3_Project1.controller.BoardLogin;
import team3_Project1.controller.memberController.FindId;
import team3_Project1.controller.memberController.FindPw;
import team3_Project1.controller.memberController.JoinMember;

public class Main {

	private static BoardLogin boardLogin;
	private static JoinMember joinMember;
	private static FindId findId;
	private static FindPw findPw;
	
	public static void main(String[] args) {
		int menu;
		Scanner scan = new Scanner(System.in);
		boardLogin = new BoardLogin(scan);
		joinMember = new JoinMember(scan);
		findId = new FindId(scan);
		findPw = new FindPw(scan);
		do {
			printMenu();
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu != 5);
	}
	private static void printMenu() {
		System.out.println("-----메뉴-----");
		System.out.println("1. 로그인");
		System.out.println("2. 아이디 찾기");
		System.out.println("3. 비밀번호 찾기");
		System.out.println("4. 회원가입");
		System.out.println("5. 프로그램 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
	}
	private static void runMenu(int menu) {
		switch(menu) {
		case 1:
			boardLogin.run();
			break;
		case 2:
			findId.run();
			break;
		case 3:
			findPw.run();
			break;
		case 4:
			joinMember.run();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 메뉴입니다.");
		}
	}
}
