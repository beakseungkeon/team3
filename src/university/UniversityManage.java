package university;

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
	public void InsertDepartment(Department dp) {
		if(student.contains(dp)) {
			System.out.println("이미 등록된 학과입니다.");
			return;
		}
		department.add(dp);
		System.out.println("학과를 등록했습니다.");
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
	public void ChangeDepartment(String dpName,String newDpName,int NewDpCode ) {
		for(int i=0; i<department.size();i++) {
			if(department.get(i).getName().equals(dpName)) {
				department.get(i).setName(newDpName);
				department.get(i).setCode(NewDpCode);
			}
			else {
				System.out.println("해당하는 이름의 학과가 없습니다.");
			}
		}
	}
	public void ChangeStudent(String name,String newName,int newAge,int newNum) {
		for(int i=0;i<student.size();i++) {
			if(student.get(i).getName().equals(name)) {
				student.get(i).setName(newName);
				student.get(i).setAge(newAge);
			}
		}
	}
	public void ChangeProfessor(String name,String newName,int newAge,int newNum) {
		for(int i=0;i<student.size();i++) {
			if(student.get(i).getName().equals(name)) {
				student.get(i).setName(newName);
				student.get(i).setAge(newAge);
			}
		}
	}
	public void InsertStudent(People std) {
		if(student.contains(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
		student.add(std);
		System.out.println("학생을 등록했습니다.");
	}
}