package team3_Project1.controller.memberController;

import java.util.List;
import java.util.Scanner;

import team3_Project1.model.vo.Member;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

public class JoinMember {
	private Scanner scan;
	private BoardService boardService;

	public JoinMember(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public void run() {
		System.out.println("---회원가입---");
		System.out.print("아이디 입력 : ");
		String id = scan.next();
		// 아이디 정규식 확인 해야함
		List<Member> memberList = boardService.getMember(); // 등록되어 있는 회원정보를 불러옴
		
		//아이디 중복 확인
		for(Member i:memberList) {
			if(id.equals(i.getMe_id())) {
				System.out.println("중복된 아이디가 존재합니다.");
				return;
			}
		}
		
		System.out.print("비밀번호 입력 : ");
		String pw = scan.next();
		//비밀번호 정규식 확인 해야함
		
		System.out.print("비밀번호 확인 입력 : ");
		String pw2 = scan.next();
		if(!pw.equals(pw2)) {System.out.println("비밀번호가 다릅니다."); return;}
		
		//아이디와 비밀번호를 admin admin으로 했을 시
		if(id.equals("admin") && pw.equals("admin")) {
			System.out.println("사용할 수 없는 아이디와 비밀번호입니다.");
			return;
		}
		
		System.out.print("이메일 입력 : ");
		String email = scan.next();
		//이메일 정규식 확인 해야함
		
		//이메일 중복 확인
		for(Member i:memberList) {
			if(id.equals(i.getMe_email())) {
				System.out.println("중복된 이메일이 존재합니다.");
				return;
			}
		}
		
		System.out.print("닉네임 입력 : ");
		String name = scan.next();
		//닉네임 정규식 확인 해야함
		
		//닉네임 중복 확인
		for(Member i:memberList) {
			if(id.equals(i.getMe_name())) {
				System.out.println("중복된 닉네임이 존재합니다.");
				return;
			}
		}
		Member member = new Member(id, pw, name, email);
		if(boardService.insertMember(member)) {
			System.out.println("회원가입 성공");
			return;
		}
		System.out.println("회원가입 실패");
	}

}
