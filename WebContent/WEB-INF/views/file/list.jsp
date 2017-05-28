<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="/0601.FileUploadHomework/">홈으로 가기</a>
	<table border="1">
		<thead>
		<tr align="center">
			<td>아이디</td>
		
			<td>작성자</td>
		
			<td>제목</td>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="bean" items="${lists}">
		<tr align="center">
			<td>${bean.id}</td>
		
			<td>${bean.writer}</td>
		
			<td><a href="showContent?id=${bean.id}">${bean.title}</a></td>
		
				<%-- <a href="deleteFile_v1?id=${bean.id}">
			    	<img src="../fileupload/resources/img/delete_icon.png">
				</a> --%>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	
</body>
</html>