package com.kitri.myfirstservlet.state;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="requestServlet",value="/request")
public class RequestServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //HttpServletRequest 는 요청 단위로 객체가 생성. 응답하면 객체 소멸

        String site = req.getParameter("site");
        if(site.equals("naver")){
            //네이버로 이동(리다이렉트)
            resp.sendRedirect("https://www.naver.com");
        } else if(site.equals("google")){
            resp.sendRedirect("https://www.google.com");
        } else if(site.equals("daum")){
            resp.sendRedirect("https://www.daum.net");
        }

    }
}
