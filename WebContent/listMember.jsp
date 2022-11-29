<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="VO.UserVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% List<UserVO> memberList = (List<UserVO>)request.getAttribute("memberList"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쇼핑몰 회원관리  프로그램</title>
<style type="text/css">
	*{margin: 0; padding: 0;}
	section{
		background-color: #eee;
		width: 100%;
		min-height: calc(100vh - 200px);
		overflow: auto;
	}
	section h3{
		margin: 20px 0;
		text-align: center;
	}
	section table{
		width: 1200px;
		margin: 0 auto;
	}
	table,table tr, table td, table th{
		border: 1px solid #333;
	}
	section table td{
		text-align: center;
	}
	section table a{
		color: #fff;
	}
	
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<h3>홈쇼핑 회원 등록</h3>
		<table>
		  <tr>
		  	<th>회원번호</th>
		  	<th>회원성명</th>
		  	<th>전화번호</th>
		  	<th>주소</th>
		  	<th>가입일자</th>
		  	<th>고객등급</th>
		  	<th>거주지역</th>
		  </tr>
		  <% for(int i=0; i< memberList.size(); i++) {%>
		  <tr>
		  	<td><a href="/HRD_123400/modMemberForm?custno=<%=memberList.get(i).getCustno() %>"><%=memberList.get(i).getCustno() %></a></td>
		  	<td><%=memberList.get(i).getCustname() %></td>
		  	<td><%=memberList.get(i).getPhone() %></td>
		  	<td><%=memberList.get(i).getAddress() %></td>
		  	<td><%=memberList.get(i).getJoindate() %></td>
		  	<td>
		  		<% String grade = memberList.get(i).getGrade();
		  			if(grade.equals("A")){%>
		  			<%="VIP" %>
		  			<%}else if(grade.equals("B")){ %>
		  			<%="일반" %>
		  			<%}else if(grade.equals("C")){ %>
		  			<%="직원" %>
		  		<%} %>
		  	</td>
		  	<td><%=memberList.get(i).getCity()%></td>
		  </tr>
		  <%} %>
		</table>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>