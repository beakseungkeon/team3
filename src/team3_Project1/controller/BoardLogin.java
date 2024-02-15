package team3_Project1.controller;

import java.util.Scanner;
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

	}

}




