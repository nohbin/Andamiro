<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Calendar" %> 
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="../resources/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="../resources/css/my.css">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
  <link href="https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Nanum+Pen+Script&display=swap" rel="stylesheet">
  <style>
     li{
      list-style: none;
    }
    
    label{
 	 display: block;
  	 margin-top: 10px;
	}
  </style>
  <title>결제창</title>
  <script>
    function closePopup(){
      window.close();

    }
    function showMsg() {
      alert("결제가 완료되었습니다. 구독 서비스를 이용하실 수 있습니다.")
    }
  </script> 
</head>
<body> 
  <div class="container border border-warning rounded-3 my-3 p-3" style="width: 40rem;">
    <div class="container text-center mb-2" style="width: 14rem;">
      <div class="fs-4 rounded-2 fw-bold" style="background-color: #f7dd4ae1;">
        구매상품명
      </div>
    </div>
    <div class="container text-center fs-5 lh-3">
      안다미로 밥상 구독 서비스<br>              
    </div>
  </div>  
  <div style="height: 3rem;"></div>
  <div class="container">
    <div class="container mb-2">
      <div class="fs-4 text-center rounded-2 fw-bold" style="background-color: #f7dd4ae1; width: 7rem;">
        결제내용
      </div>
    </div>
    <div class="container fs-5 lh-lg border border-warning rounded-3 my-3 py-2">
      <ul>
        <li>구매 상품명 : 안다미로 밥상 구독 서비스</li>
        <li>이용기간 : <%= getCurrentDate() %> ~ <%= getFutureDate(30) %></li>
        <li>결제 금액 : 3300원</li>
      </ul>          
    </div>
  </div>  
  <div style="height: 3rem;"></div>
  <form action="#"> <!--폼 태그 시작-->
  <div class="container">
    <div class="container mb-2">
      <div class="fs-4 text-center rounded-2 fw-bold" style="background-color: #f7dd4ae1; width: 7rem;">
        결제수단
      </div>
    </div>
  </div>  
  <div class="container text-center">
    
    <div class="row border border-warning rounded-3 my-3 py-2">
      <div class="col">
        <img src="../resources/img/페이코2.png" class="img-fluid4">
        
          <label>
          <input type="radio" id="payway" name="payway" value="no">
          </label>
        
      </div>
      <div class="col">
        <img src="../resources/img/npay.png"  class="img-fluid4">
        
          <label><input type="radio" id="payway" name="payway" value="no"></label>
        
      </div>
      <div class="col">
        <img src="../resources/img/토스2.png" class="img-fluid4">
        
          <label><input type="radio" id="payway" name="payway" value="no"></label>
        
      </div>
      <div class="col">
        <img src="../resources/img/카카오페이2.png" class="img-fluid4">
        
          <label><input type="radio" id="payway" name="payway" value="no"></label>
        
      </div>
    </div>
  </div>
  <div style="height: 3rem;"></div>
  <div class="container">
    <div class="mb-2 fs-4">
      약관동의
    </div>
    <div class="fw-bold mb-4">
      
        <input type="checkbox" name="termcheck" value="약관">&nbsp; 주문 내용을 확인하였으며, 정보 제공 등에 동의합니다.
      
    </div>
    <div>
    </div>    
  </div>
  <div class="container text-center">
    <button class=" btn btn-light fs-2 btn-lg me-2" style="width: 10rem" onclick="closePopup()">
      취소
    </button>
    <button onclick="showMsg()" class=" btn btn-outline-warning btn-lg ms-2 fw-bold fs-2" style="width: 10rem; text-decoration: none; color: #000;">
      결제
    </button>
  </div>
</form>
  <div style="height: 3rem;"></div>
</body>
</html>
<%!
  // 현재 날짜를 가져오는 함수
  public String getCurrentDate() {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy. MM. dd");
    Calendar calendar = Calendar.getInstance();
    return dateFormat.format(calendar.getTime());
  }

  // 현재로부터 n일 후의 날짜를 가져오는 함수
  public String getFutureDate(int n) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy. MM. dd");
    Calendar calendar = Calendar.getInstance();
    calendar.add(Calendar.DAY_OF_MONTH, n);
    return dateFormat.format(calendar.getTime());
  }
%>   
