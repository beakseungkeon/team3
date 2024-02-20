package team3_Project1.service;

import java.util.List;

import team3_Project1.model.vo.Board;
import team3_Project1.model.vo.Category;
import team3_Project1.model.vo.Comment;
import team3_Project1.model.vo.Member;
import team3_Project1.model.vo.Post;

public interface BoardService {

	//등록되어 있는 멤버들의 정보를 가져옴
	List<Member> getMember();

	boolean insertMember(Member member);

	List<Category> getCategory();

	List<Post> getMyPost(String me_id);

	List<Comment> getMyComment(String id);

	List<Board> getBoard(String ca_title);

	List<Post> getPost(int bo_num, int postListNum, int postListNum5);

	List<Post> getDetailPost(int num);

	String getName(String name);

	void updateView(int num);

	boolean insertPost(Post post);

	boolean insertComment(Comment comment);

	List<Comment> getCommentList(int co_po_num);

	void updateMyBoard(int po_num, String po_title, String po_content);

	void deleteMyPost(int po_num);

	String getBoardTitle(int boardMenu);

	void deleteMyComment(int po_num);

	void updateMyComment(int co_num);

}
