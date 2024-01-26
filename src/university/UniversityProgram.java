package university;

import java.util.InputMismatchException;
import java.util.Scanner;
import Program.Program;
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
		case 4: break;
		default: new InputMismatchException(); break;
		}
		
	}

	private void Manager() {
		pm.printSubMenu3();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: printDepartmentMenu(); break;
		case 2: printStudentMenu(); break;
		case 3: printProfessorMenu(); break;
		default: new InputMismatchException(); break;
		}
		
	}

	private void printProfessorMenu() {
		pm.printSubMenu3_3();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertProfessor(); break;
		case 2: updateProfessor(); break;
		case 3: removeProfessor(); break;
		case 4: showProfessor(); break;
		default: new InputMismatchException(); break;
		}
	}

	private void insertProfessor() {
		
	}

	private void updateProfessor() {
		scanner.nextLine();
		System.out.println("수정할 교수 이름:");
		String Name=scanner.nextLine();
		System.out.println("새로운 교수 이름");
		String newName=scanner.nextLine();
		System.out.println("새로운 나이:");
		int newAge=scanner.nextInt();
		System.out.println("새로운 교번:");
		int newNum=scanner.nextInt();
		um.ChangeProfessor(Name, newName, newAge, newNum);	
		
	}

	private void removeProfessor() {
		
		
	}

	private void showProfessor() {
		
		
	}

	private void printStudentMenu() {
		pm.printSubMenu3_2();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertStudent(); break;
		case 2: updateStudent(); break;
		case 3: removeStudent(); break;
		case 4: showStudent(); break;
		default: new InputMismatchException(); break;
		}
	}

	private void showStudent() {
		
	}

	private void insertStudent() {
		scanner.nextLine();
		System.out.println("등록할 학생 이름:");
		String name=scanner.nextLine();
		System.out.println("나이:");
		int age=scanner.nextInt();
		System.out.println("학번:");
		int num=scanner.nextInt();
		System.out.println("학과:");
		String department=scanner.nextLine();
		People std = new People(name, age, num, department, null);
		um.InsertStudent(std);
	}

	private void updateStudent() {
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

	private void removeStudent() {
		System.out.print("삭제할 학생의 학번을 입력하세요 : ");
		int num = scanner.nextInt();
		if(um.removeStd(num)) {
			System.out.println("정상적으로 삭제되었습니다.");
			return;
		}
		System.out.println("삭제 실패");
		
	}

	private void printDepartmentMenu() {
		pm.printSubMenu3_1();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertDepartment(); break;
		case 2: updateDepartment(); break;
		case 3: removeDepartment(); break;
		case 4: showDepartment(); break;
		default: new InputMismatchException(); break;
		}
	}

	private void showDepartment() {
		
	}

	private void insertDepartment() {
		scanner.nextLine();
		System.out.println("등록할 학과명:");
		String dpName=scanner.nextLine();
		System.out.println("학과 코드:");
		int code=scanner.nextInt();
		Department dp = new Department(dpName, code, null, null);
		um.InsertDepartment(dp);
	}

	private void updateDepartment() {
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
		//과 목록에 값이 존재하지 않으면 입력되어 있는 과가 없습니다 출력
		System.out.println("---과 목록---");
		System.out.print("[");
		for(int i=0; i<um.department.size(); i++) {
			System.out.print(um.department.get(i).name+",  ");
		}
		System.out.print("]");
		System.out.print("\n삭제할 과의 이름을 입력하세요 : ");
		String user = scanner.next();
		if(um.removeDepartment(user)) {
			System.out.println("정상적으로 삭제되었습니다.");
			return;
		}
		System.out.println("입력 오류");
	}
	
}
