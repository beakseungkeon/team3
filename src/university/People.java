package university;

import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class People {
	String name;
	int age;
	int num;
	String department;
	public People(int num) {
		super();
		this.num = num;
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return num == other.num;
	}
	@Override
	public String toString() {
		return "이름 : " + name + ",  번호 = " + num;
	}
	
}
