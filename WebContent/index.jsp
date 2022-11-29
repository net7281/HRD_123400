<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
	section p{
		margin-left: 10px;
	}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<section>
		<h3>쇼핑몰 회원 관리 프로그램</h3>
		<p>
			쇼핑몰 회원정보와 회원매출정보 데이터베이스를 구축하고 회원관리 프로그램을 작성하는 프로그램이다.<br>
			프로그램 작성 순서<br>
			1. 회원정보 테이블을 생성한다.<br>
			2. 매출정보 테이블을 생성한다.<br>
			3. 회원정보, 매출정보 테이블에 제시된 문제지와 참조데이터를 추가 생성한다.<br>
			4. 회원정보 입력 화면프로그램을 작성한다.<br>
			5. 회원정보 조회 프로그램을 작성한다.<br>
			6. 회원매출정보 조회 프로그램을 작성한다.
		</p>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>