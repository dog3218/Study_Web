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
</br></br></br></br></br></br>
	<h3>${vo.name } 고객정보</h3>
	<table>
		<tr>
			<th>성별</th>
			<td>${vo.gender }</td>
		</tr>
		<tr>
			<th>이메일</th>
			<td>${vo.email }</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${vo.phone }</td>
		</tr>
	</table>
	<div class="btnSet" style="text-align: center; margin: 10px auto;">
		<a class="btn-fill" href="list.cu"> 고객목록</a> 
		<a class="btn-fill"
			href="new.cu"> 신규고객추가</a> 
		<a class="btn-fill" href="modify.cu?id=${vo.id }">수정
		</a>
		<a class="btn-fill"
			onclick="if(confirm('정말 삭제하시겠습니까?'))
			{href='delete.cu?id=${vo.id }'}"> 삭제</a>
	
	</div>
	   <%@include file="/include/footer.jsp" %>
</body>
</html>