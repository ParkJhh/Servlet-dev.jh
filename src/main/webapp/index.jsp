<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>

<body bgcolor="#f0f8ff" text="#708090">
  <DIV style="position: page; text-align: center; font-size: 35px">
    <h1>반갑습니다</h1>
  </DIV>
  <DIV style="position: page; text-align: center; font-size: 25px">
    <p><%="서블릿 기본"%></p>
  </DIV>
  <hr>

  <DIV style="text-align: start; font-size: 20px; line-height: 40px">
    <a href=practice/gugudan.html title="야 너두 구구단 할 수 있어."> 실습1) 구구단 계산하기</a>
    <p></p>
    <a href=practice/Calc.html title="야 너두 계산할 수 있어"> 실습2) 숫자 두개 계산하기</a>
    <p></p>
    <%-- 주소창의 값. 패키지 안의 값이 아님. ex) practice/state-store 404에러 발생. state-store가 맞음  --%>
    <a href =state-store> 상태정보 유지 기술 (애플리케이션 단위:ServletContext) </a>
    <p></p>
    <a href =practice/user-visit.html> 상태정보 유지 기술(세션 단위) </a>
    <p></p>
    <a href =cookie>  상태정보 유지 기술(쿠키 만들기) </a>
    <p></p>
    <a href =cookie-read>  상태정보 유지 기술(쿠키 읽어오기) </a>
    <p></p>
    <a href =practice/site.html>  상태정보 유지 기술(요청 단위) </a>
    <p></p>
    <a href =dispatcher1>  포워드 </a>
    <p></p>

    <a href ="memberInfo.html"> 쿼리 스트링 </a>
    <p></p>
    <a href ="trackInfo.html"> 공사중 </a>
    <p></p>
  </DIV>
  <hr>

  <DIV style="text-align: center; font-size: 15px; letter-spacing: 2px">
  <a href="https://www.google.com/" target="_blank">[구글 검색(새창으로)]</a>
  <a href="https://www.naver.com/" target="_blank">[네이버 검색(새창으로)]</a>
  <a href="https://www.youtube.com/" >[유튜브 검색]</a>
  </DIV>
</body>
</html>