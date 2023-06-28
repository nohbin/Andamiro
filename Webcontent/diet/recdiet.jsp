<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/my.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
  <style>
    li{
      list-style: none;
    }
    a {
            color: black;
            text-decoration: none;
        }
  </style>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container border mt-3 rounded-3 w-50">
		<ul class="nav nav-pills nav-fill row">
			<li class="nav-item col-12 col-md-3"><a class="nav-link active"
				style="color: black;" aria-current="page" href="recdiet.jsp">��õ�Ĵ�</a>
			</li>
			<li class="nav-item col-12 col-md-3"><a class="nav-link"
				style="color: black;" aria-current="page" href="simplediet.jsp">���ܽĴ�</a>
			</li>
			<li class="nav-item col-12 col-md-3"><a class="nav-link"
				style="color: black;" aria-current="page" href="lowdiet.jsp">��Į�θ��Ĵ�</a>
			</li>
			<li class="nav-item col-12 col-md-3"><a class="nav-link"
				style="color: black;" aria-current="page" href="proteindiet.jsp">����ƾ�Ĵ�</a>
			</li>
		</ul>
	</div>
       <div style="height: 3rem;"></div>
  <%--     <div class="container">
          <div class="row" >
       <c:forEach var="diet" items="${dietList}">   
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet.jsp'">${diet.diet_menu}</button>
                </div>
                <img src="upload/${diet.diet_picture}" class="img-fluid3">
                <div class="mealment">�ҹ�, ������ �ް�����, �ñ�ġ����, ���߱�ġ, ȣ�θ�ġ����</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_lunch.jsp'">${diet.diet_menu}</button>
                </div>
                <img src="upload/${diet.diet_picture}"  class="img-fluid3">
                <div class="mealment">���, ���ڱ�, ��ġ����, ȣ�ڳ���, ���ġ</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_dinner.jsp'">${diet.diet_menu}</button>
                </div>
                <img src="upload/${diet.diet_picture}"  class="img-fluid3">
                <div class="mealment"> ������, �ñ�ġ���屹, ����Ұ��, ���̺��߻�ä, ����</div>
              </div>
            </div>
		 </c:forEach> --%>

		<div class="container">
			<div class="row">
				<c:forEach var="diet" items="${dietList}">
					<div class="col-12 col-md-4">
						<div class="text-center">
							<div>
								<button type="button" class="btn btn-outline-warning mb-3"
									onclick="location.href='recdiet.jsp'">${diet.diet_menu}
								</button>
							</div>
							<img src="upload/${diet.diet_picture}" style="width: 15rem; height: 10rem;">
<%-- 							<c:forEach var="dietDetail" items="${dietDetailList}">
								<div>
									<div class="fw-bold">${dietDetail.foodName}</div>
								</div>
							</c:forEach> --%>
					</div>
					</div>
				</c:forEach>
				<c:forEach var="dietDetail" items="${dietDetailList}">
					<div style="margin-left:10rem;">
				      <div class="fw-bold">
						${dietDetail.foodName}
				      </div>
					</div>
				</c:forEach> 
				<c:forEach var="dietDetail" items="${dietDetailList2}">
					<div style="margin-left:10rem;">
				      <div class="fw-bold">
						${dietDetail.foodName}
				      </div>
					</div>
				</c:forEach> 
				<c:forEach var="dietDetail" items="${dietDetailList3}">
					<div style="margin-left:10rem;">
				      <div class="fw-bold">
						${dietDetail.foodName}
				      </div>
					</div>
				</c:forEach> 
			</div>
		</div>	
		<!-- �������  -->
		<div style="height: 4rem;"></div>
		<div class="container">
			<div class="row">
				<div class="col d-flex justify-content-between my-3">
					<span class="h4" style="font-weight: bold;">�Ĵܺ� ��������</span> <span>*1�κ�
						���� �������� �Դϴ�.</span>
				</div>
			</div>
			<table class="table table-hover" style="height: 300px;">
				<thead class="table-primary text-center head">
					<tr>
						<td>���ĸ�</td>
						<td>Į�θ�</td>
						<td>���缺��</td>
					</tr>
				</thead>
				<tbody class="table-secondary">
					<tr>
						<td class="h5 border-end">�ҹ�</td>
						<td class="h5 border-end" id="cell2">310kcal</td>
						<td class="h5">ź��ȭ��(67.32g), �ܹ���(5.61g), ����(0.85g), ���(0g),
							��Ʈ��(4mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">������ �ް�����</td>
						<td class="h5 border-end">350kcal</td>
						<td class="h5">ź��ȭ��(12g), �ܹ���(10.32g), ����(8.29g), ���(5.86g),
							��Ʈ��(502mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">�ñ�ġ����</td>
						<td class="h5 border-end">57kcal</td>
						<td class="h5">ź��ȭ��(6.16g), �ܹ���(2.74g), ����(3.08g),
							���(0.81g), ��Ʈ��(497mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">���߱�ġ</td>
						<td class="h5 border-end">25kcal</td>
						<td class="h5">ź��ȭ��(4.4g), �ܹ���(1.4g), ����(0.2g), ���(0g),
							��Ʈ��(232mg)</td>
					</tr>
					<tr>
						<td class="h5 border-end">ȣ�θ�ġ����</td>
						<td class="h5 border-end">127kcal</td>
						<td class="h5">ź��ȭ��(5.44g), �ܹ���(7.01g), ����(8.96g), ���(0.31g),
							��Ʈ��(695mg)</td>
					</tr>
				</tbody>
			</table>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>