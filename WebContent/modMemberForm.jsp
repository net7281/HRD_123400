<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="VO.UserVO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>쇼핑몰 회원관리  프로그램</title>
<% UserVO user = (UserVO)request.getAttribute("user");%>
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
		width: 800px;
		margin: 0 auto;
	}
	table,table tr, table td, table th{
		border: 1px solid #333;
	}
	section table th{
		width: 40%;
	}
	section table td{
		text-align: center;
	}
	section table input{
		width: 100%;
	}
	section table button{
		width: 100px;
	}
	
</style>
<script type="text/javascript">
	function ckForm() {
		var form = document.signForm;
		if(form.custname.value==""){
			alert("회원성명이 입력되지 않았습니다.");
			form.custname.focus();
			return false;
		}
		if(form.phone.value==""){
			alert("회원전화가 입력되지 않았습니다.");
			form.phone.focus();
			return false;
		}
		if(form.address.value==""){
			alert("회원주소가 입력되지 않았습니다.");
			form.address.focus();
			return false;
		}
		if(form.grade.value==""){
			alert("고객등급이 입력되지 않았습니다.");
			form.grade.focus();
			return false;
		}
		if(form.city.value==""){
			alert("도시코드가 입력되지 않았습니다.");
			form.city.focus();
			return false;
		}
		form.submit();
	}
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<h3>홈쇼핑 회원 등록</h3>
		<form name="signForm" action="/HRD_123400/modMember">
			<table>
			  <tr>
			    <th>회원번호(자동생성)</th>
			    <td> <input type="text" name="custno" value="<%=user.getCustno() %>" readonly="readonly" /> </td>
			  </tr>
			  <tr>
			    <th>회원성명</th>
			    <td> <input type="text" name="custname" value="<%=user.getCustname() %>"/> </td>
			  </tr>
			  <tr>
			    <th>회원전화</th>
			    <td> <input type="text" name="phone" value="<%=user.getPhone()%>"/> </td>
			  </tr>
			  <tr>
			    <th>회원주소</th>
			    <td> <input type="text" name="address" value="<%=user.getAddress() %>" /> </td>
			  </tr>
			  <tr>
			    <th>가입일자</th>
			    <td> <input type="text" name="joindate" value="<%=user.getJoindate() %>" disabled="disabled" /> </td>
			  </tr>
			  <tr>
			    <th>고객등급[A:VIP,B:일반,C:직원]</th>
			    <td> <input type="text" name="grade" value="<%=user.getGrade() %>" /> </td>
			  </tr>
			  <tr>
			    <th>도시코드</th>
			    <td> <input type="text" name="city" value="<%=user.getCity() %>" /> </td>
			  </tr>
			  <tr>
			  	<td colspan="2">
			  		<button type="button" onclick="ckForm()">수정</button>
			  		<button type="button" onclick="location('/HRD_123400/listMember')">조회</button>
			  	</td>
			  </tr>
			</table>
		</form>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>