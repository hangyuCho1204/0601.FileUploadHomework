<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function checkForm(  ){
	var isCheck = document.myform.isCheck.value ;
	var id1 = document.myform.writer.value ;
	var id2 = document.myform.title.value ;
	//alert( isCheck ) ;
	if( isCheck == 'false' ){
		if(id1 != "" && id2 != ""){
			return true;
		}else{
		alert('작성자와 제목을 입력해주세요') ;
		return false ;
		}
	}
}		
</script>
</head>
<body>
	<a href="/0601.FileUploadHomework/">홈으로 가기</a>
	
	<form name="myform" method="post" enctype="multipart/form-data" onsubmit="return checkForm()">
		<input type="hidden" name="isCheck" value="false">
		<fieldset>
			작성자 : <input name="writer" type="text" name="writer"><br>
		</fieldset>
		<fieldset>
			제목 : <input name="title" type="text" name="title" ><br>
		</fieldset>
		<fieldset>
			파일 : <input type="file" name="upFile">
		</fieldset>
		<fieldset>
			파일 : <input type="file" name="upFile">
		</fieldset>
		<fieldset>
			<input type="submit" value="업로드" >
		</fieldset>
	</form>
</body>
</html>