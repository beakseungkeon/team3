package university;

import java.util.List;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Department {
	String name;
	int code;
	List<People> student;
	List<People> professor;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(name, other.name);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
	public Department(String name) {
		super();
		this.name = name;
	}
}
