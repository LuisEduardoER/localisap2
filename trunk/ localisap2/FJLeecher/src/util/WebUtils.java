/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author Felipe
 */
public class WebUtils {
    private int timeout;
    private URLConnection conn;
    private static CookieManager cookieManager = new CookieManager();
    URL myUrl;
    
    public WebUtils(int timeout) {
        this.timeout = timeout;
    }
    
    public boolean login(String url,String postdata, String success) throws Exception{
        myUrl = new URL(url);
        
        conn = myUrl.openConnection();
        conn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
        wr.write(postdata);
        wr.flush();

        BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String line= pipe(conn.getInputStream(),"ISO-8859-1");

        cookieManager.storeCookies(conn);
        wr.close();
        rd.close();
        if(line.contains(success))
            return true;
        return false;
        
    }
    
    public String downloadPage(String url) throws Exception{
        try{
            myUrl = new URL(url);
            conn = myUrl.openConnection();
            cookieManager.setCookies(conn);
            conn.connect();
            conn.setConnectTimeout(timeout);
            String line= pipe(conn.getInputStream(),"ISO-8859-1");
            return line;
        } catch (Exception e) {
            throw e;
        } 
    }
    
    public String pipe(InputStream in,String charset) throws IOException {
        StringBuilder s = new StringBuilder();
        if(charset==null||"".equals(charset)){
            charset="utf-8";
        }
        String rLine = null;
        BufferedReader bReader = new BufferedReader(new InputStreamReader(in,charset));
        while ( (rLine = bReader.readLine()) != null) {
            String tmp_rLine = rLine;
            int str_len = tmp_rLine.length();
            if (str_len > 0) {
              s.append(tmp_rLine);
            }
            tmp_rLine = null;
        }
        in.close();
        return s.toString();
    }
    
}
