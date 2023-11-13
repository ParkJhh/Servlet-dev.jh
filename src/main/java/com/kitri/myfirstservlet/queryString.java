package com.kitri.myfirstservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "queryStringServlet", value = "/query-string-servlet")
public class queryString extends HttpServlet {
    //get 메서드 요청 처리
    //쿼리 스트링은 get.Paramet()으로


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //get은 일반적으로 조회할때 사용
        out.println("GET요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();
        //POST는 등록할때 사용한다
        req.setCharacterEncoding("UTF-8");
        out.println("POST요청\n");
        out.println(req.getParameter("name") + "\n");
        out.println(req.getParameter("city") + "\n");
    }
}
