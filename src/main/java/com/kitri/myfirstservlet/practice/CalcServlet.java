package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="calcServlet", value="/pratice/calc")
public class CalcServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        int val1 = Integer.parseInt(req.getParameter("val1"));
        String opvalue = req.getParameter("op");
        int val2 = Integer.parseInt(req.getParameter("val2"));


        out.println("입력하신 숫자 : " + val1 + ", " + val2);
        out.println("<hr>");
        if(opvalue.equals("plus")){
            out.println("더하기 계산 : " + (val1 + val2));
            out.println("<p></p>");
        } else if (opvalue.equals("minus")) {
            out.println("빼기 계산 : " + (val1 - val2));
            out.println("<p></p>");
        } else if(opvalue.equals("mul")){
            out.println("곱하기 계산 : " + (val1 * val2));
            out.println("<p></p>");
        } else if(opvalue.equals("div")){
            out.println("나누기 계산 : " + (val1 / val2));
            out.println("<p></p>");
        } else if(opvalue.equals("mod")){
            out.println("나머지 계산 : " + (val1 % val2));
            out.println("<p></p>");
        } else {
            out.println("잘못된 옵션입니다.");
        }
        out.println("<hr>");
    }
}
