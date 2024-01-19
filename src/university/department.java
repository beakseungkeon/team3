package university;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class department {
	String name;
	int code;
	List<People> student;
	List<People> professor;
}
