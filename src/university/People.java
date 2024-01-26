package university;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class People {
	String name;
	int age;
	int num;
	String department;
	List<String> subject;
}
