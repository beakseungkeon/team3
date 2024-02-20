package team3_Project1.controller.memberController;

import java.util.Scanner;

import team3_Project1.service.BoardService;
import team3_Project1.service.BoardServiceImp;

public class ManageMyComment {
	private Scanner scan;
	private BoardService boardService;
	public ManageMyComment(Scanner scan) {
		if(scan == null) {
			scan = new Scanner(System.in);
		}
		this.scan = scan;
		boardService = new BoardServiceImp();
	}
	
	public void updateMyComment(int co_num){
		boardService.updateMyComment(co_num);
	}
	public void deleteMyComment(int co_num){
		
	}
}
