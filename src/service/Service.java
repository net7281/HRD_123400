package service;

import java.util.ArrayList;
import java.util.List;

import VO.MoneyVO;
import VO.UserVO;
import DBPKG.DAO;

public class Service {
	DAO dao;
	public Service(){
		dao = new DAO();
	}
	
	public int newCustno() throws Exception {
		int custno = dao.newSelectCustno();
		return custno;
	}
	
	public List<UserVO> memberList() throws Exception {
		List<UserVO> memberList = dao.SelectCustnoList();
		return memberList;
	}
	
	public List<MoneyVO> moneyList() throws Exception {
		List<MoneyVO> moneyList = dao.SelectMoneyList();
		return moneyList;
	}
	
	public int addMember(UserVO userVO) throws Exception {
		int result = dao.insertCustno(userVO);
		return result;
	}
	
	public UserVO oneMemberList(int custno) throws Exception {
		UserVO userVO = dao.SelectOneCustno(custno);
		return userVO;
	}
	
	public int modMember(UserVO userVO) throws Exception {
		int result = dao.UpdateCustno(userVO);
		return result;
	}
}
