package HomeworkEx2;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.text.DateFormatter;
import Program.Program;

public class AccountBookProgram implements Program {
	private Scanner scanner = new Scanner(System.in);
	private AccountBookManager abm = new AccountBookManager();
	private LocalDate nowYear = LocalDate.now();
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
	private String formatedYear = nowYear.format(formatter);
	@Override
	public void run() {
		abm.initialization(); //mList 초기화(1~12월 입력)
		int menu = 0;
		do {
			printMenu();
			try {
			menu = scanner.nextInt();
			runMenu(menu);
			} catch (Exception e) {
				System.out.println("잘못된 입력입니다."); //<- 작동안함
				scanner.nextLine();
			}
		} while(menu!=4);
	}

	@Override
	public void printMenu() {
		System.out.println("---메뉴---");
		System.out.println("1. 가계부 입력");
		System.out.println("2. 가계부 조회");
		System.out.println("3. 가계부 삭제");
		System.out.println("4. 프로그램 종료");	
		System.out.print("메뉴 입력 : ");
	}
	
	private void printSubMenu() {
		System.out.println("1. 수입 입력");
		System.out.println("2. 지출 입력");
		System.out.print("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: accountBookInsert(); break;
		case 2: accountBookShow(); break;
		case 3: accountBookRemove(); break;
		default: new InputMismatchException(); 
		}
		
	}

	private void accountBookRemove() {//월 고르고 내역 삭제
		System.out.print("월 입력 : ");
		int month = scanner.nextInt();
		abm.removeInitialization(month);
		
	}

	private void accountBookInsert() { 
		printSubMenu();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertIncome(); break;
		case 2: insertExpense(); break;
		default: new InputMismatchException(); 
		}
	}

	private void insertIncome() { //수입 입력
		System.out.print("월 : ");
		int month = scanner.nextInt();
		System.out.print("일 : ");
		int date = scanner.nextInt();
		if(check(month, date)) {
			return;
		}
		System.out.print("수입(원) : ");
		int incomeMoney = scanner.nextInt();
		System.out.print("메모 : ");
		scanner.nextLine();
		String message = scanner.nextLine();
		
		Income income = new Income(month, date, incomeMoney, message);
		
		abm.insertIncome(income);
	}

	private void insertExpense() { //지출입력
		System.out.print("월 : ");
		int month = scanner.nextInt();
		System.out.print("일 : ");
		int date = scanner.nextInt();
		if(check(month, date)) {
			return;
		}
		System.out.print("지출(원) : ");
		int expenseMoney = scanner.nextInt();
		System.out.print("메모 : ");
		scanner.nextLine();
		String message = scanner.nextLine();
		
		Expense expense = new Expense(month, date, expenseMoney, message);
		
		abm.insertexpense(expense);
		
	}

	private void accountBookShow() { //가계부 조회
		System.out.println("---" + formatedYear + "년 가계부---");
		if(abm.viewAllMonth()) {
			return;
		}
		System.out.print("월 검색 : ");
		int month = scanner.nextInt();
		if(month >12 || month<=0) {
			new InputMismatchException();
			return;
		}
		
		abm.viewMonth(month);
		
	}
	
	private boolean check(int month, int date) { //월과 일을 제대로 입력했는지 확인하는 메서드
		if(month>12||month<=0) {
			System.out.println("잘못된 월 입력입니다.");
			return true;
		}
		if(month==1||month==3||month==5||month==7||month==8||month==10||month==12) {
			if(date<=0||date>31) {
				System.out.println("잘못된 일 입력입니다.");
				return true;
			}
		}
		if(month==4||month==6||month==9||month==11) {
			if(date<=0||date>30) {
				System.out.println("잘못된 일 입력입니다.");
				return true;
			}
		}
		if(month == 2) {
			if(date<=0||date>28) {
				System.out.println("잘못된 일 입력입니다.");
				return true;
			}
		}
		System.out.println("정상적인 날짜 입력입니다.");
		return false;
	}
	
}
