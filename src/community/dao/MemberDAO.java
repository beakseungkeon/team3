package community.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import community.model.vo.Board;
import community.model.vo.Category;
import community.model.vo.MemberVO;
import community.model.vo.post;

public interface MemberDAO {

	

	

	ArrayList<MemberVO> selectMemberList(String email);

	boolean addMember(@Param("member")MemberVO member);

	ArrayList<MemberVO> selectMemberListid(String id);

	boolean deleteUser(@Param("id")String id);

	boolean addTitle(@Param("title")String title);

	ArrayList<Category> selectMemberListCa(String title);

	boolean deleteCa(String title);

	ArrayList<Board> selectMemberListBo(String title);

	boolean deleteBo(String title);



	

	boolean addTitleBo(@Param("member")Board board);

	boolean addTitlePo(@Param("bo_title")String bo_title,  @Param("ca_title")String ca_title, @Param("post") post post);

	boolean deletePo(@Param("po_title")String po_title,@Param("bo_title") String bo_title,@Param("ca_title") String ca_title);

	
	boolean updatePo(@Param("bo_title") String bo_title,@Param("ca_title") String ca_title,@Param("post") post post);

	
	




	

}
