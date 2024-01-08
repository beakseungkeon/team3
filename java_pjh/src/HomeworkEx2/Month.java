package HomeworkEx2;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Month {
	int month, money;

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
