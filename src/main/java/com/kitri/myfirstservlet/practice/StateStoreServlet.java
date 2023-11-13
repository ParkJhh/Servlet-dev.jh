package com.kitri.myfirstservlet.practice;

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
import java.util.HashMap;

@WebServlet(name = "stateStoreServlet", value = "/state-store")
public class StateStoreServlet extends HttpServlet {
    int memberCount = 0; // 필드 (멤버 변수)
    ServletContext servletContext = null;

    HashMap<HttpSession, Integer> users = new HashMap<>();

    //init은 서블릿이 최초 생성될 때 1번 실행
    @Override
    public void init(ServletConfig config) throws ServletException {
        servletContext = config.getServletContext(); //상태저장하는 첫번째 방법
        servletContext.setAttribute("count",new Integer(0));
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         int localCount = 0; // 지역 변수
        resp.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("멤버변수카운트 : " + ++memberCount);

        out.println("로컬변수카운트 : " + ++localCount);

        //ServletContext WAS가 시작되고나서 WAS끝날때까지
        //홈페이지에 들어올때마다 어플리케이션 단위로 저장
        int applicationCount = (int) servletContext.getAttribute("count");
//        int applicationCount = (int) this.getServletContext().getAttribute("count");
        servletContext.setAttribute("count",++applicationCount);
        out.println("애플리케이션 단위 카운트 : " + applicationCount);

        //Session 클라이언트의 요청부터 클라이언트의 요청이 종료 될때까지
        HttpSession session = req.getSession(); //세션 ID 추출
        //클라이언트의 요청마다 세션 아이디가 생성됨
        if(session.isNew()){
            out.println("세션 생성 완료 : " + session.getId());
        }

        Integer sessionCount = (Integer) session.getAttribute("count");
        if(sessionCount == null){
            sessionCount =0;
            session.setAttribute("count",sessionCount);
        }
        session.setAttribute("count", ++sessionCount);
        out.println("세션 단위 카운트 : " + sessionCount);

        //세션 받아서 담기
        out.println("---해당 페이지에 접속한 유저별 방문 횟수---");
        users.put(session, sessionCount);
        users.forEach((key, value) -> {
            out.println(key + " : " + value);
        });
    }
}