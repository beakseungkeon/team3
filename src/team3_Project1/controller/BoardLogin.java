package team3_Project1.controller;

import java.util.List;
import java.util.Scanner;

import team3_Project1.controller.managerController.ManagerController;
import team3_Project1.controller.memberController.ViewBoard;
import team3_Project1.model.vo.Member;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

public class BoardLogin {
	
	private Scanner scan;
	private BoardService boardService;
	
	public BoardLogin(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}

	public void run() {
		System.out.println("---로그인---");
		System.out.print("아이디 : ");
		String id = scan.next();
		System.out.print("비밀번호 : ");
		String pw = scan.next();
		if(id.equals("admin") && pw.equals("admin")) {
			ManagerController managerController = new ManagerController();
			managerController.run();
		}
		memberMain(id, pw);
	}
	
	public void memberMain(String id, String pw) {
		List<Member> memberList = boardService.getMember();
		for(Member i:memberList) {
			if(id.equals(i.getMe_id())) {
				if(pw.equals(i.getMe_pw())) {
					System.out.println("로그인 성공");
					System.out.println("반갑습니다. " + i.getMe_name() + " 님");
					ViewBoard viewBoard = new ViewBoard(scan);
					viewBoard.run(i.getMe_id());
					return;
				}
			}
		}
		System.out.println("로그인 실패");
	}

}




