package team3_Project1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import team3_Project1.model.vo.Member;

public interface BoardDAO {

	List<Member> getMember();

	boolean insertMember(@Param("member")Member member);
	
}
