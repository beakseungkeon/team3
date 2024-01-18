package university;

import java.util.InputMismatchException;
import java.util.Scanner;

import program.Program;
import university.service.PrintMenu;

public class UniversityProgram implements Program {
	
	PrintMenu pm = new PrintMenu();
	UniversityManage um = new UniversityManage();
	private Scanner scanner = new Scanner(System.in);
	@Override
	public void run() {
		int menu=0;
		do {
			printMenu();
			try {
				menu=scanner.nextInt();
				runMenu(menu);
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				scanner.nextLine();
			}
		}while(menu!=4);
	}

	@Override
	public void printMenu() {
		pm.printMain();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: studentManage(); break;
		case 2: professorManage(); break;
		case 3: Manager(); break;
		default: new InputMismatchException(); break;
		}
	}

	private void studentManage() {
		pm.printSubMenu1();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: break;
		case 2: break;
		default: new InputMismatchException(); break;
		}
	}

	private void professorManage() {
		pm.printSubMenu2();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: break;
		case 2: break;
		case 3: break;
		default: new InputMismatchException(); break;
		}
		
	}

	private void Manager() {
		pm.printSubMenu3();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: printDepartmentMenu(); break;
		case 2: printStudentMenu(); break;
		case 3: break;
		default: new InputMismatchException(); break;
		}
		
	}

	private void printStudentMenu() {
		// TODO Auto-generated method stub
		pm.printSubMenu3_2();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertStudent(); break;
		case 2: updateStudent(); break;
		case 3: removeStudent(); break;
		default: new InputMismatchException(); break;
		}
	}

	private void removeStudent() {
		// TODO Auto-generated method stub
		
	}

	private void updateStudent() {
		// TODO Auto-generated method stub
		scanner.nextLine();
		System.out.println("수정할 학생 이름:");
		String Name=scanner.nextLine();
		System.out.println("새로운 학생 이름");
		String newName=scanner.nextLine();
		System.out.println("새로운 나이:");
		int newAge=scanner.nextInt();
		System.out.println("새로운 학번:");
		int newNum=scanner.nextInt();
		um.ChangeStudent(Name, newName, newAge, newNum);
	}

	private void insertStudent() {
		// TODO Auto-generated method stub
		
	}

	private void printDepartmentMenu() {
		pm.printSubMenu3_1();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertDepartment(); break;
		case 2: updateDepartment(); break;
		case 3: removeDepartment(); break;
		default: new InputMismatchException(); break;
		}
	}

	private void insertDepartment() { //과 등록
		}

	private void updateDepartment() { //과 수정
		scanner.nextLine();
		System.out.println("수정하실 학과 이름:");
		String dpName=scanner.nextLine();
		System.out.println("새로운 학과 이름");
		String newDpName=scanner.nextLine();
		System.out.println("새로운 코드:");
		int newCode=scanner.nextInt();
		um.ChangeDepartment(dpName, newDpName, newCode);
	}

	private void removeDepartment() { //과 삭제
		
	}
}
