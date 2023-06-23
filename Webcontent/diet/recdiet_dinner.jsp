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
              <td class="h5 border-end" >������</td>
              <td class="h5 border-end" >294kcal</td>
              <td class="h5">ź��ȭ��(67.41g), �ܹ���(6.09g), ����(0.63g), ���(0g), ��Ʈ��(0mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">�ñ�ġ���屹</td>
              <td class="h5 border-end" >120kcal</td>
              <td class="h5">ź��ȭ��(17.48g), �ܹ���(7.91g), ����(2.8g), ���(5.63g), ��Ʈ��(1173mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >����Ұ��</td>
              <td class="h5 border-end" >310kcal</td>
              <td class="h5" >ź��ȭ��(35.5g), �ܹ���(11g), ����(9.8)g), ���(4.8g), ��Ʈ��(175mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end" >���̺��߻�ä</td>
              <td class="h5 border-end" >19kcal</td>
              <td class="h5" >ź��ȭ��(4.11g), �ܹ���(2.41g), ����(0.94g), ���(0g), ��Ʈ��(0mg)</td>
            </tr>
            <tr>
              <td class="h5 border-end">����</td>
              <td class="h5 border-end">65kcal</td>
              <td class="h5">ź��ȭ��(5g), �ܹ���(3g), ����(4g), ���(5g), ��Ʈ��(50mg)</td>
            </tr>
          </tbody>
        </table>
      </div>
<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>