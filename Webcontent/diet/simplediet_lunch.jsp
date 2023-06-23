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
          <a class="nav-link" style=" color: black;" aria-current="page" href="recdiet.jsp">��õ�Ĵ�</a>
      </li>
      <li class="nav-item col-12 col-md-3">
        <a class="nav-link active" style=" color: black;" aria-current="page" href="simplediet.jsp">���ܽĴ�</a>
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
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='simplediet.jsp'">��ħ</button>
                </div>
                <img src="../resources/img/simple.png" class="img-fluid3">
                <div class="mealment">�����ð��� 30�� ������ �����Ƿ� �̷���� �Ĵ�</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='simplediet_lunch.jsp'">����</button>
                </div>
                <img src="../resources/img/simple.png" class="img-fluid3">
                <div class="mealment">�����ð��� 30�� ������ �����Ƿ� �̷���� �Ĵ�</div>
              </div>
            </div>
            <div class="col-12 col-md-4">
              <div class="text-center">
                <div>
                  <button type="button" class="btn btn-outline-warning mb-3" onclick="location.href='simplediet_dinner.jsp'">����</button>
                </div>
                <img src="../resources/img/simple.png" class="img-fluid3">
                <div class="mealment"> �����ð��� 30�� ������ �����Ƿ� �̷���� �Ĵ�</div>
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
              <td class="h5 border-end">����</td>
              <td class="h5 border-end">Į�θ�1</td>
              <td class="h5">���缺��1</td>
            </tr>
            <tr>
              <td class="h5 border-end">����</td>
              <td class="h5 border-end">Į�θ�2</td>
              <td class="h5">���缺��2</td>
            </tr>
            <tr>
              <td class="h5 border-end">����</td>
              <td class="h5 border-end">Į�θ�3</td>
              <td class="h5">���缺��3</td>
            </tr>
            <tr>
              <td class="h5 border-end">����</td>
              <td class="h5 border-end">Į�θ�4</td>
              <td class="h5">���缺��4</td>
            </tr>
            <tr>
              <td class="h5 border-end">����</td>
              <td class="h5 border-end">Į�θ�5</td>
              <td class="h5">���缺��5</td>
            </tr>
          </tbody>
        </table>
      </div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>