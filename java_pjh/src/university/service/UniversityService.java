package university.service;

import java.util.List;

import university.UniversityManage;

public interface UniversityService {
	
	boolean insert(List<UniversityManage> list, int num);
	
	boolean update(List<UniversityManage> list, int num);
	
	boolean remove(List<UniversityManage> list, int num);
}
