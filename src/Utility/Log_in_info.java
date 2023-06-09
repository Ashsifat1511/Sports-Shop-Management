package Utility;

public class Log_in_info
{
    String log_in_time;
    String username;

    public Log_in_info(String log_in_time, String username) {
        this.log_in_time = log_in_time;
        this.username = username;
    }

    public String getLog_in_time() {
        return log_in_time;
    }

    public void setLog_in_time(String log_in_time) {
        this.log_in_time = log_in_time;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void display()
    {
        System.out.println("User: "+username);
        System.out.println("Log in time: "+log_in_time);
    }
}
