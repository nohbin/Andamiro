<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
<script type="text/javascript">

if (window.name == "join") {
window.opener.parent.location.href = "MemberServlet?command=member_join_form&id=${param.id}";
} else if(window.name =="edit"){
	window.opener.parent.location.href = "MemberServlet?command=mypage_edit&memberNumber=${loginUser.memberNumber }&id=${param.id}";
}
window.close();
</script>
</body>
</html>