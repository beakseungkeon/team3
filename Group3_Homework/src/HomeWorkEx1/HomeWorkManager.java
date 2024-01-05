package HomeWorkEx1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class HomeWorkManager {
	Scanner scanner = new Scanner(System.in);
	private ArrayList<Vocabulary> list = new ArrayList<Vocabulary>();
	
	//단어, 품사, 뜻을 입력받으면 추가해주는 메서드
	//만약 동일한 단어가 있을 시 추가안함
	
	public int showIndexNum(String word) {//word를 입력받으면 주솟값 반환
		Vocabulary w = new Vocabulary(word);
		return list.indexOf(w);
	}
	
	public void showWord(int index) {
		list.get(index);
	}
	
	public void insertMean(String word, String mean1) {
		list.get(showIndexNum(word)).mean.add(mean1);
	}
	
	public void deleteMean(String word, String mean1) {
		list.get(showIndexNum(word)).mean.remove(mean1);
	}
	
	public void insertWord(Vocabulary v) {
		list.add(v);
	}
	
	public boolean checkWord(String word) {
		Vocabulary w = new Vocabulary(word);
		if(list.contains(w)) {
			return true;
		}
		return false;
	}
	
	public boolean checkMean(String word, String mean) { //단어와 뜻을 입력받고 인덱스번째 자리의 뜻리스트와 입력받은 뜻을 비교하여 만약 있다면 true 반환 없다면 false 반환
		int index = showIndexNum(word);
		if(list.get(index).mean.contains(mean)) {
			return true;
		}
		return false;
	}
	
	public void wordGameWord() {
		if(list.size()<=0) {
			System.out.println("입력되어있는 단어가 없습니다.");
			return;
		}
		double win=0, loss=0;
		int max = list.size();
		ArrayList<Integer> gameList = new ArrayList<Integer>();
		for(int i=0; i<list.size(); i++) {
			gameList.add(1);
		}
		System.out.println("단어게임을 시작합니다! 엔터를 눌러 시작하세요");
		scanner.nextLine();
		for(int i=0; i<max;) {
			int com = (int)(Math.random()*(max));
			if(gameList.get(com)==1) {
				System.out.println(list.get(com).mean + " 철자를 맞춰보세요");
				String user = scanner.nextLine();
				if(user.equals(list.get(com).word)) {
					System.out.println("정답입니다!");
					gameList.set(com, 0);
					i++;
					win++;
				}
				else {
					System.out.println("오답입니다.");
					loss++;
				}
			}
		}
		System.out.println("게임이 종료됐습니다.");
		double a = (double)((win/(win+loss))*100);
		System.out.println("정답횟수 : " + (int)win + " | 오답횟수 : " + (int)loss + "| 정답률 : " + a);
	}
	
	public void deleteWord(String word) {
		list.remove(showIndexNum(word));
	}
	
	public void printWord(String word) {
		System.out.println(list.get(showIndexNum(word)));
		list.get(showIndexNum(word)).setViewNum(list.get(showIndexNum(word)).viewNum+1);
	}
	
	//모든 단어 정보 출력
	public void printAll() {
		System.out.print("단어 : ");
		for(int i=0; i<list.size(); i++) {
			System.out.print("["+list.get(i).getWord()+"]" + " ");
		}
	}
	
	public void viewRank() {
		ArrayList<Vocabulary> sortList = new ArrayList<Vocabulary>(list);
		sortList.sort(Comparator.comparing(Vocabulary::getViewNum).reversed());
		System.out.println(sortList.toString());
	}
	
}
