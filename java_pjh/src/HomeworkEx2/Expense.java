package HomeworkEx2;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Expense {
	int year, month, date;
	int expenseMoney;
	String message;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expense other = (Expense) obj;
		return month == other.month;
	}
	@Override
	public int hashCode() {
		return Objects.hash(month);
	}
	
	@Override
	public String toString() {
		return date + "일 : " + "-" +expenseMoney + "  메모 : " + message;
	}
	public Expense(int month) {
		super();
		this.month = month;
	}
	
}
