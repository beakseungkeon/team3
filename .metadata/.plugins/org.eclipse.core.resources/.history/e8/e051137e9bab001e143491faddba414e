package HomeWorkEx1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import Program.Program;
import day05.ArrayCopyEx1;
/* 기한은 1월 5일까지 github에 업로드 후 단톡방에 공유
 * 영어 단어장을 관리하는 프로그램 작성
 *  - 한 단어에 뜻이 여러개 있을 수 있음
 *  - 단어, 품사, 뜻을 관리
 *  - 단어 추가, 수정, 삭제
 *  - 뜻 추가, 수정, 삭제
 *  - 단어 조회
 * 
 *  - 기타 추가 기능
 *  - 등록된 단어장에서 랜덤으로 문제가 나오고 맞추는 기능
 *  - 오답 노트를 관리하는 기능
 *  - 많이 조회한 단어를 확인하는 기능
 *  
 *  메뉴
 *  1. 단어 관리
 *    1. 단어추가
 *    2. 단어수정
 *      1. 뜻 추가
 *      2. 뜻 수정
 *      3. 뜻 삭제
 *    3. 단어삭제
 *  2. 단어 조회
 *  3. 프로그램 종료
 */

public class HomeWorkProgram implements Program{
	private Scanner scanner = new Scanner(System.in);
	private HomeWorkManager hwm = new HomeWorkManager();

	@Override
	public void printMenu() {
		System.out.println("---메뉴 선택---");
		System.out.println("1. 단어 관리");
		System.out.println("2. 단어 조회");
		System.out.println("3. 단어 게임");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");		
	}
	
	private void printSubMenu() {
		System.out.println("1. 단어 추가");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.print("메뉴 선택 : ");	
	}
	
	private void printSubMenu2() {
		System.out.println("1. 뜻 추가");
		System.out.println("2. 뜻 삭제");
		System.out.print("메뉴 선택 : ");	
	}

	@Override
	public void run() {
		int menu = 0;
		do {
			printMenu();
			try{	
				menu = scanner.nextInt();
				runMenu(menu);
			}catch(InputMismatchException e) {System.out.println("잘못된 메뉴선택입니다."); scanner.nextLine();} 
		}while(menu!=4);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1: managerWord(); break;
		case 2: show(); break;
		case 3: wordGame(); break;
		case 4: System.out.println("프로그램을 종료합니다."); break;
		default: new InputMismatchException();
		}
	}

	private void managerWord() {
		printSubMenu();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertWord(); break; //단어 추가
		case 2: updateWord(); break; //단어 수정
		case 3: deleteWord(); break; //단어 삭제
		default: new InputMismatchException();
		}
	}
	
	//단어 추가
	private void insertWord() {
		System.out.print("단어 입력 : ");
		String word = scanner.next();
		if(hwm.checkWord(word)) {
			System.out.println("이미 존재하는 단어입니다.");
			return;
		}
		System.out.print("품사 입력 : ");
		String partOfSpeach = scanner.next();
		scanner.nextLine();
		System.out.print("뜻 입력 : ");
		ArrayList<String> mean = new ArrayList<String>();
		mean.add(scanner.nextLine());
		Vocabulary v = new Vocabulary(word, partOfSpeach, mean,0);
		hwm.insertWord(v);
		System.out.println("단어가 추가됐습니다.");
	}
	
	//단어 수정
	private void updateWord() {
		printSubMenu2();
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: insertMean(); break; //뜻 추가
		case 2: deleteMean(); break; //뜻 삭제
		case 3: System.out.println("뒤로가기"); break; //
		default: new InputMismatchException();
		}
		
	}

	//아래 3개는 뜻 관리
	private void insertMean() {
		System.out.print("뜻을 추가할 단어 입력 : ");
		String word = scanner.next();
		if(!hwm.checkWord(word)) {
			System.out.println("입력하신 단어가 존재하지 않습니다.");
			return;
		}
		scanner.nextLine();
		System.out.print("추가할 뚯 입력 : ");
		String mean = scanner.nextLine();
		if(hwm.checkMean(word, mean)) {
			System.out.println("이미 존재하는 뜻입니다.");
		}
		else {
			hwm.insertMean(word, mean);
			System.out.println("뜻이 추가됐습니다.");
		}
	}

	private void deleteMean() {
		System.out.print("뜻을 삭제할 단어 입력 : ");
		String word = scanner.next();
		if(!hwm.checkWord(word)) {
			System.out.println("입력하신 단어 존재하지 않습니다.");
			return;
		}
		System.out.print("삭제할 뜻 입력 : ");
		String mean = scanner.nextLine();
		if(hwm.checkMean(word, mean)) {
			hwm.deleteMean(word, mean);
			System.out.println("뜻이 삭제됐습니다.");
		}
		else {
			System.out.println("입력하신 뜻이 존재하지 않습니다.");
		}
	}

	//단어 삭제
	private void deleteWord() {
		System.out.print("삭제할 단어 입력 : ");
		String word = scanner.next();
		if(!hwm.checkWord(word)) {
			System.out.println("입력하신 단어가 존재하지 않습니다.");
			return;
		}
		hwm.deleteWord(word);
		System.out.println("단어가 삭제됐습니다.");
	}
	
	private void show() {
		System.out.println("1. 조회수별 단어 조회");
		System.out.println("2. 단어 상세 조회");
		System.out.print("메뉴 입력 : ");
		int menu = scanner.nextInt();
		switch(menu) {
		case 1: viewWord(); break;
		case 2: showWord(); break;
		default: new InputMismatchException();
		}
	}
	

	private void viewWord() {
		hwm.viewRank();
		return;
		
	}

	//단어 조회
	private void showWord() {
		hwm.printAll();
		System.out.print("\n조회할 단어 입력 : ");
		String user = scanner.next();
		if(hwm.checkWord(user)) {
			hwm.printWord(user);
		}
		else {
			System.out.println("입력하신 단어가 존재하지 않습니다.");
			return;
		}
	}
	
	private void wordGame() {
		hwm.wordGameWord();
	}
}
