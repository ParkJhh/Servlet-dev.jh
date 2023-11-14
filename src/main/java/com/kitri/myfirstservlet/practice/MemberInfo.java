package com.kitri.myfirstservlet.practice;


import com.kitri.myfirstservlet.practice.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet(name="회원정보 저장",value="/memberInfo")
public class MemberInfo extends HttpServlet {
    //map에 아이디를 key,비밀번호를 밸류?
    ServletContext servletContext = null;
    static HashMap<String, String> members = new HashMap<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        servletContext = config.getServletContext(); //상태저장
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String pwcheck = req.getParameter("pwcheck");

        if(members.containsKey(name)){
            out.println("이미 존재하는 회원 아이디입니다.");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/practice/join.html >[회원가입 페이지로]</a>");
        } else if(!password.equals(pwcheck)){
            out.println("비밀번호가 일치하지 않습니다.");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/practice/join.html >[회원가입 페이지로]</a>");
        } else {
            members.put(name,password);
            out.println("회원가입이 완료 되었습니다.");
            out.println("<hr>");
            out.println("<a href=http://localhost:8080/ >[메인페이지로]</a>");
        }
    }

}
