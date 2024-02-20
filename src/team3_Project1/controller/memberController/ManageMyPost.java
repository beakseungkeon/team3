package team3_Project1.controller.memberController;

import java.util.Scanner;
import lombok.AllArgsConstructor;
import lombok.Data;
import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

@Data
@AllArgsConstructor
public class ManageMyPost {
	private Scanner scan;
	private BoardService boardService;
	public ManageMyPost(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public void updatePost(int po_num) {
		scan.nextLine();
		System.out.print("수정할 제목 입력 : ");
		String title = scan.nextLine();
		System.out.println("수정할 내용 입력 : ");
		String content = scan.nextLine();
		boardService.updateMyBoard(po_num, title, content);
		System.out.println("수정 완료");
	}
	
	public void deletePost(int po_num) {
		boardService.deleteMyComment(po_num);
		boardService.deleteMyPost(po_num);
		System.out.println("삭제되었습니다.");
	}

}
