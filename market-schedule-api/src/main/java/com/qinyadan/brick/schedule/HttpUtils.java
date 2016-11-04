package com.qinyadan.brick.schedule;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 
 * @author lsh
 *
 */
public class HttpUtils {
	public static final int DEFALT_TIMEOUT = 5000;
	
    
    /**
     * 
     * @param urlStr urlStr
     * @throws MalformedURLException MalformedURLException
     * @throws IOException IOException
     */
    public  static void doHttpGetNoReturn(String urlStr) throws MalformedURLException, IOException {
        URL url = new URL(urlStr);
        URLConnection c = url.openConnection();

        if (c instanceof HttpURLConnection) {
            HttpURLConnection httpConn = (HttpURLConnection) c;
            httpConn.setRequestMethod("GET");
            httpConn.setUseCaches(false);
            httpConn.setDoInput(true);
            httpConn.setConnectTimeout(HttpUtils.DEFALT_TIMEOUT);
            httpConn.setReadTimeout(HttpUtils.DEFALT_TIMEOUT);
            HttpURLConnection.setFollowRedirects(true);
          
        } else {
            throw new MalformedURLException("Only HTTP/HTTPs is valid.");
        }
    }
    /**
     * 
     * @param urlStr urlStr
     * @return String
     * @throws MalformedURLException MalformedURLException
     * @throws IOException IOException
     */
    public static String doHttpPost (String urlStr) throws MalformedURLException, IOException {
        URL url = new URL(urlStr);
        URLConnection c = url.openConnection();

        if (c instanceof HttpURLConnection) {
            HttpURLConnection httpConn = (HttpURLConnection) c;
            httpConn.setRequestMethod("POST");
            httpConn.setUseCaches(false);
            httpConn.setDoInput(true);
            HttpURLConnection.setFollowRedirects(true);
            httpConn.setConnectTimeout(HttpUtils.DEFALT_TIMEOUT * 20);
            httpConn.setReadTimeout(HttpUtils.DEFALT_TIMEOUT * 20);

            // get response.
            InputStream is = httpConn.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = rd.readLine()) != null) {
            	line = new String(line.getBytes(), "utf-8");
                response.append(line);
            }
            rd.close();

            httpConn.disconnect();

            return response.toString();
        } else {
            throw new MalformedURLException("Only HTTP/HTTPs is valid.");
        }
    }
    
}
