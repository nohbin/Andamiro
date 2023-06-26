<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String logoutMessage = (String) request.getAttribute("logoutMessage");
%>
<script type="text/javascript">
    alert("<%= logoutMessage %>");
    location.href = "/Andamiro";
</script>
