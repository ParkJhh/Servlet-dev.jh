package com.kitri.myfirstservlet.practice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginOut")
public class loginOut extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        HttpSession session =req.getSession();

        //세션이 새롭거나 또는  세션 아이디값이 널
        if(session.isNew() || session.getAttribute("id") == null) {
            //아이디 없음
            if(!MemberInfo.members.containsKey(name)){
                out.println("해당 회원의 아이디는 존재하지 않습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/practice/loginOut.html >[로그인페이지로]</a>");
            }
            //비밀번호 없음
            if(MemberInfo.members.containsKey(name) && !password.equals(MemberInfo.members.get(name))){
                out.println("비밀번호가 틀렸습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/practice/loginOut.html >[로그인페이지로]</a>");
            }
            //그러면서 아이디,비밀번호가 일치하는 경우
            if(MemberInfo.members.containsKey(name) && password.equals(MemberInfo.members.get(name))) {
                session.setAttribute("id", name);
                out.println("로그인 성공 했습니다.");
                out.println("<p></p>");
                out.println("<a href=http://localhost:8080/ >[메인페이지로]</a>");
            }
        } else {
            out.println("현재 로그인 상태입니다.");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/practice/loginOut.html >[로그인페이지로]</a>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter out =resp.getWriter();

        //httpsession이 존재한다면, 현재 httpsession을 반환하고, 그렇지 않다면 null값을 반환
        //만약 true를 줄 경우, 세션을 생성함
        HttpSession session =req.getSession(false);
        if(session != null && session.getAttribute("id") != null){
            session.invalidate();
            out.println("로그아웃 하였습니다.");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/ >[메인페이지로]</a>");
        } else {
            out.println("로그인 상태가 아닙니다.");
            out.println("<p></p>");
            out.println("<a href=http://localhost:8080/practice/loginOut.html >[로그인페이지로]</a>");
        }
        out.close();
    }
}
