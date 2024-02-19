package team3_Project1.controller.memberController;

import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

@Data
@AllArgsConstructor
public class ManageMyBoard {
	private int po_num;
	private Scanner scan;
	private BoardService boardService;
	public ManageMyBoard(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public boolean updateBoard() {
		scan.nextLine();		
		System.out.print("수정할 제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("수정할 내용 입력 : ");
		String content = scan.nextLine();
		return boardService.updateMyBoard(po_num, title, content);
	}
	
	public boolean deleteBoard() {
		return boardService.deleteMyBoard(po_num);
	}

	public ManageMyBoard(int po_num) {
		super();
		this.po_num = po_num;
	}
}
