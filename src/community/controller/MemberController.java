package community.controller;

import java.util.ArrayList;
import java.util.Scanner;

import community.model.vo.Board;
import community.model.vo.Category;
import community.model.vo.MemberVO;
import community.model.vo.post;
import community.service.MemberService;
import community.service.MemberServiceImp;

public class MemberController {
	private MemberService memberService= new MemberServiceImp();
	private Scanner scan = new Scanner(System.in);
	public void run() {
		int menu;
		do {
			printMemberMenu();
			menu=scan.nextInt();
			rumMemberMenu(menu);
		}while(menu !=5);
		
	}
	private void rumMemberMenu(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1:login();
		break;
		case 2:findId();
		break;
		case 3:findPw();
		break;
		case 4:addMember();
		break;
		default:
			System.out.println("잘못된 메뉴입니다.");
			break;
		}
	}
	private void addMember() {
		System.out.println("아이디 :");
		
		String id=scan.next();
		System.out.println("비밀번호 :");
		String pw=scan.next();
		System.out.println("닉네임 :");
		String nickname=scan.next();
		System.out.println("이메일 :");
		String email = scan.next();
		MemberVO member = new MemberVO(id,pw,email,nickname);
		if(memberService.addMember(member)) {
			System.out.println("회원가입이 완료되었습니다.");
		}
		else System.out.println("회원가입 도중 오류가 발생했습니다.");
	}
	private void findPw() {
		// TODO Auto-generated method stub
		System.out.println("아이디를 입력하세요");
		String id=scan.next();
		ArrayList<MemberVO> list = memberService.getMemberListid(id);
		if(list.size() == 0) {
			System.out.println("등록된 회원이 없습니다.");
			return;
		}
		for(MemberVO tmp : list) {
			System.out.println(tmp.getPw());
		}
	}
	private void findId() {
		System.out.println("이메일을 입력하세요");
		String email=scan.next();
		ArrayList<MemberVO> list = memberService.getMemberList(email);
		if(list.size() == 0) {
			System.out.println("등록된 회원이 없습니다.");
			return;
		}
		for(MemberVO tmp : list) {
			System.out.println(tmp.getId());
		}
		
			
			
		
		
		
	}
	private void login() {
		
		System.out.println("1.회원");
		System.out.println("2.관리자");
		System.out.println("메뉴 선택");
		int menu=scan.nextInt();
		runBoard(menu);
		
	}
	private void runBoard(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1:
			break;
		case 2:
			adminMenu();
			break;
		}
	}
	
	private void adminMenu() {
		System.out.println("관리자 메뉴");
		System.out.println("1.카테고리 관리");
		System.out.println("2.게시판 관리");
		System.out.println("3.게시글 관리");
		System.out.println("4.댓글관리");
		System.out.println("5.사용자관리");
		System.out.println("메뉴 선택:");
		int menu=scan.nextInt();
		runAdmin(menu);

		
		
	}
	private void runAdmin(int menu) {
		switch(menu) {
		case 1:
			categoryMenu();
			break;
		case 2:
			boardMenu();
			break;
		case 3:
			postMenu();
			break;
		case 4:
			commentManagement();
			break;
		case 5:
			userManagement();
			break;
		default:
			System.out.println("잘못된 입력입니다.");
			break;
			
		}
		
	}
	
	private void userManagement() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 사용자 아이디:");
		String id=scan.next();
		ArrayList<MemberVO> list = memberService.getMemberListid(id);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if(memberService.deleteUser(id)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}
	private void commentManagement() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = memberService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		System.out.println("게시판 제목:");
		String bo_title=scan.next();
		ArrayList<Board> bo_list = memberService.getMemberListBo(bo_title);
		if(bo_list == null || bo_list.size() == 0) {
			System.out.println("존재하지 않는 게시판입니다.");
			return;
		}
		System.out.println("게시글 제목:");
		String po_title=scan.next();
		ArrayList<post> po_list = memberService.getMemberListPo(po_title);
		if(po_list == null || po_list.size() == 0) {
			System.out.println("존재하지 않는 게시글입니다.");
			return;
		}
		System.out.println("삭제할 댓글 번호");
		int co_num=scan.nextInt();
		
		if(memberService.deleteCo(po_title,bo_title,ca_title,co_num)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
		
		
		
		
	}
	
	private void postMenu() {
		// TODO Auto-generated method stub
		System.out.println("1.공지사항 추가");
		System.out.println("2.공지사항 수정");
		System.out.println("3.공지사항 삭제");
		int menu=scan.nextInt();
		PostManagement(menu);
	}
	private void PostManagement(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		case 1:
			addPost();
			break;
		case 2:
			updatePost();
			break;
		case 3:
			deletePost();
			break;
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
			break;
			
		}
	}
	private void deletePost() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = memberService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		System.out.println("삭제할 게시글명");
		String bo_title="공지";
		String po_title=scan.next();
		if(memberService.deletePo(po_title,bo_title,ca_title)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
		
	}
	private void updatePost() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = memberService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		String bo_title="공지";
		System.out.println("삭제할 게시글명");
		String po_title=scan.next();
		System.out.println("수정할 내용:");
		String po_content=scan.next();
		post post = new post(po_content,po_title);
		if(memberService.updatePo(bo_title,ca_title,post)) {
			System.out.println("내역을 수정했습니다.");
		}else {
			System.out.println("내역을 수정하지 못했습니다");
		}
		
		
	}
	private void addPost() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = memberService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		
		String bo_title="공지";
		System.out.println("제목 입력");
		String po_title=scan.next();
		System.out.println("내용 입력:");
		String po_content=scan.next();
		post post = new post(po_content,po_title);
		if(memberService.addTitlePo(bo_title,ca_title,post)) {
			System.out.println("게시판이 생성되었습니다.");
		}
		else System.out.println("생성 도중 오류가 발생했습니다.");
	
		
	}
	private void boardMenu() {
		// TODO Auto-generated method 
		
		System.out.println("1.게시판 추가");
		System.out.println("3.게시판 삭제");
		int menu=scan.nextInt();
		BoardManagement(menu);
	
	}
	private void BoardManagement(int menu) {
		// TODO Auto-generated method stub
		switch(menu) {
		
		case 1:
			addBoard();
			break;
		
		case 2:
			deleteBoard();
			break;
		
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
			break;
			
		}
	}
	private void deleteBoard() {
		// TODO Auto-generated method stub
		
		System.out.println("삭제할 게시판명");
		String title=scan.next();
		ArrayList<Board> list = memberService.getMemberListBo(title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 게시판입니다.");
			return;
		}
		if(memberService.deleteBo(title)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}
	private void addBoard() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = memberService.getMemberListCa(ca_title);
		
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		
		System.out.println("추가할 게시판명:");
		String title=scan.next();
		Board board = new Board(title,ca_title);
		
		if(memberService.addTitleBo(board)) {
			System.out.println("게시판이 생성되었습니다.");
			
		}
		else System.out.println("생성 도중 오류가 발생했습니다.");
	
		
		
	}
	private void categoryMenu() {
		
		System.out.println("1.카테고리 추가");
		System.out.println("2.카테고리 삭제");
		System.out.println("메뉴 선택:");
		int menu=scan.nextInt();
		categoryManagement(menu);
		
	}
	private void categoryManagement(int menu) {
		switch(menu) {
		case 1:
			addCategory();
			break;
		
		case 2:
			deleteCategory();
			break;
			
		default:
			System.out.println("잘못된 메뉴 선택입니다.");
			break;
			
		}
		
	}
	private void deleteCategory() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 카테고리명:");
		String title=scan.next();
		ArrayList<Category> list = memberService.getMemberListCa(title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		if(memberService.deleteCa(title)) {
			System.out.println("카테고리를 삭제했습니다.");
		}else {
			System.out.println("카테고리를 삭제하지 못했습니다.");
		}

	}

	private void addCategory() {
		System.out.println("추가할 카테고리명:");
		String title=scan.next();
		Category category = new Category(title);
		if(memberService.addTitle(title)) {
			System.out.println("카테고리가 생성되었습니다.");
		}
		else System.out.println("생성 도중 오류가 발생했습니다.");
	
		
	}
	private void printMemberMenu() {
		// TODO Auto-generated method stub
		System.out.println("메뉴");
		System.out.println("1.로그인");
		System.out.println("2.아이디 찾기");
		System.out.println("3.비밀번호 찾기");
		System.out.println("4.회원가입");
		System.out.println("메뉴 선택:");
	}

}
