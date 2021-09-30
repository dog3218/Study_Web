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
.page_on, .page_off{
display: inline-block;
line-height: 30px;
margin: 0;
min-width: 22px; padding: 0 5px 2px;}

.page_on{
border : 1px solid blue;
background: : blue;
color: black; font-weight: bold;}

select{
height: 32px;}

.page_list {
margin : 0 auto;
width : 100%; }
</style>
</head>
<body>
 <%@ include file="/include/header.jsp" %>
<h3 style="text-align: center; margin: 10px auto;">게시판 목록</h3>
<form action="list.bo" method="post">
	<input type="hidden" name="curPage" value="1" />
	<div id="list-top">
		<ul>
			<li>
				<select name="search">
					<option value="all" ${page.search eq 'all' ? 'selected' : '' }>전체</option>
					<option value="title" ${page.search eq 'title' ? 'selected' : '' }>제목</option>
					<option value="content" ${page.search eq 'content' ? 'selected' : '' }>내용</option>
					<option value="writer" ${page.search eq 'writer' ? 'selected' : '' }>작성자</option>
				</select>
				<input value="${page.keyword }"	type="text" name="keyword">
				<a class="btn-fill" onclick="$('form').submit();">검색</a>
			</li>
		</ul>
	</div>
</form>

<%-- <c:if test="${page eq nulll }">
	<a>비어있음</a>
</c:if>
<c:if test="${page ne nulll }">
	<a>안비어있음</a>
	${fn:length(page.list)} 
</c:if> --%>
	<table>
		<tr>
			<th>번호</th>
			<th>회원ID(고유번호)</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
		</tr>
			<c:forEach items="${page.list}" var="vo">
		<tr>
			<td><a  href="detail.bo?id=${vo.id}" > ${vo.no } </a></td>		
			<td><a href= "detail.bo?id=${vo.id}" > ${vo.id } </a></td>		
			<td><a href= "detail.bo?id=${vo.id}" > ${vo.title} </a></td>		
			<td><a  href="detail.bo?id=${vo.id}" > ${vo.writter} </a></td>		
			<td><a  href="detail.bo?id=${vo.id}" > ${vo.writedate } </a></td>		
		</tr>
			</c:forEach>
	</table>
	<!--공통으로 사용할 수 있음 pageVO (common) -->
	<!-- 글 건수가 많으면 처음 또는 블럭의 이전 처리를 기능 -->
	<div class="page_list">
	<!-- 이전, 처음으로 이동 -->
	<a>현재 블록: ${page.curBlock }</a><br/>
	<c:if test="${page.curBlock gt 1 }">
		<a class= "page_first" title="처음" onclick="go_page(1)">처음</a>
		<a class= "page_prev" title="이전"
		 onclick="go_page(${page.curPage - 1})">이전</a>
	</c:if>
 	<c:forEach begin="${page.beginPage }"	end="${page.endPage }" var="no">
		<c:if test="${no eq page.curPage }">
			<span class="page_on"> ${no }</span>
		</c:if>			
		<c:if test="${no ne page.curPage }">
			<span class="page_off" onclick ="go_page(${no})"> ${no }</span>
		</c:if>			
	</c:forEach>
	<!-- 다음/마지막 -->
	<c:if test="${page.curBlock lt page.totalBlock }">
		<a class = "page_next" title='다음' onclick ="go_page(${page.curPage+1})">다음</a>
		<a class = "page_last" title='마지막' onclick ="go_page(${page.totalPage})">마지막</a>
	</c:if>
	
	<!-- 글 건수가 많으면 마지막 또는 블럭의 다음 처리를 기능 -->
	
	</div>
		 <%@include file="/include/footer.jsp" %>
	<script type="text/javascript">
		function go_page(page) {
			/* alert(page); */
			$('[name=curPage]').val(page);
			$('form').submit();
			
		};
	</script>
</body>
</html>