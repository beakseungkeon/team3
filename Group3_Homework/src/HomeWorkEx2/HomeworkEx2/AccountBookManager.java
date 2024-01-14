package hwteam3;

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
		/* 강사 피드백
		 * - income에 month가 유효한지 확인하는 작업이 필요.
		 * - 밖에서 체크는 하지만 작업을 하는 여기는 확신할 수 없음. 
		 * - num은 1아니면 0? 무엇을 의미하는지 모르겠음. 
		 * - 지출이나 수입의 개수라면 1씩 증가를 해야하는데 내역이 추가되면 항상 1
		 * - 아래 지출 추가도 피드백 같음*/
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
			/* 강사 피드백
			 * num의 역할이 단순히 지출/수입 내역이 있는지 없는지 확인하려는 변수라면 boolean이 더 적절함.
			 * 현재 이코드는 향상된 for문을 이용할 수 있음 */
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
		/* 강사 피드백
		 * - null체크하는건 좋은데 &&가 아니라 ||로 해야 둘 중 하나라도 비었으면 처리가 됨.
		 * - &&로 하면 수입리스트가 null이 더라도 지출 리스트가 null이 아니면 동작됨*/
		if(incomeList==null&&expenseList==null) {
			System.out.println("입력되어있는 정보가 없습니다.");
			return;
		}
		
		Income im = new Income(month);
		Expense em = new Expense(month);
		/* 강사 피드백
		 * - 해당 달의 첫번째 수입/지출 내역만 검색됨. */
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
	
	public void removeInitialization(String message) {
		/* 강사 피드백
		 * - 반복문에 else를 넣으면 메모가 5개 있고, 삭제 하려는 메모가 없는 경우 해당하는 메모가 없습니다가 여러번 출력되는 현상이 발생.
		 * - 메모가 같은 경우 모두 삭제하는 문제가 발생.*/
		for(int i=0;i<incomeList.size();i++) {
			if(incomeList.get(i).getMessage().equals(message )) {
				incomeList.remove(i);
			}
			else if(expenseList.get(i).getMessage().equals(message )) {
				expenseList.remove(i);
			}
			else {System.out.println("해당하는 메모가 없습니다.");
			
			}
		}
		
	}

	public void changeInitialization(int month,int date,int incomeMoney,String message,String message2) {
		// TODO Auto-generated method stub
		for(int i=0;i<incomeList.size();i++) {
			/* 강사 피드백
			 * - 수입과 지출에 메모가 같은 번지에 있는 경우 하나만 수정됨*/
			if(incomeList.get(i).getMessage().equals(message)) {
				incomeList.get(i).setDate(date);
				incomeList.get(i).setMonth(month);
				incomeList.get(i).setMessage(message2);
				incomeList.get(i).setIncomeMoney(incomeMoney);
				
			}
			else if(expenseList.get(i).getMessage().equals(message)){
				expenseList.get(i).setDate(date);
				expenseList.get(i).setMonth(month);
				expenseList.get(i).setMessage(message2);
				expenseList.get(i).setExpenseMoney(incomeMoney);
			}
			else {System.out.println("해당하는 메모가 없습니다.");
			
			}
	
		}
	}
}
