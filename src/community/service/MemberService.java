package community.service;

import java.util.ArrayList;
import java.util.List;

import community.model.vo.Board;
import community.model.vo.Category;
import community.model.vo.MemberVO;
import community.model.vo.post;

public interface MemberService {

	boolean addMember(MemberVO member);

	ArrayList<MemberVO> getMemberList(String email);

	ArrayList<MemberVO> getMemberListid(String id);

	boolean deleteUser(String id);

	boolean addTitle(String title);

	

	boolean deleteCa(String title);

	ArrayList<Board> getMemberListBo(String title);

	boolean deleteBo(String title);

	



	boolean addTitleBo(Board board);

	boolean addTitlePo(String bo_title, String ca_title, post post);

	boolean deletePo(String po_title, String bo_title, String ca_title);

	

	boolean updatePo(String bo_title, String ca_title, post post);

	ArrayList<Category> getMemberListCa(String ca_title);

	ArrayList<post> getMemberListPo(String po_title);

	boolean deleteCo(String po_title, String bo_title, String ca_title, int co_num);

	

	

	




}
