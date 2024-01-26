package university.service;

public class PrintMenu {
	public void printMain() {
		System.out.println("---메뉴---");
		System.out.println("1. 학생서비스");
		System.out.println("2. 교수서비스");
		System.out.println("3. 관리자서비스");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	//------------------------------------------
	
	public void printSubMenu1() {
		System.out.println("1. 수강 관리");
		System.out.println("2. 성적 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	public void printSubMenu1_1() {
		System.out.println("1. 수강 신청");
		System.out.println("2. 수강 신청 취소");
		System.out.print("메뉴 선택 : ");
	}
	
	//------------------------------------------
	
	public void printSubMenu2() {
		System.out.println("1. 강의 관리");
		System.out.println("2. 성적 관리");
		System.out.println("3. 학과 조회");
		System.out.print("메뉴 선택 : ");
	}

	public void printSubMenu2_1() {
		System.out.println("1. 강의 등록");
		System.out.println("2. 강의 수정");
		System.out.println("3. 강의 삭제");
		System.out.println("4. 강의 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	public void printSubMenu2_2() {
		System.out.println("1. 성적 등록");
		System.out.println("2. 성적 수정");
		System.out.println("3. 성적 삭제");
		System.out.println("4. 성적 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	//------------------------------------------
	
	public void printSubMenu3() {
		System.out.println("1. 학과 관리");
		System.out.println("2. 학생 관리");
		System.out.println("3. 교수 관리");
		System.out.print("메뉴 선택 : ");
	}
	
	public void printSubMenu3_1() {
		System.out.println("1. 학과 등록");
		System.out.println("2. 학과 수정");
		System.out.println("3. 학과 삭제");
		System.out.println("4. 전체 학과 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	public void printSubMenu3_2() {
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 전체 학생 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	public void printSubMenu3_3() {
		System.out.println("1. 교수 등록");
		System.out.println("2. 교수 수정");
		System.out.println("3. 교수 삭제");
		System.out.println("4. 전체 교수 조회");
		System.out.print("메뉴 선택 : ");
	}
	
	//------------------------------------------
	
	
}
