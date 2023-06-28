<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	
	<div class="container my-5">
        <ul class="nav nav-tabs">
            <li class="nav-item mynav-item">
                <a class="nav-link active" aria-current="page" href="manage_member.html"
                    style="text-decoration: none;  color: inherit">회원관리</a>
            </li>
            <li class="nav-item  mynav-item">
                <a href="<c:url value='/SubscribeServlet?command=submem_list'/>" class="nav-link" style="text-decoration: none; color: inherit">구독회원 관리</a>
            </li>
            <li class="nav-item  mynav-item">
                <a class="nav-link" href="#" style="text-decoration: none;  color: inherit">레시피관리</a>
            </li>
            <li class="nav-item  mynav-item">
                <a href='<c:url value="/DietServlet?command=diet_list"/>' class="nav-link"  style="text-decoration: none;  color: inherit">식단관리</a>
            </li>
            <li class="nav-item  mynav-item">
                <a href='<c:url value="/DietServlet?command=dietDetail_list"/>' class="nav-link" style="text-decoration: none;  color: inherit">식단상세 관리</a>
            </li>
            <li class="nav-item  mynav-item">
                <a class="nav-link" href="#" style="text-decoration: none;  color: inherit">게시판관리</a>
            </li>
        </ul>
    </div>
    <div style="height: 3rem;"></div>
    <div class="container">
        <div class="container d-flex flex-wrap justify-content-center">
            <form class="d-flex" role="search" action="#">
                <input class="form-control me-2" type="text" placeholder="검색어를 입력하세요." aria-label="Search"
                    style="width: 20rem;">
                <button class="btn btn-outline-secondary" type="submit">검색</button>
            </form>
        </div>
    </div>
    <div style="height: 3rem;"></div>
    <div class="container">
        <table class="table text-center border">
            <thead>
                <tr>
                    <th scope="col">구분</th>
                    <th scope="col">회원 번호</th>
                    <th scope="col">회원 아이디</th>
                    <th scope="col">회원 비밀번호</th>
                    <th scope="col">회원 이름</th>
                    <th scope="col">회원 연락처</th>
                    <th scope="col">회원 이메일</th>
                    <th scope="col">회원 가입일</th>
                    <th scope="col">구독 여부</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <th scope="row">1</th>
                    <td>0000</td>
                    <td>id</td>
                    <td>pw</td>
                    <td>name</td>
                    <td>phone</td>
                    <td>email</td>
                    <td>YYYY/MM/DD</td>
                    <td>Yes / No</td>
                </tr>
                <tr>
                    <th scope="row">2</th>
                    <td>1111</td>
                    <td>id</td>
                    <td>pw</td>
                    <td>name</td>
                    <td>phone</td>
                    <td>email</td>
                    <td>YYYY/MM/DD</td>
                    <td>Yes / No</td>
                </tr>
                <tr>
                    <th scope="row">3</th>
                    <td>2222</td>
                    <td>id</td>
                    <td>pw</td>
                    <td>name</td>
                    <td>phone</td>
                    <td>email</td>
                    <td>YYYY/MM/DD</td>
                    <td>Yes / No</td>
                </tr>
                <tr>
                    <th scope="row">4</th>
                    <td>3333</td>
                    <td>id</td>
                    <td>pw</td>
                    <td>name</td>
                    <td>phone</td>
                    <td>email</td>
                    <td>YYYY/MM/DD</td>
                    <td>Yes / No</td>
                </tr>
                <tr>
                    <th scope="row">5</th>
                    <td>4444</td>
                    <td>id</td>
                    <td>pw</td>
                    <td>name</td>
                    <td>phone</td>
                    <td>email</td>
                    <td>YYYY/MM/DD</td>
                    <td>Yes / No</td>
                </tr>
            </tbody>
        </table>
    </div>
    
	<jsp:include page="../footer.jsp"></jsp:include>
	
	

</body>
</html>