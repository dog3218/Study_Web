<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board JSP</title>
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
</br></br></br></br></br></br>
	<h3>제목: ${vo.title } </h3>
	<table>
		<tr>
			<th>작성자</th>
			<td>${vo.writter }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${vo.content }</td>
		</tr>
		<tr>
			<th>작성일자</th>
			<td>${vo.writedate }</td>
		</tr>
	</table>
	<div class="btnSet" style="text-align: center; margin: 10px auto;">
		<a class="btn-fill" href="list.bo"> 글 목록</a> 
		<a class="btn-fill"
			href="new.bo"> 새로운 글 작성</a> 
		<a class="btn-fill" href="modify.bo?id=${vo.id }">수정
		</a>
		<a class="btn-fill"
			onclick="if(confirm('정말 삭제하시겠습니까?'))
			{href='delete.bo?id=${vo.id }'}"> 삭제</a>
	
	</div>
</body>
</html>