package com.example.administrator.mydemo.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetUilts {
    /*
     * 用post方式登录
     * @param username
     * @param password
     * @return 登录状态
     * */
    public static String loginofPost(String username, String password) {
        HttpURLConnection conn = null;
        String s = null;
        try {
            URL url = new URL("http://47.98.127.30:8080/Test/Servers");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");//设置请求方式
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setConnectTimeout(10000);//设置连接超时时间
            conn.setReadTimeout(5000);//设置读取超时时间
            s = "type1";
            s=s.concat("3");
            //POST请求的参数
            OutputStream out = conn.getOutputStream();//获得输出流对象，用于向服务器写数据
            s=s.concat("2");
            String data = "username=" + username + "&" + "password=" + password;
            s.concat("2");
            out.write(data.getBytes());//向服务器写数据;
            s.concat("2");
            out.flush();
            out.close();//关闭输出流
            conn.connect();//开始连接
            int responseCode = conn.getResponseCode();//获取响应吗
            s = String.valueOf(responseCode);
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                //访问成功
                InputStream is = conn.getInputStream();//得到InputStream输入流
                String state = getstateFromInputstream(is);
                return state;
            } else {
                //访问失败

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {//如果conn不等于空，则关闭连接
                conn.disconnect();
            }
        }
        return s;

    }

    /*
     * 使用GET的方式登录
     * @param username
     * @param password
     * @return 登录状态
     * */
 /*   public static String loginOfGet(String username,String password){
        HttpURLConnection conn=null;
        try {
            String data="username="+username+"&"+"password="+password;
            URL url=new URL("http://192.168.1.55:8080/SimpleAndroidServerDemo/Servers?"+data);
            conn=(HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");//设置请求方式
            conn.setConnectTimeout(10000);//设置连接超时时间
            conn.setReadTimeout(5000);//设置读取超时时间
            conn.connect();//开始连接
            int responseCode=conn.getResponseCode();//获取响应吗
            if(responseCode==200){
                //访问成功
                InputStream is=conn.getInputStream();//得到InputStream输入流
                String state=getstateFromInputstream(is);
                Logger.i("请求结果："+state);
                return state;
            }else{
                //访问失败
                Logger.i("访问失败！");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.i("访问异常！");
        }finally{
            if(conn!=null){//如果conn不等于空，则关闭连接
                conn.disconnect();
            }
        }
        return null;

    }
*/
    private static String getstateFromInputstream(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();//定义一个缓存流
        byte[] buffer = new byte[1024];//定义一个数组，用于读取is
        int len = -1;
        while ((len = is.read(buffer)) != -1) {//将字节写入缓存
            baos.write(buffer, 0, len);
        }
        is.close();//关闭输入流
        String state = baos.toString();//将缓存流中的数据转换成字符串
        baos.close();
        return state;
    }
}