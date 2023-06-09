package Utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.regex.Pattern;

public class Misc
{
    static HashMap<String, Boolean>ids=new HashMap<>();
    public static String generate_pass()
    {
        StringBuilder s= new StringBuilder();
        char a,b,x,m;
        int i=10,y;
        while(i>0)
        {
            a=(char)(((int)(Math.random()*1000))%25+65);
            b=(char)(((int)(Math.random()*1000))%25+97);
            x=(char)(((int)(Math.random()*1000))%10+48);
            m=(char)(((int)(Math.random()*1000))%48+33);
            y=(int)(Math.random()*1000)%4;
            s.append((y == 0) ? a : (y == 1) ? b : (y==2) ? x:m);
            --i;
        }
        return s.toString();
    }

    public static String generate_pin()
    {
        StringBuilder s= new StringBuilder();
        char a;
        int i=5;
        while(i>0)
        {
            a=(char)(((int)(Math.random()*1000))%10+48);
            s.append(a);
            --i;
        }
        return s.toString();
    }

    public static String generate_id(String type)
    {
        StringBuilder id= new StringBuilder();
        id.append(type).append('_');
        char c;
        int i=4;
        while(i>0)
        {
            c=(char)(((int)(Math.random()*1000))%10+48);
            id.append(c);
            --i;
        }
        id.append('-');
        i=5;
        while(i>0)
        {
            c=(char)(((int)(Math.random()*1000))%10+48);
            id.append(c);
            --i;
        }

        String ans=id.toString();

        if(ids.get(id.toString())!=null)
        {
            ans=generate_id(type);
        }

        ids.put(ans,true);
        return ans;
    }

    public static boolean email_validation(String s)
    {
        String email_regular_expression="^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern=Pattern.compile(email_regular_expression);
        if(s==null) return false;
        return pattern.matcher(s).matches();
    }

    public static String get_current_time()
    {
        LocalDateTime date_time=LocalDateTime.now();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return formatter.format(date_time);
    }
}
