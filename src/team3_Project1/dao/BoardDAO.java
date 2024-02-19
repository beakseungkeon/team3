package team3_Project1.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import team3_Project1.model.vo.Board;
import team3_Project1.model.vo.Category;
import team3_Project1.model.vo.Comment;
import team3_Project1.model.vo.Member;
import team3_Project1.model.vo.Post;

public interface BoardDAO {

	List<Member> getMember();

	boolean insertMember(@Param("member")Member member);

	List<Category> getCategory();

	List<Post> getMyPost(String me_id);

	List<Comment> getMyComment(String me_id);

	List<Board> getBoard(String ca_title);

	List<Post> getPost(@Param("bo_num")int bo_num, @Param("postListNum")int postListNum, @Param("postListNum5")int postListNum5);

	List<Post> getDetailPost(int num);

	String getName(String name);

	void updateView(int num);

	boolean insertPost(@Param("post")Post post);

	boolean insertComment(@Param("comment")Comment comment);

	List<Comment> getCommentList(int co_po_num);
	
	ArrayList<Member> selectMemberList(String email);

	boolean addMember(@Param("member")Member member);

	ArrayList<Member> selectMemberListid(String id);

	boolean deleteUser(@Param("id")String id);

	boolean addTitle(@Param("title")String title);

	ArrayList<Category> selectMemberListCa(String title);

	boolean deleteCa(String title);

	ArrayList<Board> selectMemberListBo(String title);

	boolean deleteBo(String title);

	boolean addTitleBo(@Param("board")Board board);

	boolean addTitlePo(@Param("bo_title")String bo_title,  @Param("ca_title")String ca_title, @Param("post") Post post);

	boolean deletePo(@Param("po_title")String po_title,@Param("bo_title") String bo_title,@Param("ca_title") String ca_title);

	boolean updatePo(@Param("bo_title") String bo_title,@Param("ca_title") String ca_title,@Param("post") Post post);
	
	ArrayList<Post> selectMemberListPo(@Param("po_title")String po_title);
	
	boolean deleteCo(@Param("po_title")String po_title,@Param("bo_title") String bo_title, @Param("ca_title")String ca_title, @Param("co_num")int co_num);

	void updateMyBoard(@Param("po_num")int po_num, @Param("po_title")String po_title, @Param("po_content")String po_content);

	void deleteMyBoard(int po_num);

	
}
