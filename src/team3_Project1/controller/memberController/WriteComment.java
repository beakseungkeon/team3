package team3_Project1.controller.memberController;

import java.util.Scanner;

import team3_Project1.model.vo.Comment;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

public class WriteComment {
	private Scanner scan;
	private BoardService boardService;
	public WriteComment(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public void run(int co_po_num, String co_me_id) {
		System.out.print("댓글 내용 작성 : ");
		scan.nextLine();
		String content = scan.nextLine();
		Comment comment = new Comment(content, co_po_num, co_me_id);
		if(boardService.insertComment(comment)) {
			System.out.println("댓글 작성 완료");
			return;
		}
		System.out.println("댓글 작성 실패");
	}
}
