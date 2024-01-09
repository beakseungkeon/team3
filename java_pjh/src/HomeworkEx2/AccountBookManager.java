package HomeworkEx2;

import java.util.ArrayList;
import java.util.List;

public class AccountBookManager {
	
	private List<Income> incomeList = new ArrayList<Income>();
	private List<Expense> expenseList = new ArrayList<Expense>();
	private List<Month> mList = new ArrayList<Month>();
	
	public void initialization() {
		for(int i=1; i<=12; i++) {
			Month month = new Month(i, 0, 0);
			mList.add(month);
		}
	}
	
	public void insertIncome(Income income) { 
		incomeList.add(income);
		int month = income.month-1; // index 값 추출
		int money = mList.get(month).money; 
		Month m = new Month(income.month, money+income.incomeMoney, 1); //기존 저장금액에 이번에 들어온 금액을 더해서 저장
		mList.set(month, m);
		
	}
	
	public void insertexpense(Expense expense) {
		expenseList.add(expense);
		int month = expense.month-1;
		int money = mList.get(month).money;
		Month m = new Month(expense.month, money-expense.expenseMoney, 1); //기존 저장금액에 이번에 빠진 금액을 빼서 저장
		mList.set(month, m);
	}
	
	public boolean viewAllMonth() {
		int j=0;
		for(int i=0; i<12; i++) {
			if(mList.get(i).num!=0) {
				System.out.println("["+mList.get(i).month+"월 : "+mList.get(i).money+"]");
				j++;
			}
		}
		if(j==0) {
			System.out.println("등록되어 있는 정보가 없습니다.");
			return true;
		}
		return false;
	}
	
	public void viewMonth(int month) {
		if(incomeList==null&&expenseList==null) {
			System.out.println("입력되어있는 정보가 없습니다.");
			return;
		}
		
		Income im = new Income(month);
		Expense em = new Expense(month);
		
		if(incomeList.contains(im)) {
			System.out.println(incomeList.get(incomeList.indexOf(im)));
		} else {
			System.out.println("수입내역이 없습니다.");
		}
		if(expenseList.contains(em)) {
			System.out.println(expenseList.get(expenseList.indexOf(em)));
		} else {
			System.out.println("지출내역이 없습니다.");
		}
		
	}
	
	public void removeInitialization(int month) { //아직 작동 안함
		Income im = new Income(month);
		Expense em = new Expense(month);
		//수입삭제할지 지출삭제할지 월 일 메모까지 해서 삭제할 거 결정
		if(incomeList.contains(im)) {
			System.out.println(incomeList.get(incomeList.indexOf(im)));
		} else {
			System.out.println("수입내역이 없습니다.");
		}
		if(expenseList.contains(em)) {
			System.out.println(expenseList.get(expenseList.indexOf(em)));
		} else {
			System.out.println("지출내역이 없습니다.");
		}
		
	}

}
