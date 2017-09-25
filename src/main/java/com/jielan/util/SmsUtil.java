package com.jielan.util;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wang on 2017/1/17.
 */
public class SmsUtil {
    private static final String MER_ID = "08939";
    private static final String KEY = "u2zvcge4b7ffqu7t";

    private static final String URL = "http://www.jsmms.com/messageSend.do";
    // private static final String URL = "http://115.236.91.116:9006/smms/messageSend.do";
    // private static final String URL = "http://192.168.18.142:8080/smms/messageSend.do";

    /**
     * 发送短信
     *
     * @param mobile
     * @param content
     * @return
     * @throws Exception
     */
    public static String sendSms( String mobile, String content ) {
        try {

            Map<String, String> param = new HashMap<String, String>();
            param.put( "merId", MER_ID );
            param.put( "mobile", mobile );
            param.put( "content", content );
            param.put( "rank", "" );
            param.put( "reservedTime", "" );
            param.put( "exCode", "123456" );
            param.put( "tranCode", "1001" );
            param.put( "sign", sign( param, KEY ) );
            param.put( "content", URLEncoder.encode( content, "utf-8" ) );
            String reqParams = mapParamsToUrl( param );
            // #请求网关
            System.out.println( "请求短信发送参数:" + reqParams );
            String reuslt = sendPost( URL, reqParams );
            System.out.println( "短信发送网关响应:" + reuslt );
            return reuslt;
        } catch ( Exception e ) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 短信发送网关签名工具
     *
     * @param param
     * @param secretKey
     * @return
     * @throws UnsupportedEncodingException
     * @throws NoSuchAlgorithmException
     */
    private static String sign( Map<String, String> param, String secretKey )
            throws NoSuchAlgorithmException, UnsupportedEncodingException {
        StringBuffer signStr = new StringBuffer();
        signStr.append( param.get("merId") )
                .append( param.get("mobile") )
                .append( param.get("content") )
                .append( param.get("rank") )
                .append( param.get("reservedTime") )
                .append( param.get("exCode") )
                .append( param.get( "tranCode" ) ).append( secretKey );
        return DigestUitl.MD5LowerCase( signStr.toString() );
    }

    /**
     * 发送post请求
     *
     * @param url
     * @param param
     * @return
     */
    public static String sendPost( String url, String param ) {
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuffer result = new StringBuffer();
        try {
            java.net.URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty( "accept", "*/*" );
            conn.setRequestProperty( "connection", "Keep-Alive" );
            conn.setRequestProperty( "user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)" );
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter( conn.getOutputStream() );
            out.print( param );
            out.flush();

            InputStream is = conn.getInputStream();
            byte[] b = new byte[1024];
            int len = -1;
            while ( ( len = is.read(b) ) != -1 ) {
                result.append( new String( b, 0, len, "utf-8" ) );
            }
            return result.toString();
        } catch ( Exception e ) {
            e.printStackTrace();
        } finally {
            try{
                if ( out != null ) out.close();
                if ( in != null ) in.close();
            } catch ( IOException ex ) {}
        }
        return "";
    }

    /**
     * 将参数Map转换为请求url
     *
     * @param params
     * @return
     */
    public static String mapParamsToUrl( Map<String, String> params ) {
        StringBuilder sb = new StringBuilder();
        for ( String s : params.keySet() ) {
            sb.append( s ).append( "=" ).append( params.get(s) ).append( "&" );
        }
        if ( params.size() > 1 )
            sb.delete( sb.length() - 1, sb.length() );
        return sb.toString();
    }

    public static void main(String[] args) {
        try {
            System.out.println( sendSms( "18806813221", "您的短信验证码：哈哈哈" ) );
        } catch ( Exception e ) {
            e.printStackTrace();
        }
    }
}
