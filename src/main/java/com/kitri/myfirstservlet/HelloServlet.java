package com.kitri.myfirstservlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

//어노테이션을 통해 web.xml에 자동등록됨
//http메세지는 get,post,put,delete메소드가 설정되어있음
//벨류는 아래와 같은 구조도 가능함
//value = {/hello-servlet, /hello-servlet/a}
//value에 대해선 정확히 지정된 것을 먼저 찾으며 애매할 경우, 전체를 받아줄수 있는 밸류로 이동
@WebServlet(name = "helloServlet", value = "/hello-servlet/*" )
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //아래 text/html은 미디어 타입으로 text를 지정
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    public void destroy() {
    }
}