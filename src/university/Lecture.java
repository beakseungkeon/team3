package university;

import java.util.HashMap;
import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Lecture {
	String name; // 강의이름
	int code; // 강의코드
	HashMap<Integer, String> score; // 학생학번 : 성적 맵
	String professor; // 담당교수 이름
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lecture other = (Lecture) obj;
		return code == other.code;
	}
	@Override
	public int hashCode() {
		return Objects.hash(code);
	}
	public Lecture(int code) {
		super();
		this.code = code;
	}
	public Lecture(String name) {
		super();
		this.name = name;
	}
}
