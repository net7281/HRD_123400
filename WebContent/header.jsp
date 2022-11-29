<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
<style type="text/css">
	header{
		width: 100%; height: 120px;
		background-color: #444;
	}
	header h1{
		text-align: center;
		color: #fff;
		line-height: 90px;
	}
	header nav{
		background-color: #666;
		height: 30px;
	}
	header nav a{
		color: #fff;
		text-decoration: none;
		line-height: 30px;
		margin: 0 15px;
	}
</style>
</head>
<body>
	<header>
		<h1>쇼핑몰 회원관리 ver 1.0</h1>
		<nav>
			<a href="/HRD_123400/signMemberForm">회원등록</a>
			<a href="/HRD_123400/listMember">회원조회/수정</a>
			<a href="/HRD_123400/listMoney">매출조회</a>
			<a href="/HRD_123400/home">홈으로.</a>
		</nav>
	</header>
</body>
</html>