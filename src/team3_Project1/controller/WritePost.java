package team3_Project1.controller;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import team3_Project1.model.vo.Post;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

@Data
@AllArgsConstructor
public class WritePost {
	private Scanner scan;
	private BoardService boardService;
	public WritePost(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	void run(String po_me_id, String po_me_name, int po_bo_num) { //아이디, 닉네임, 게시판 번호
		System.out.println();
		scan.nextLine();		
		System.out.print("제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("내용 입력 : ");
		String content = scan.nextLine();
		Post post = new Post(content, title, po_me_id, po_bo_num, po_me_name);
		if(boardService.insertPost(post)) {
			System.out.println("게시글 등록 완료");
			return;
		}
		System.out.println("게시글 등록 실패");
	}
}
