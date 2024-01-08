package HomeworkEx2;

import java.util.ArrayList;
import java.util.List;

public class AccountBookManager {
	
	private List<Income> incomeList = new ArrayList<Income>();
	private List<Expense> expenseList = new ArrayList<Expense>();
	private List<Month> mList = new ArrayList<Month>();
	
	public void initialization() {
		for(int i=1; i<=12; i++) {
			Month month = new Month(i, 0);
			mList.add(month);
		}
	}
	
	public void insertIncome(Income income) {
		incomeList.add(income);
		int month = income.month-1; // index 값 추출
		int money = mList.get(month).money; 
		Month m = new Month(income.month, money+income.incomeMoney); //기존 저장금액에 이번에 들어온 금액을 더해서 저장
		mList.set(month, m);
	}
	
	public void insertexpense(Expense expense) {
		expenseList.add(expense);
		int month = expense.month-1;
		int money = mList.get(month).money;
		Month m = new Month(expense.month, money-expense.expenseMoney); //기존 저장금액에 이번에 빠진 금액을 빼서 저장
		mList.set(month, m);
	}
	
	public void viewAllMonth() {
		System.out.println(mList.toString());
	}
	
	public void viewMonth(int month) {
		if(incomeList==null&&expenseList==null) {
			System.out.println("입력되어있는 정보가 없습니다.");
			return;
		}
		
		Income im = new Income(month);
		Expense em = new Expense(month);
		
		if(incomeList.contains(im)) {
			System.out.println(incomeList.get(month-1));
		} else {
			System.out.println("수입내역이 없습니다.");
		}
		if(expenseList.contains(em)) {
			System.out.println(expenseList.get(month-1));
		} else {
			System.out.println("지출내역이 없습니다.");
		}
		
	}
	
}
