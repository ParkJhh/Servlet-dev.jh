package com.kitri.myfirstservlet.state;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="cookieServlet",value="/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();
        //쿠키 : 상태 정보 저장(클라이언트 측에서 저장됨)
        //서버에 접속할 떄 자동으로 요청에 포함되어 전달됨
        //쿠키를 응답에 담아 보내야 함
        //new Cookie("id","guest");
        //쿠키 객체를 addCookie의 매개변수로 넘겨줌
        Cookie cookie1 = new Cookie("id","guest");
        //초단위로 쿠키의 시간을 정함
        cookie1.setMaxAge(60 * 60 * 24);
        resp.addCookie(cookie1);

        Cookie cookie2 = new Cookie("code", "007");
        //아래 URL에 해당 될 때만, 쿠키 지정
        //쿠키가 필요한 페이지에만 생성하여 사용
        cookie2.setPath("/cookie-read");
        resp.addCookie(cookie2);

        out.println("쿠키 전송 완료");
    }
}
