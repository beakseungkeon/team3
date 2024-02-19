package team3_Project1.service;

import java.util.ArrayList;
import team3_Project1.model.vo.Board;
import team3_Project1.model.vo.Category;
import team3_Project1.model.vo.Member;
import team3_Project1.model.vo.Post;

public interface ManagerService {
	boolean addMember(Member member);

	ArrayList<Member> getMemberList(String email);

	ArrayList<Member> getMemberListid(String id);

	boolean deleteUser(String id);

	boolean addTitle(String title);

	ArrayList<Category> getMemberListCa(String title);

	boolean deleteCa(String title);

	ArrayList<Board> getMemberListBo(String title);

	boolean deleteBo(String title);

	boolean addTitleBo(Board board);

	boolean addTitlePo(String bo_title, String ca_title, Post post);

	boolean deletePo(String po_title, String bo_title, String ca_title);

	boolean updatePo(String bo_title, String ca_title, Post post);
	
	ArrayList<Post> getMemberListPo(String po_title);
	
	boolean deleteCo(String po_title, String bo_title, String ca_title, int co_num);
}
