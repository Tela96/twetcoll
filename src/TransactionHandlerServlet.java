

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class TransactionHandlerServlet extends javax.servlet.http.HttpServlet
{
    private StringBuilder sb = new StringBuilder();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        buildHead();
        buildBodyStart();
        Map<String, String[]> car = request.getParameterMap();
        String name = car.get("Deal type")[0];
        sb.append("<h2>Your selcted package is : " + name + "</h2>");
        buildBodyEnd();
        PrintWriter writer = response.getWriter();
        writer.print(sb.toString());
        sb.delete(0, sb.length());
        writer.flush();
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException
    {
        PrintWriter writer = response.getWriter();
        writer.println("ASASAS");
        writer.flush();
    }

    private void buildHead()
    {
        sb.append("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <link rel=\"stylesheet\" href=\"styleset.css\">\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "</head>");
    }

    private void buildBodyStart()
    {
        sb.append("<a href=\"twetcol.html\"><button class = \"button\">write and read some feedback</button></a>\n" +
                "    <h1>Congratulations, you just bought the car of your dreams!</h1>\n");
    }

    private void buildBodyEnd()
    {

    }
}
