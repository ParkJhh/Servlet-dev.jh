import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name="gugudanservlet",value = "/gugudan-servlet")
public class gugudanservlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        PrintWriter out = resp.getWriter();
        int gugunum = Integer.parseInt(req.getParameter("number"));

        out.println("<html><body>");
        out.println("입력하신 숫자 : " +  req.getParameter("number"));

        out.println("<DIV style=position: page; text-align: center; font-size: 35px>");
        for(int i = gugunum; i < gugunum + 1; i++) {
            for (int j = 1; j < 10; j++) {
                out.println(i + " * " + j + " = " + i * j);
                out.println("<br></br>");
            }
            out.println("<hr>");
        }
        out.println("</DIV>");

        out.println("</body></html>");
    }
}
