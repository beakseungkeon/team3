package universityTeam;

import java.util.ArrayList;
import java.util.List;

public class UniversityManage {
	List<People> student = new ArrayList<People>();
	List<People> professor = new ArrayList<People>();
	List<Department> department = new ArrayList<Department>();
	List<Lecture> lecture = new ArrayList<Lecture>();
	
	boolean insertStd(String name, int age, String department) {
		return false;
	}
	
	boolean updateStd(int num, String name, int age) {
		return true;
	}
	
	
	boolean removeStd(int num) {
		People stdNum = new People(num);
		if(!student.contains(stdNum)) {
			System.out.println("해당학번의 학생이 존재하지 않습니다.");
			return false;
		}
		int index = student.indexOf(stdNum);
		student.remove(index);
		return false;
	}
	
	boolean insertDepartment(String name) {
		return true;
	}
	
	boolean updateDepartment(String name, String name2) {
		return false;
		
	}
	
	boolean removeDepartment(String name) {
		Department dname = new Department(name);
		if(department.contains(dname)) {
			int index = department.indexOf(dname);
			department.remove(index);
			return true;
		}
		else {
			System.out.println("해당되는 이름의 학과가 없습니다.");
			return false;
		}
	}
}
