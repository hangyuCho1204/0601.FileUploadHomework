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
	<a href="/0601.FileUploadHomework/">홈으로 가기</a><br>
	<a href="list">게시판 목록가기</a>
	<table border="1">
		<thead>
		<tr align="center">
			<td>아이디</td>
		
			<td>작성자</td>
		
			<td>제목</td>
		</tr>
		</thead>
		<tbody>
		
		<tr align="center">
			<td>${fileModel.id}</td>
		
			<td>${fileModel.writer}</td>
		
			<td>${fileModel.title}</td>
			
		</tr>
		
		</tbody>
	</table>
	<c:if test="${fileModel.files != null}">
	<table border="1">
		<thead>
		<tr align="center">
			<td>첨부파일</td>
		</tr>
		</thead>
		<tbody>
		
		<tr align="left">
			<td>
			<c:forEach var="bean" items="${fileModel.files}">
				<a href="download?id=${bean.id}">${bean.originalFileName}</a>&nbsp<a href="deleteFile?Did=${bean.id}">[삭제]</a><br>
			</c:forEach>
			</td>
			
		</tr>
		
		</tbody>
	</table>
	</c:if>
</body>
</html>