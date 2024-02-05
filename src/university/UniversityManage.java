package university;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UniversityManage {
	List<People> student = new ArrayList<People>();
	List<People> professor = new ArrayList<People>();
	List<Department> department = new ArrayList<Department>();
	List<Lecture> lecture = new ArrayList<Lecture>();
	
	boolean checkNum(int stdproCheck, int num) { //교번&학번 확인 메서드
		if(stdproCheck==0) {                     //학생 학번조회
			People pnum = new People(num);
			if(student.contains(pnum)) {
				return true;
			}
			return false;
		}
		else if(stdproCheck==1) {               //교수 교번조회
			People pnum = new People(num);
			if(professor.contains(pnum)) {
				return true;
			}
			return false;
		}
		else {
			return false;
		}
	}
	
	boolean insertStd(String name, int age, String department) {
		int index; String num;
		Department d = new Department(department);
		if(!this.department.contains(d)) {
			System.out.println("해당하는 이름의 과가 존재하지 않습니다.");
			return false;
		}
		
		//학과번호를 받아서 등록하는날의연도+학과코드+1~ 의 학번을 생성
		index = this.department.indexOf(d);
		String indexNum = Integer.toString(this.department.get(index).getCode());
		int stdCount = 1;
		for(int i=0; i<student.size(); i++) {
			if(student.get(i).department.equals(department)) {
				stdCount++;
			}
		}
		num = "2024"+indexNum+Integer.toString(stdCount);                //<--"2024" 부분 날짜 클래스 사용하는 것으로 수정해야 함
		People std = new People(name, age, Integer.parseInt(num), department);
		student.add(std);

		return true;
	}
	
	boolean updateStd(int num, String name, int age) { // 수강중인 강의는 수강신청부분에서 바꿀 수 있으므로 학생정보수정은 이름, 나이 
		People stdNum = new People(num);
		if(!student.contains(stdNum)) {
			System.out.println("해당학번의 학생이 존재하지 않습니다.");
			return false;
		}
		int index = student.indexOf(stdNum);
		student.get(index).name=name;
		student.get(index).age=age;
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
		return true;
	}
	
	boolean insertDepartment(String name) {
		int max=999, min=100; int rnum = 0; // 원래는 100-999
		Department dName = new Department(name);
		if(department.contains(dName)) {
			System.out.println("중복된 이름의 과가 존재합니다.");
			return false;
		}
		
		if(department.size()==0) {
			rnum = (int)(Math.random()*(max-min+1)+min);
			Department d = new Department(name, rnum);
			department.add(d);
			return true;
		}
		
		while(true) {
			rnum = (int)(Math.random()*(max-min+1)+min);
			int j=1;
			for(int i=0; i<department.size(); i++) {
				if(department.get(i).code == rnum) {
					j++;
				}
			}
			if(j==1) {
				break;
			}
		}
		
		Department d = new Department(name, rnum);
		department.add(d);
		return true;
	}
	
	boolean updateDepartment(String name, String name2) {
		Department dname = new Department(name);
		if(department.contains(dname)) {
			int index = department.indexOf(dname);
			department.get(index).setName(name2);
			for(int i=0; i<student.size(); i++) {
				if(student.get(i).department.equals(name)) {
					student.get(i).department = name2;
				}
			}
			for(int i=0; i<professor.size(); i++) {
				if(professor.get(i).department.equals(name)) {
					professor.get(i).department = name2;
				}
			}
			return true;
		}
		else {
			System.out.println("해당되는 이름의 학과가 없습니다.");
			return false;
		}
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
	
	void departmentListShow(String name) {
		Department dname = new Department(name);
		int index = department.indexOf(dname);
		System.out.println(department.get(index).toString());
	}
	
	boolean insertPro(String name, int age, String department) {
		int index; String num;
		Department d = new Department(department);
		if(!this.department.contains(d)) {
			System.out.println("해당하는 이름의 과가 존재하지 않습니다.");
			return false;
		}
		
		//학과번호를 받아서 등록하는날의연도+학과코드+1~ 의 교번을 생성
		index = this.department.indexOf(d);
		String indexNum = Integer.toString(this.department.get(index).getCode());
		int stdCount = 1;
		for(int i=0; i<professor.size(); i++) {
			if(professor.get(i).department.equals(department)) {
				stdCount++;
			}
		}
		//학번과 교번을 구분하기 위해 교번은 101번부터 시작(학생은 1번)
		num = "2024"+indexNum+Integer.toString(stdCount+100);      //<--"2024" 부분 날짜 클래스 사용하는 것으로 수정해야 함
		People std = new People(name, age, Integer.parseInt(num), department);
		professor.add(std);
		
		//초기화 메서드 미구현으로 다른 클래스들에는 반영되고 있지 않음
		
		return true;
	}
	
	boolean updatePro(int num, String name, int age) {
		People proNum = new People(num);
		if(!professor.contains(proNum)) {
			System.out.println("해당교번의 교수가 존재하지 않습니다.");
			return false;
		}
		int index = professor.indexOf(proNum);
		professor.get(index).name=name;
		professor.get(index).age=age;
		return true;
	}
	
	boolean removePro(int num) {
		People proNum = new People(num);
		if(!professor.contains(proNum)) {
			System.out.println("해당교번의 교수가 존재하지 않습니다.");
			return false;
		}
		int index = professor.indexOf(proNum);
		professor.remove(index);
		return true;
		
	}
	
	boolean insertLecture(int num, String name) { //name은 강의이름 같은 이름의 강의이름은 중복있을 수도 있음
		int min=1000, max=9999; 
		if(!checkNum(1,num)) { //교번 확인이니까 1
			System.out.println("해당교번의 교수가 존재하지 않습니다.");
			return false;
		}
		
		int code;
		while(true) {
			code = (int)(Math.random()*(max-min+1)+min);
			Lecture lcode = new Lecture(code);
			if(lecture.contains(lcode)) {
				continue;
			} else {break;}
		}
		HashMap<Integer, String> score = new HashMap<Integer, String>();
		Lecture lecture = new Lecture(name, code, score, num); 
		this.lecture.add(lecture);
		return true;
	}
	
	boolean updateLecture(int code, String name) {
		Lecture lcode = new Lecture(code);
		if(!lecture.contains(lcode)) {
			System.out.println("해당되는 코드의 강의가 없습니다.");
			return false;
		}
		int index = lecture.indexOf(lcode);
		lecture.get(index).name = name;
		return true;
	}
	
	boolean removeLecture(int num, int code) {
		if(!checkNum(1, num)) { //교번이니까 1
			System.out.println("해당교번의 교수가 존재하지 않습니다.");
			return false;
		}
		Lecture lcode = new Lecture(code);
		if(!lecture.contains(lcode)) {
			System.out.println("해당되는 코드의 강의가 없습니다.");
			return false;
		}
		int index = lecture.indexOf(lcode);
		lecture.remove(index);
		return true;
	}
	
	boolean insertStdLecture(int num, int code) { //수강신청
		if(!checkNum(0, num)) { //학생이니까 0
			System.out.println("해당되는 학번이 없습니다.");
			return false;
		}
		Lecture lcode = new Lecture(code);
		if(!lecture.contains(lcode)) {
			System.out.println("해당되는 코드의 강의가 없습니다.");
			return false;
		}
		//lecture 리스트에 학생번호 넣기
		int index = lecture.indexOf(lcode); //학생이 입력한 강의코드에 맞는 리스트 번호
		//이 밑으로 오류
		lecture.get(index).score.put(num, "N"); //성적의 초기값 null
		return true;
	}
	
	boolean removeStdLecture(int num, int code) {
		if(!checkNum(0, num)) { //학생이니까 0
			System.out.println("해당되는 학번이 없습니다.");
			return false;
		}
		Lecture lcode = new Lecture(code);
		if(!lecture.contains(lcode)) {
			System.out.println("해당되는 코드의 강의가 없습니다.");
			return false;
		}
		//lecture 리스트에 학생번호 넣기
		int index = lecture.indexOf(lcode); //학생이 입력한 강의코드에 맞는 리스트 번호
		
		lecture.get(index).score.remove(num); //입력받은 학번에 맞는 score 해쉬맵의 값을 지움
		return true;
	}
	
	boolean insertScore(int index, int num, String score) {
		lecture.get(index).score.put(num, score);		
		return true;
	}
	
	boolean removeScore(int index, int num) {
		lecture.get(index).score.remove(num);
		return true;
	}
	void showScore(int code) {
		Lecture lcode = new Lecture(code);
		int index = lecture.indexOf(lcode);
		System.out.println(lecture.get(index).score);
	}
	
}
