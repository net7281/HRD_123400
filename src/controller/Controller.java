package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.MoneyVO;
import VO.UserVO;
import service.Service;
import sun.rmi.server.Dispatcher;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	Service service;
	
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }
	public void init(ServletConfig config) throws ServletException {
		service = new Service();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandel(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandel(request, response);
	}
	
	protected void doHandel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextpage="";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String action = request.getRequestURI().substring(request.getRequestURI().lastIndexOf("/"));
		System.out.println(action);
		try {
			if(action.equals("/home") || action==null){
				nextpage="/index.jsp";
			}
			else if(action.equals("/signMemberForm")){
				int custno = service.newCustno();
				LocalDate date =LocalDate.now();
				String today = ""+date.getYear()+date.getMonthValue()+date.getDayOfMonth();
				
				request.setAttribute("custno", custno);
				request.setAttribute("today", today);
				
				nextpage="/signMemberForm.jsp";
			}
			else if(action.equals("/listMember")){
				List<UserVO> memberList = service.memberList();
				request.setAttribute("memberList", memberList);
				nextpage="/listMember.jsp";
			}
			else if(action.equals("/listMoney")){
				List<MoneyVO> moneyList = service.moneyList();
				request.setAttribute("moneyList", moneyList);
				nextpage="/listMoney.jsp";
			}
			else if(action.equals("/signMember")){
				UserVO userVO = new UserVO();
				userVO.setCustno(Integer.parseInt(request.getParameter("custno")));
				userVO.setCustname(request.getParameter("custname"));
				userVO.setPhone(request.getParameter("phone"));
				userVO.setAddress(request.getParameter("address"));
				userVO.setGrade(request.getParameter("grade"));
				userVO.setCity(request.getParameter("city"));
				
				service.addMember(userVO);
				nextpage="/listMember";
			}
			else if(action.equals("/modMemberForm")){
				int custno = Integer.parseInt(request.getParameter("custno"));
				UserVO userVO = service.oneMemberList(custno);
				request.setAttribute("user", userVO);
				
				nextpage="/modMemberForm.jsp";
			}
			else if(action.equals("/modMember")){
				UserVO userVO = new UserVO();
				userVO.setCustno(Integer.parseInt(request.getParameter("custno")));
				userVO.setCustname(request.getParameter("custname"));
				userVO.setPhone(request.getParameter("phone"));
				userVO.setAddress(request.getParameter("address"));
				userVO.setGrade(request.getParameter("grade"));
				userVO.setCity(request.getParameter("city"));
				
				service.modMember(userVO);
				nextpage="/listMember";
			}
			
			//****
			RequestDispatcher dispatcher = request.getRequestDispatcher(nextpage);
			dispatcher.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
