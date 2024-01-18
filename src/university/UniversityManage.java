package university;

import java.util.ArrayList;
import java.util.List;

public class UniversityManage {
	List<People> student = new ArrayList<People>();
	List<People> professor = new ArrayList<People>();
	List<department> department = new ArrayList<department>();
	List<Lecture> lecture = new ArrayList<Lecture>();
	
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
}
