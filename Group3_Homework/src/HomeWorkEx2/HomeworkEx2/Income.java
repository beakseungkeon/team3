package hwteam3;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Income {
	/* 강사 피드백
	 * - 년은 관리 안하는지? 해가 바뀌면 관리가 안됨.
	 * - 수입 클래스와 지출 클래스를 따로 관리해도 되는데,
	 *   멤버가 모두 동일하기 때문에 부모 클래스 Item에 공통 멤버를 추가하고, 
	 *   Income에는 수입, Expense에는 지출로 상속해서 사용하면 좋음
	 *   
	 * class Item{
	 * 		String type;
	 * 		int month, date, money;
	 * 		String messsage;
	 * }
	 * class Income extends Item{
	 * 		//타입을 수입으로
	 * }
	 * class Expense extends Item{
	 * 		//타입을 지출로
	 * }
	 * */
	int month, date;
	int incomeMoney;
	String message;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Income other = (Income) obj;
		return month == other.month;
	}
	@Override
	public int hashCode() {
		return Objects.hash(month);
	}
	@Override
	public String toString() {
		return date + "일 : " + "+" +incomeMoney + "  메모 : " + message;
	}
	public Income(int month) {
		super();
		this.month = month;
	}
	public Income(String message) {
		
		this.message=message;
	}
	
	
}
