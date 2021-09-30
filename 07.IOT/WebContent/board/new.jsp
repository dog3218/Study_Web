<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table {
   width: 80%;
   margin: 0 auto;
   border: 1px solid;
   border-collapse: collapse;
}

table th, table td {
   border: 1px solid;
   padding: 5px 10px;
}

a.btn-fill {
   text-align: center;
   padding: 3px 10px;
   border: 1px solid #3367d6;
   border-radius: 3px;
   box-shadow: 2px 2px 3px #022d72;
}

.valid, .invalid {
   font-size: 13px;
   font-weight: bold;
}

.valid {
   color: green;
}

.invalid {
   color: red;
}
</style>
</head>
<body>
<%@ include file="/include/header.jsp" %>
</br></br></br></br>
	<h3>새로운 글 작성</h3>
	<form action="insert.bo" method="post"	>
	<table>
		
		<tr>
			<th>ID</th>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><input type="text" class = "content" name = "content" /></td>
		 </tr>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writter" value="${id }님"></td>
		</tr>
	</table>
	<div class = "btnSet" style="text-align : center; margin: 10px auto;">
		<a class="btn-fill" onclick='$("form").submit()'>저장</a>
		<a class="btn-fill" onclick='cancel()'>취소</a>
	</div>
	</form>
	  <%@include file="/include/footer.jsp" %>
       <script type="text/javascript">
       	function cancel() {
			if(confirm('작성중이던 글을 취소하시겠습니까?')){
				location.href="list.bo";
			}
		}
       </script>
</body>
</html>