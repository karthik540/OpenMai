package org.openmai.endpoint;
import org.json.JSONObject;
import java.util.*;
import java.io.IOException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

public class RequestFormat 
{
    public Map<String, String> header;
    public Cookie[] cookies;
    public JSONObject body;

    public RequestFormat(HttpServletRequest request) {


        //      Headers Extraction...

        Enumeration<String> headerNames = request.getHeaderNames();
        String headerName , headerContent;
        Map<String, String> header = new HashMap<String , String>();
        if (headerNames != null) {
                while (headerNames.hasMoreElements()) 
                {
                    headerName = headerNames.nextElement();
                    headerContent = request.getHeader(headerName);
                    //System.out.println(headerName + " : " + headerContent);
                    header.put(headerName, headerContent);
                }
        }

        //  Cookies Extraction...
        Cookie[] cookies = request.getCookies();
        if(cookies!=null) {
            //System.out.println("Cookies:");
            for (Cookie cookie : cookies) {
                //System.out.println(cookie);
            }
        }
        


        //  Body Json extraction...
        if ("POST".equalsIgnoreCase(request.getMethod())) 
        {
            try {
                String jsonString = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
                //System.out.println("Body:");
                //System.out.println(jsonString);
                JSONObject jsonBody= new JSONObject(jsonString);
                this.body = jsonBody;
                //System.out.println(jsonObject.getString("email"));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                System.out.println("IO exception Found !");
                e.printStackTrace();
            }
        }

        this.header = header;
        this.cookies = cookies;
    }

    public Map<String, String> getHeader() {
        return this.header;   
    }
    public void setHeader(Map<String, String> header) {
        this.header = header;   
    }

    public Cookie[] getCookies() {
        return this.cookies;   
    }
    public void setCookies(Cookie[] cookies) {
        this.cookies = cookies;   
    }

    public JSONObject getBody() {
        return this.body;   
    }
    public void setBody(JSONObject body) {
        this.body = body;   
    }
}
