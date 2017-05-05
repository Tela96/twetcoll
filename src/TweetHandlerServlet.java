import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class TweetHandlerServlet extends HttpServlet
{
    private List<Tweet> tweets = new ArrayList<>();
    private StringBuilder sb;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        sb = new StringBuilder();
        buildHead();
        buildBodyStart();
        for (Tweet entry: tweets)
        {
            sb.append("<p>" + entry.getMsg() +"\t"+ entry.getUsrName() +"\t"+ entry.getTimeStamp()+"</p>");
            Writer w = resp.getWriter();
            w.write(sb.toString());
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        sb = new StringBuilder();
        Timestamp time = new Timestamp(System.currentTimeMillis());
        String tweetmsg = req.getParameter("tweet");
        String usrName = req.getParameter("name");
        if (checkProperEntry(tweetmsg, usrName))
        {
            tweets.add(new Tweet(tweetmsg, usrName, time.toString()));
            sb.append("<p>" + tweetmsg + "\t" + usrName + "\t" + time.toString() +"</p>");
            Writer w = resp.getWriter();
            w.write(sb.toString());
        }
        else
        {
            Writer w = resp.getWriter();
            w.write(sb.toString());
        }
    }

    private boolean checkProperEntry(String message, String username)
    {
        if (message != null && username != null) return true;
        return false;
    }
    private void printWrongEntryError()
    {
        sb.append("<h1>Wrong Tweet format, please specify BOTH message and username</h1>");
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
                "    <h1>What other people think:</h1>\n");
    }

}
