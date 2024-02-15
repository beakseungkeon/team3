package team3_Project1.controller;

import java.util.List;
import java.util.Scanner;
import team3_Project1.model.vo.Member;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

public class FindId {
	private Scanner scan;
	private BoardService boardService;
	
	public FindId(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public void run() {
		System.out.println("--아이디 찾기--");
		System.out.print("이메일 입력 : ");
		String email = scan.next();
		List<Member> memberList = boardService.getMember();
		
		for(Member i:memberList) {
			if(email.equals(i.getMe_email())) {
				System.out.println("아이디 : " + i.getMe_id());
				return;
			}
		}
		
		System.out.println("입력하신 이메일에 대한 정보가 없습니다.");
		
	}
}
