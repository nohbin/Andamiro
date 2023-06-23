<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
      <li class="nav-item col-12 col-md-3">
          <a class="nav-link active" style=" color: black;" aria-current="page" href="recdiet.jsp">��õ�Ĵ�</a>
      </li>
      <li class="nav-item col-12 col-md-3">
        <a class="nav-link" style=" color: black;" aria-current="page" href="simplediet.jsp">���ܽĴ�</a>
    </li>
    <li class="nav-item col-12 col-md-3">
      <a class="nav-link" style=" color: black;" aria-current="page" href="lowdiet.jsp">��Į�θ��Ĵ�</a>
  </li>
  <li class="nav-item col-12 col-md-3">
    <a class="nav-link" style=" color: black;" aria-current="page" href="proteindiet.jsp">����ƾ�Ĵ�</a>
</li>
  </ul>
</div>
      <div style="height: 3rem;"></div>
      <div class="container">
          <div class="row" >
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet.jsp'">��ħ</button>
                </div>
                <img src="../resources/img/diet1.png" class="img-fluid3">
                <div class="mealment">�ҹ�,������ �ް�����, �ñ�ġ����, ���߱�ġ,ȣ�θ�ġ����</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_lunch.jsp'">����</button>
                </div>
                <img src="../resources/img/diet2.png" class="img-fluid3">
                <div class="mealment">���, ���ڱ�, ��ġ����, ȣ�ڳ���, ���ġ</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='recdiet_dinner.jsp'">����</button>
                </div>
                <img src="../resources/img/diet3.png" class="img-fluid3">
                <div class="mealment"> ������, �ñ�ġ���屹, ����Ұ��, ���̺��߻�ä, ����</div>
              </div>
            </div>
          </div> 
        </div> 
      <div style="height: 7rem;"></div>
      <div class="container">
        <div class="row">
          <div class="col d-flex justify-content-between my-3">
            <span class="h4" style="font-weight: bold;">�Ĵܺ� ��������</span>
            <span>*1�κ� ���� �������� �Դϴ�.</span>
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
              <td class="h5 border-end" >���</td>
              <td class="h5 border-end" >264kcal</td>
              <td class="h5">ź��ȭ��(57.38g), �ܹ���(5.65g), ����(0.46g), ���(0g), ��Ʈ��(564mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">���ڱ�</td>
              <td class="h5 border-end" >85kcal</td>
              <td class="h5">ź��ȭ��(9.39g), �ܹ���(4.32g), ����(3.35g), ���(0.68g), ��Ʈ��(274mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >��ġ����</td>
              <td class="h5 border-end" >270kcal</td>
              <td class="h5" >ź��ȭ��(0.2g), �ܹ���(23.9g), ����(17.9g), ���(0g), ��Ʈ��(130mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >ȣ�ڳ���</td>
              <td class="h5 border-end" >19kcal</td>
              <td class="h5" >ź��ȭ��(1.3g), �ܹ���(0.5g), ����(1.4g), ���(1.3g), ��Ʈ��(2mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">���ġ</td>
              <td class="h5 border-end">22kcal</td>
              <td class="h5">ź��ȭ��(4.75g), �ܹ���(1.21g), ����(0.19g), ���(1.43g), ��Ʈ��(454mg)</td>
            </tr>
          </tbody>
        </table>
      </div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>