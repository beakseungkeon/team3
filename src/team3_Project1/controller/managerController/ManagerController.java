package team3_Project1.controller.managerController;

import java.util.ArrayList;
import java.util.Scanner;
import team3_Project1.model.vo.Board;
import team3_Project1.model.vo.Category;
import team3_Project1.model.vo.Member;
import team3_Project1.model.vo.Post;
import team3_Project1.service.ManagerService;
import team3_Project1.service.ManagerServiceImp;


public class ManagerController {

	private ManagerService managerService= new ManagerServiceImp();
	private Scanner scan = new Scanner(System.in);
	public void run() {
		int menu;
		do {
			adminMenu();
			menu=scan.nextInt();
			runAdmin(menu);
		}while(menu !=6);
	}
	
	private void adminMenu() {
		System.out.println("관리자 메뉴");
		System.out.println("1.카테고리 관리");
		System.out.println("2.게시판 관리");
		System.out.println("3.게시글 관리");
		System.out.println("4.댓글관리");
		System.out.println("5.사용자관리");
		System.out.println("6. 로그아웃");
		System.out.print("메뉴 선택:");
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
		case 6:
			System.out.println("로그아웃 되었습니다.");
		default:
			System.out.println("잘못된 입력입니다.");
			break;
			
		}
		
	}
	
	private void userManagement() {
		// TODO Auto-generated method stub
		System.out.println("삭제할 사용자 아이디:");
		String id=scan.next();
		ArrayList<Member> list = managerService.getMemberListid(id);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 아이디입니다.");
			return;
		}
		if(managerService.deleteUser(id)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}
	private void commentManagement() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = managerService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		System.out.println("게시판 제목:");
		String bo_title=scan.next();
		ArrayList<Board> bo_list = managerService.getMemberListBo(bo_title);
		if(bo_list == null || bo_list.size() == 0) {
			System.out.println("존재하지 않는 게시판입니다.");
			return;
		}
		System.out.println("게시글 제목:");
		String po_title=scan.next();
		ArrayList<Post> po_list = managerService.getMemberListPo(po_title);
		if(po_list == null || po_list.size() == 0) {
			System.out.println("존재하지 않는 게시글입니다.");
			return;
		}
		System.out.println("삭제할 댓글 번호");
		int co_num=scan.nextInt();
		
		if(managerService.deleteCo(po_title,bo_title,ca_title,co_num)) {
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
		ArrayList<Category> list = managerService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		System.out.println("삭제할 게시글명");
		String bo_title="공지";
		String po_title=scan.nextLine();
		if(managerService.deletePo(po_title,bo_title,ca_title)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
		
	}
	private void updatePost() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = managerService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		String bo_title="공지";
		System.out.println("삭제할 게시글명");
		String po_title=scan.next();
		System.out.println("수정할 내용:");
		String po_content=scan.next();
		Post post = new Post(po_content,po_title);
		if(managerService.updatePo(bo_title,ca_title,post)) {
			System.out.println("내역을 수정했습니다.");
		}else {
			System.out.println("내역을 수정하지 못했습니다");
		}
		
		
	}
	private void addPost() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = managerService.getMemberListCa(ca_title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		String bo_title="공지";
		System.out.println("제목 입력");
		String po_title=scan.next();
		System.out.println("내용 입력:");
		String po_content=scan.next();
		Post post = new Post(po_content,po_title);
		if(managerService.addTitlePo(bo_title,ca_title,post)) {
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
		ArrayList<Board> list = managerService.getMemberListBo(title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 게시판입니다.");
			return;
		}
		if(managerService.deleteBo(title)) {
			System.out.println("내역을 삭제했습니다.");
		}else {
			System.out.println("내역을 삭제하지 못했습니다.");
		}
	}
	private void addBoard() {
		System.out.println("카테고리명:");
		String ca_title=scan.next();
		ArrayList<Category> list = managerService.getMemberListCa(ca_title);
		
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		
		System.out.println("추가할 게시판명:");
		String title=scan.next();
		Board board = new Board(title, ca_title);
		
		if(managerService.addTitleBo(board)) {
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
		ArrayList<Category> list = managerService.getMemberListCa(title);
		if(list == null || list.size() == 0) {
			System.out.println("존재하지 않는 카테고리입니다.");
			return;
		}
		if(managerService.deleteCa(title)) {
			System.out.println("카테고리를 삭제했습니다.");
		}else {
			System.out.println("카테고리를 삭제하지 못했습니다.");
		}

	}

	private void addCategory() {
		System.out.println("추가할 카테고리명:");
		String title=scan.next();
		Category category = new Category(title);
		if(managerService.addTitle(title)) {
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
