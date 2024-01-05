package HomeWorkEx1;
/* 기한은 1월 5일까지 github에 업로드 후 단톡방에 공유
 * 영어 단어장을 관리하는 프로그램 작성
 *  - 한 단어에 뜻이 여러개 있을 수 있음
 *  - 단어, 품사, 뜻을 관리
 *  - 단어 추가, 수정, 삭제
 *  - 뜻 추가, 수정, 삭제
 *  - 단어 조회
 * 
 *  - 기타 추가 기능
 *  - 등록된 단어장에서 랜덤으로 문제가 나오고 맞추는 기능
 *  - 오답 노트를 관리하는 기능
 *  - 많이 조회한 단어를 확인하는 기능
 */
public class HomeworkEx1 {
	public static void main(String[] args) {
		HomeWorkProgram homeWorkProgram = new HomeWorkProgram();
		homeWorkProgram.run();
	}
}
