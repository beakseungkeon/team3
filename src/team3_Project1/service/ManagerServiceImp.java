package team3_Project1.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import team3_Project1.dao.BoardDAO;
import team3_Project1.model.vo.Board;
import team3_Project1.model.vo.Category;
import team3_Project1.model.vo.Member;
import team3_Project1.model.vo.Post;

public class ManagerServiceImp implements ManagerService {
	private BoardDAO boardDao;
	public ManagerServiceImp() {
		String resource = "team3_Project1/config/mybatis-config.xml";
		
		InputStream inputStream;
		SqlSession session;
		try {
			inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			session = sessionFactory.openSession(true);
			boardDao = session.getMapper(BoardDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public boolean addMember(Member member) {
		if(member ==null 
				|| member.getMe_id() == null
				|| member.getMe_pw() == null
				|| member.getMe_email() == null
				|| member.getMe_name() == null) {
			return false;
		}
		return boardDao.addMember(member);
	}
	@Override
	public ArrayList<Member> getMemberList(String email) {
		
		return boardDao.selectMemberList(email);
	}
	@Override
	public ArrayList<Member> getMemberListid(String id) {
		// TODO Auto-generated method stub
		return boardDao.selectMemberListid(id);
	}
	@Override
	public boolean deleteUser(String id) {
		// TODO Auto-generated method stub
		return boardDao.deleteUser(id);
	}
	@Override
	public boolean addTitle(String title) {
		// TODO Auto-generated method stub
		return boardDao.addTitle(title);
	}
	@Override
	public ArrayList<Category> getMemberListCa(String title) {
		// TODO Auto-generated method stub
		return boardDao.selectMemberListCa(title);
	}
	@Override
	public boolean deleteCa(String title) {
		// TODO Auto-generated method stub
		return boardDao.deleteCa(title);
	}
	@Override
	public ArrayList<Board> getMemberListBo(String title) {
		// TODO Auto-generated method stub
		return boardDao.selectMemberListBo(title);
	}
	@Override
	public boolean deleteBo(String title) {
		// TODO Auto-generated method stub
		return boardDao.deleteBo(title);
	}
	@Override
	public boolean addTitleBo(Board board) {
		// TODO Auto-generated method stub
		return boardDao.addTitleBo(board);
	}
	@Override
	public boolean addTitlePo(String bo_title, String ca_title, Post post) {
		// TODO Auto-generated method stub
		return boardDao.addTitlePo(bo_title,ca_title,post);
	}
	
	@Override
	public boolean deletePo(String po_title,String bo_title,String ca_title) {
		// TODO Auto-generated method stub
		return boardDao.deletePo(po_title,bo_title,ca_title);
	}
	@Override
	public boolean updatePo( String bo_title, String ca_title, Post post) {
		// TODO Auto-generated method stub
		return boardDao.updatePo(bo_title,ca_title,post);
	}
	@Override
	public ArrayList<Post> getMemberListPo(String po_title) {
		// TODO Auto-generated method stub
		return boardDao.selectMemberListPo(po_title);
	}
	@Override
	public boolean deleteCo(String po_title, String bo_title, String ca_title, int co_num) {
		// TODO Auto-generated method stub
		return boardDao.deleteCo(po_title,bo_title,ca_title,co_num);
	}
}
