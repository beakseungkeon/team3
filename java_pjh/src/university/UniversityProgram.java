package university;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
		case 1: stdLectureManage(); break;
		case 2: showStdScore(); break; //성적조회 - 학번 입력 받으면 자신이 수강중인 과목의 성적 나열
		default: new InputMismatchException(); break;
		}
	}
	
	private void stdLectureManage() {
		pm.printSubMenu1_1();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertStdLecture(); break; //수강신청
		case 2: removeStdLecture(); break; //수강신청취소
		default: new InputMismatchException(); break;
		}
		
	}

	private void insertStdLecture() { //수강신청
		System.out.print("학번을 입력해주세요 : ");
		int stdNum = scanner.nextInt();
		System.out.println("[현재 신청 가능한 강의 목록]");
		for(int i=0; i<um.lecture.size(); i++) {
			System.out.println("강의명 : " + um.lecture.get(i).name + "  |강의코드 : " + um.lecture.get(i).code);
		}
		System.out.print("신청할 강의코드를 입력해주세요 : ");
		int lectureCode = scanner.nextInt();
		if(um.insertStdLecture(stdNum, lectureCode)){
			System.out.println("수강신청완료");
			return;
		}
		System.out.println("수강신청실패");
		
	}

	private void removeStdLecture() { //수강신청취소
		System.out.print("학번을 입력해주세요 : ");
		int stdNum = scanner.nextInt();
		System.out.println("[현재 취소 가능한 강의 목록]");
		for(int i=0; i<um.lecture.size(); i++) {
			if(um.lecture.get(i).score.containsKey(stdNum)) {
				System.out.println("강의명 : " + um.lecture.get(i).name + "  |강의코드 : " + um.lecture.get(i).code);
			}
		}
		System.out.print("취소할 강의코드를 입력해주세요 : ");
		int lectureCode = scanner.nextInt();
		if(um.removeStdLecture(stdNum, lectureCode)) {
			System.out.println("수강신청취소완료");
			return;
		}
		System.out.println("취소실패");
	}

	private void showStdScore() { //학생(개인) 성적 조회 & 수강중인 강의목록을 전체조회(성적이 없더라도 조회 됨)
		System.out.print("학번을 입력해주세요 : ");
		int stdNum = scanner.nextInt();
		for(int i=0; i<um.lecture.size(); i++) {
			if(um.lecture.get(i).score.containsKey(stdNum)) {
				System.out.println("["+ um.lecture.get(i).name + " : " +um.lecture.get(i).score.get(stdNum) + "점]");
			}
		}
	}

	private void professorManage() {
		pm.printSubMenu2();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: lectureManage(); break; //강의관리<--이거먼저
		case 2: scoreManage(); break; //성적관리
		case 3: departmentList(); break; //특정 학과 조회 기능 (관리자 조회는 전체 학과 조회)
		default: new InputMismatchException(); break;
		}
		
	}

	private void lectureManage() {
		pm.printSubMenu2_1();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertLecture(); break; //강의 등록
		case 2: updateLecture(); break; //강의 수정
		case 3: removeLecture(); break; //강의 삭제
		case 4: showLecture(); break;   //강의 조회
		default: new InputMismatchException(); break;
		}
		
	}

	private void insertLecture() { //강의등록
		System.out.print("강의를 등록하시려는 교수님의 교번을 입력해주세요 : ");
		int num = scanner.nextInt();
		System.out.print("등록하려는 강의의 이름을 입력해주세요 : ");
		String name = scanner.next();
		if(um.insertLecture(num, name)) {
			System.out.println("입력 완료");
			return;
		}
		System.out.println("입력 오류");
	}

	private void updateLecture() { //강의수정
		System.out.print("수정하시려는 강의의 코드를 입력해주세요 : ");
		int code = scanner.nextInt();
		System.out.print("수정될 강의의 이름을 입력해주세요 : ");
		String name = scanner.next();
		if(um.updateLecture(code, name)) {
			System.out.println("수정 성공");
			return;
		}
		System.out.println("수정 실패");
	}

	private void removeLecture() { //강의삭제
		System.out.print("강의를 삭제하시려는 교수님의 교번을 입력해주세요 : ");
		int num = scanner.nextInt();
		for(int i=0; i<um.lecture.size(); i++) {
			System.out.println(um.lecture.get(i).name + " : " + um.lecture.get(i).code + "\n");
		}
		System.out.print("삭제하시려는 강의의 코드를 입력해주세요 : ");
		int code = scanner.nextInt();
		if(um.removeLecture(num, code)) {
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}
	
	private void showLecture() { //일부 강의 조회
		for(int i=0; i<um.lecture.size(); i++) {
			int num = um.lecture.get(i).proCode; //담당교수의 교번
			People pnum = new People(num);
			int index = um.professor.indexOf(pnum);
			String proName = um.professor.get(index).name;//담당교수의 이름
			System.out.println("강의이름 : " + um.lecture.get(i).name + "  |강의 코드 : " + um.lecture.get(i).code + "  |담당교수 : " + proName);
		}
	}

	private void scoreManage() {
		pm.printSubMenu2_2();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertScore(); break; //성적 등록/수정
		case 2: removeScore(); break; //성적 삭제
		case 3: showScore(); break; //성적 조회
		default: new InputMismatchException(); break;
		}
		
	}

	private void insertScore() {
		/*
		 * 교번입력받기
		 * 입력받은 교번의 교수님이 담당하는 강의와 강의코드 출력
		 * 입력할 강의의 코드 입력하기
		 * 입력받은 강의를 수강중인 학생의 이름과 학번출력
		 * 성적을 입력받을 학생의 학번 입력받기
		 * 입력할 성적 입력받기 
		 */
		System.out.print("교수님의 교번을 입력해주세요 : ");
		int num = scanner.nextInt();
		if(!um.checkNum(1, num)) {
			System.out.println("해당교번의 교수가 존재하지 않습니다.");
			return;
		}
		System.out.println("담당중인 강의 : ");
		for(int i=0; i<um.lecture.size(); i++) {
			if(um.lecture.get(i).proCode==num) {
				System.out.println(um.lecture.get(i).name + " : " + um.lecture.get(i).code);
			}
		}
		System.out.print("성적을 입력/수정할 강의코드를 입력해주세요 : ");
		int lectureNum = scanner.nextInt();
		Lecture lcode = new Lecture(lectureNum);
		int index = um.lecture.indexOf(lcode); 
		System.out.println("현재 수강중인 학생 : ");
		System.out.println(um.lecture.get(index).score);
		System.out.print("성적을 입력/수정할 학생의 학번을 입력하세요 : ");
		int stdNum = scanner.nextInt();
		System.out.print("학생의 성적을 입력하세요 : ");
		String score = scanner.next();
		if(um.insertScore(index, stdNum, score)) {
			System.out.println("정상적으로 입력되었습니다.");
			return;
		}
		System.out.println("입력 실패");
	}

	private void removeScore() {
		System.out.print("교수님의 교번을 입력해주세요 : ");
		int num = scanner.nextInt();
		if(!um.checkNum(1, num)) {
			System.out.println("해당교번의 교수가 존재하지 않습니다.");
			return;
		}
		System.out.println("담당중인 강의 : ");
		for(int i=0; i<um.lecture.size(); i++) {
			if(um.lecture.get(i).proCode==num) {
				System.out.println(um.lecture.get(i).name + " : " + um.lecture.get(i).code);
			}
		}
		System.out.print("성적을 삭제할 강의코드를 입력해주세요 : ");
		int lectureNum = scanner.nextInt();
		Lecture lcode = new Lecture(lectureNum);
		int index = um.lecture.indexOf(lcode); 
		System.out.println("현재 수강중인 학생 : ");
		System.out.println(um.lecture.get(index).score);
		System.out.print("성적을 삭제할 학생의 학번을 입력하세요 : ");
		int stdNum = scanner.nextInt();
		if(um.removeScore(index, stdNum)) {
			System.out.println("정상적으로 삭제되었습니다.");
			return;
		}
		System.out.println("삭제 실패");
	}

	private void showScore() {
		System.out.println("현재 강의 목록");
		for(int i=0; i<um.lecture.size(); i++) {
			System.out.println(um.lecture.get(i).name + " : " + um.lecture.get(i).code);
		}
		System.out.print("조회하려는 학과의 코드를 입력하세요 : ");
		int code = scanner.nextInt();
		um.showScore(code);
	}

	private void departmentList() { //학과조회
		System.out.print("조회할 학과의 이름을 입력하세요 : ");
		String departmentName = scanner.next();
		um.departmentListShow(departmentName);
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

	private void insertProfessor() { //교수입력
		System.out.print("등록할 교수의 이름을 입력하세요 : ");
		String name = scanner.next();
		System.out.print("등록할 교수의 나이를 입력하세요 : ");
		int age = scanner.nextInt();
		System.out.print("등록할 교수의 학과를 입력하세요 : ");
		String department = scanner.next();
		if(um.insertPro(name, age, department)){
			System.out.println("정상적으로 등록되었습니다.");
			return;
		}
		System.out.println("등록 실패");
	}

	private void updateProfessor() { //교수수정
		System.out.print("수정할 교수의 교번을 입력하세요 : ");
		int num = scanner.nextInt();
		System.out.print("새로운 교수의 이름을 입력하세요 : ");
		String name = scanner.next();
		System.out.print("새로운 교수의 나이를 입력하세요 : ");
		int age = scanner.nextInt();
		if(um.updatePro(num, name, age)) {
			System.out.println("정상적으로 수정되었습니다.");
			return;
		}
		System.out.println("수정 실패");
	}

	private void removeProfessor() { //교수삭제
		System.out.print("삭제할 교수의 교번을 입력하세요 : ");
		int num = scanner.nextInt();
		if(um.removePro(num)) {
			System.out.println("정상적으로 삭제되었습니다.");
			return;
		}
		System.out.println("삭제 실패");
	}

	private void showProfessor() { //전체 교수조회
		List<String> llist = new ArrayList<String>();
		for(int i=0; i<um.professor.size(); i++) {
			for(int j=0; j<um.lecture.size(); j++) {
				if(um.lecture.get(j).proCode==um.professor.get(i).num) {
					llist.add(um.lecture.get(j).name);
				}
			}
			System.out.println("[교수이름 : "+ um.professor.get(i).name+"  나이 : " + um.professor.get(i).age+"  번호 : " + um.professor.get(i).num+ "  학과 : "+um.professor.get(i).department+"  담당중인 강의 : " + llist + "]");
		}
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

	private void showStudent() { //전체 학생 조회
		List<String> slist = new ArrayList<String>();
		for(int i=0; i<um.student.size(); i++) {
			for(int j=0; j<um.lecture.size(); j++) {
				if(um.lecture.get(j).score.containsKey(um.student.get(i).num)) {
					//강의리스트안의 성적맵에 학생의 학번과 같은 학번이 있으면 그 강의를 수강중인 것
					slist.add(um.lecture.get(j).name);
				}
			}
			System.out.println("[학생이름 : "+ um.student.get(i).name+"  나이 : " + um.student.get(i).age+"  번호 : " + um.student.get(i).num+ "  학과 : "+um.student.get(i).department+"  수강중인 강의 : " + slist + "]");
			//수강중인 강의 department 리스트로 출력
		}
	}

	private void insertStudent() { //학생입력
		System.out.print("등록할 학생의 이름을 입력하세요 : ");
		String name = scanner.next();
		System.out.print("등록할 학생의 나이를 입력하세요 : ");
		int age = scanner.nextInt();
		System.out.print("등록할 학생의 학과를 입력하세요 : ");
		String department = scanner.next();
		if(um.insertStd(name, age, department)){
			System.out.println("정상적으로 등록되었습니다.");
			return;
		}
		System.out.println("등록 실패");
	}

	private void updateStudent() { //학생수정
		System.out.print("수정할 학생의 학번을 입력하세요 : ");
		int num = scanner.nextInt();
		System.out.print("새로운 학생의 이름을 입력하세요 : ");
		String name = scanner.next();
		System.out.print("새로운 학생의 나이를 입력하세요 : ");
		int age = scanner.nextInt();
		if(um.updateStd(num, name, age)) {
			System.out.println("정상적으로 수정되었습니다.");
			return;
		}
		System.out.println("수정 실패");
	}

	private void removeStudent() { //학생삭제
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

	private void showDepartment() { //관리자) 전체 과 조회
		for(int i=0; i<um.department.size(); i++) {
			List<String> proList = new ArrayList<String>();
			List<String> stdList = new ArrayList<String>();
			for(int j=0; j<um.professor.size(); j++) {
				if(um.professor.get(j).department.equals(um.department.get(i).name)) {
					//교수리스트에 등록되어있는 이름과 과이름이 동일하면
					proList.add(um.professor.get(j).name);
				}
			}
			for(int j=0; j<um.student.size(); j++) {
				if(um.student.get(j).department.equals(um.department.get(i).name)) {
					//교수리스트에 등록되어있는 이름과 과이름이 동일하면
					stdList.add(um.student.get(j).name);
				}
			}
			System.out.println("[학과이름 : "+um.department.get(i).name + "  학과코드 : " + um.department.get(i).code+"  교수목록 : " + proList + 
					"  학생목록 : " + stdList +"]");
		}
	}

	private void insertDepartment() { //과 등록
		System.out.print("등록할 과의 이름을 입력하세요 : ");
		String departmentName = scanner.next();
		if(um.insertDepartment(departmentName)) {
			System.out.println("정상적으로 입력되었습니다.");
			return;
		}
		System.out.println("입력 오류");
		
	}

	private void updateDepartment() { //과 수정
		//과 목록에 값이 존재하지 않으면 입력되어 있는 과가 없습니다 출력
		System.out.println("---과 목록---");
		System.out.print("[");
		for(int i=0; i<um.department.size(); i++) {
			System.out.print(um.department.get(i).name+",  ");
		}
		System.out.print("]");
		System.out.print("\n수정할 과의 이름을 입력하세요 : ");
		String user = scanner.next();
		System.out.print("수정될 과의 이름을 입력하세요 : ");
		String user2 = scanner.next();
		if(um.updateDepartment(user,user2)) {
			System.out.println("정상적으로 수정되었습니다.");
			return;
		}
		System.out.println("입력 오류");
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
