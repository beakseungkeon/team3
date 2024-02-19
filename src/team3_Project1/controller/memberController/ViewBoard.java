package team3_Project1.controller.memberController;

import java.util.List;
import java.util.Scanner;

import team3_Project1.model.vo.Board;
import team3_Project1.model.vo.Category;
import team3_Project1.model.vo.Comment;
import team3_Project1.model.vo.Post;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

public class ViewBoard {
	private Scanner scan;
	private BoardService boardService;
	private static String id;
	public ViewBoard(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public void run(String me_id) {
		id = me_id;
		int menu;
		do {
			System.out.println();
			System.out.println("---kh 영화커뮤니티입니다.---");
			System.out.println("1. 게시글 보기");
			System.out.println("2. 내 글 관리");
			System.out.println("3. 내 댓글 관리");
			System.out.println("4. 로그아웃");
			System.out.print("메뉴 선택 : ");
			menu = scan.nextInt();
			runMenu(menu);
		}while(menu!=4);
			
	}
	
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			viewCategory();
			break;
		case 2:
			viewMyBoard();
			break;
		case 3:
			viewMyComment();
			break;
		case 4:
			System.out.println("로그아웃 되었습니다.");
			break;
		default :
			System.out.println("잘못된 메뉴선택");
		}
	}
	
	private void viewCategory() {
		System.out.println("---카테고리 리스트---");
		List<Category> categoriList = boardService.getCategory();
		int num = 1;
		for(Category i:categoriList) {
			System.out.println(num++ + ". " + i.getCa_title());
		}
		System.out.print("카테고리 이름 입력 : ");
		String categoryMenu = scan.next();
		if(!categoriList.contains(new Category(categoryMenu))) {
			System.out.println("해당되는 이름의 카테고리를 찾을 수 없습니다.");
			return;
		}
		viewBoardList(categoryMenu);
	}
	
	private void viewBoardList(String categoryMenu) {
		List<Board> boardList = boardService.getBoard(categoryMenu);
		if(boardList.size() <= 0) {
			System.out.println("생성되어있는 게시판이 없습니다.");
			return;
		}
		System.out.println("---게시판 리스트---");
		for(Board i:boardList) {
			System.out.println(i.getBo_num() + ". " + i.getBo_title());
		}
		System.out.print("게시판 선택 : ");
		int boardMenu = scan.nextInt();
		if(!boardList.contains(new Board(boardMenu))) {
			System.out.println("현재 카테고리에서 해당 번호의 게시판을 찾을 수 없습니다.");
			return;
		}
		viewPostList(boardMenu);
	}

	private void viewPostList(int boardMenu) { // boardMenu는 게시판 리스트에서 유저가 고른 게시판의 번호(bo_num)
		int postListNum = 0;
		int postListNum5 = 5;
		int bo_num = boardMenu;
		char user;
		do {
			List<Post> postList = boardService.getPost(bo_num, postListNum, postListNum5);
			System.out.println("---게시글 리스트---");
			if(postList.size() <= 0) {
				System.out.println("작성되어 있는 글이 없습니다. 첫번째 게시글을 작성해보세요!");
			}
			for(Post i:postList) {
				System.out.println(i.getPo_num() + ". " + i.getPo_title() + "   조회수: " + i.getPo_view() + "   작성자: " + i.getPo_me_name());
			}
			System.out.println("게시글 검색 : w");
			System.out.println("이전글 보기 : e");
			System.out.println("게시글 작성 : s");
			if(postListNum != 0) {
				System.out.println("다음글 보기 : q");
				}
			System.out.print("입력: ");
			user = scan.next().charAt(0);
			
			if(user == 's') {
				WritePost writePost = new WritePost(scan);
				writePost.run(id, boardService.getName(id), boardMenu);
			}
			
			if(user=='e') {
				postListNum = postListNum + 5;
				postListNum5 = postListNum5 + 5;
				System.out.println(postListNum);
				System.out.println(postListNum5);
			} else if(user == 'q') {
				if(postListNum<=0) {
					System.out.println("가장 최신 페이지입니다.");
					return;
				}
				postListNum = postListNum - 5;
				postListNum5 = postListNum5 - 5;
				}
			}while(user!='w');
		System.out.print("게시글 번호 입력 : ");
		int num = scan.nextInt();
		List<Post> detailPost = boardService.getDetailPost(num);
		boardService.updateView(num);
		System.out.println("제목: "+detailPost.get(0).getPo_title()+"   조회수: "+detailPost.get(0).getPo_view() + "   작성자: " + detailPost.get(0).getPo_me_name()+"\n");
		System.out.println(detailPost.get(0).getPo_content());
		System.out.println("--------------------------------------------------댓글 목록--------------------------------------------------");
		int co_po_num = detailPost.get(0).getPo_num();
		List<Comment> comment = boardService.getCommentList(co_po_num);
		if(comment.size()<=0) {
			System.out.println("작성된 댓글이 없습니다.");
		} else {
			for(Comment i:comment) {
				String name = boardService.getName(i.getCo_me_id());
				System.out.println(i.getCo_num() + ". " + i.getCo_content() + "   작성자: " + name);
			}
		}
		System.out.println("댓글 작성 : s");
		System.out.print("입력 : ");
		if(scan.next().charAt(0)=='s') {
			WriteComment writeComment = new WriteComment(scan);
			writeComment.run(num, id);
			
		}
	}

	private void viewMyBoard() {
		List<Post> myPostList = boardService.getMyPost(id);
		if(myPostList.size()==0) {
			System.out.println("작성한 게시글이 없습니다.");
			return;
		}
		System.out.println("--------------------------------------------------내 글 목록--------------------------------------------------");
		for(Post i:myPostList) {
			System.out.println(i.getPo_num() + ". " +  i.getPo_title());
		}
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.print("글 번호 입력(상세조회) : ");
		int index = myPostList.indexOf(new Post(scan.nextInt()));
		if(index == -1) {
			System.out.println("해당되는 번호의 게시글이 없습니다.");
			return;
		}
		System.out.println("제목: "+myPostList.get(index).getPo_title()+"   조회수: "+myPostList.get(index).getPo_view() + "   작성자: " + myPostList.get(index).getPo_me_name()+"\n");
		System.out.println(myPostList.get(index).getPo_content());
		System.out.println("------------------------------------------------------------------------------------------------------------");
		System.out.println("1. 글 수정");
		System.out.println("2. 글 삭제");
		System.out.print("메뉴 선택 : ");
		int postMenu = scan.nextInt();
		manageMyBoard(postMenu);
	}

	private void manageMyBoard(int postMenu) {
		switch(postMenu) {
		case 1:
			//게시글 수정
			
			break;
		case 2:
			//게시글 삭제
			
			break;
		default: 
			System.out.println("잘못된 선택");
			break;
		}
		
	}

	private void viewMyComment() {
		System.out.println("---내 댓글 목록---");
		List<Comment> myCommentList = boardService.getMyComment(id);
		if(myCommentList.size()==0) {
			System.out.println("작성한 댓글이 없습니다.");
			return;
		}
		for(Comment i:myCommentList) {
			int num = i.getCo_po_num();
			List<Post> detailPost = boardService.getDetailPost(num);
			System.out.println(i.getCo_num() + ". " + i.getCo_content() + "   게시글 : " + detailPost.get(0).getPo_title() + "   게시글 작성자 : " + detailPost.get(0).getPo_me_name());
		}
	}
}
