package HomeworkEx2;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Income {
	int year, month, date;
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
	
	
	
}
