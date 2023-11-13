package com.kitri.myfirstservlet.state;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/dispatcher1")
public class DispatcherServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();
        out.println("<h3> Dispatcher1 수행 결과 </h3>");

        //forward(전달) forword하기 위해 객체 생성후 담아서 넣어야함
        //forward는 forward로 가서 실행
        ServletContext sc = this.getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");


        req.setAttribute("name","키트리");
        rd.forward(req,resp);
        //include는 여기있는 것도 실행하며, forward에 있는 것도 실행
        //rd.include(req, resp);
    }
}
