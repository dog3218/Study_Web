<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>

</head>
<body>
</br></br></br></br></br>
	<h3>여기는 로그인 페이지</h3>
	<%@ include file="../include/header.jsp" %>
	<div class="container" style="width: 100%; height:500px; font-size: 30px; margin-top: 10px;">
		<form action = "memberlogin" method= "post">
			<input type="text" id="userid" name="userid" placeholder="아이디"/><br />
			<input type="text" id="userpw" name="userpw" placeholder="비밀번호"/><br />
			
			<a><button type="button" onclick="go_login()" >로그인</button></a>
		</form>
		
	</div>
	<%@ include file="../include/footer.jsp" %>
	
	
	<script type="text/javascript">
		function go_login() {
			if($('#userid').val()==''){
				alert('아이디를 입력해주세요');
				$("#userid").focus();
			}else if($("#userpw").val()==''){
				alert('비밀번호를 입력해주세요');
				$("#userpw").focus();
				return;
			}
		
		$.ajax({
			type : 'post',
			url : 'iotlogin',/*Controller에서 받을 url주소(mapping)*/
			data : {
				id : $("#userid").val(),
				pw : $("#userpw").val()
			},
			success : function (response){
			alert(response);
				if(response=='true'){
					//결과가 트루이면 페이지를 홈으로 간다.
					//jstl c:test 사용 해서 index.jsp페이지의
					//로그인이라는 글씨를 로그아웃으로 바꾼다.
					alert('로그인되었습니다.');
					location.href="/iot/home";
					
				}else{
					alert('아이디나 비밀번호가 일치하지 않습니다!');
					
				}
			},error : function(req, text) {
				alert(text+ ' : '+req.status);
				
			}
			
		});
			
		}
		/*ajax -> url iotlogin*/
	</script>
</body>
</html>