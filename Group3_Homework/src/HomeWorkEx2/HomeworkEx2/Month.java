package hwteam3;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
/* 강사 피드백
 * - Month 클래스는 무슨 클래스인지?
 * - num은 어떤 멤버인지?
 * */
public class Month {
	int month, money, num;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Month other = (Month) obj;
		return month == other.month;
	}

	@Override
	public int hashCode() {
		return Objects.hash(month);
	}

	@Override
	public String toString() {
		return "[" + month + "월 : " + money + "]\n";
	}
	
}
