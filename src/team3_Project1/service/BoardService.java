package team3_Project1.service;

import java.util.List;
import team3_Project1.model.vo.Member;

public interface BoardService {
	//등록되어 있는 멤버들의 정보를 가져옴
	List<Member> getMember();

	boolean insertMember(Member member);

	//멤버를 등록함
	
	

}
