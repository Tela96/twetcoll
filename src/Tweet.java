/**
 * Created by akos on 2017.05.05..
 */
public class Tweet
{
    private String msg, usrName, timeStamp;

    public Tweet(String msg, String usrName, String timeStamp)
    {
        this.msg = msg;
        this.usrName = usrName;
        this.timeStamp = timeStamp;
    }

    public String getMsg()
    {
        return msg;
    }

    public String getUsrName()
    {
        return usrName;
    }

    public String getTimeStamp()
    {
        return timeStamp;
    }
}
