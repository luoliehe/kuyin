package com.llh.musciapp.common.util;

import android.util.Log;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.params.BasicHttpParams;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 火狐浏览器客户端
 * @author llh
 *
 */
public class FirefoxClient {

    private static final String TAG = "FirefoxClient";
    private static HttpClient client = new DefaultHttpClient();

    FirefoxClient(){}

    /**
     * 获得请求头数组
     * @return 返回请求头数组
     */
    private static Header[] getHeaders(){
        List<Header> list = new ArrayList<>();
        //模拟firfox
        list.add(new BasicHeader("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0"));
        list.add(new BasicHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8"));
        list.add(new BasicHeader("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3"));
        list.add(new BasicHeader("Accept-Encoding","gzip, deflate"));
        list.add(new BasicHeader("Cookie","gzip, deflate"));
        list.add(new BasicHeader("Referer",""));
        list.add(new BasicHeader("Connection","keep-alive"));
        Header[] headers = new Header[list.size()];
        headers = list.toArray(headers);
        return headers;
    }

    /**
     * 设置参数
     * @param request {@link org.apache.http.HttpRequest}
     * @param params {@link java.util.Map}
     */
    private static void setParams(HttpRequest request, Map<String, Object> params){
        if(request==null || params == null){
            return;
        }
        for(Map.Entry<String, Object> p : params.entrySet()){
            request.setParams(new BasicHttpParams().setParameter(p.getKey(), p.getValue()));
        }
    }

    /**
     * post 方法请求
     * @param url 请求url
     * @param params 请求参数
     * @return {@link java.io.InputStream}
     * @throws IOException
     */
    public static InputStream post(String url, Map<String, Object> params) throws IOException {
        HttpPost post = new HttpPost(url);
        //设置请求头
        post.setHeaders(getHeaders());
        //设置参数
        setParams(post, params);
        //执行请求
        HttpResponse response = client.execute(post);
        if(response.getStatusLine().getStatusCode()==HttpStatus.SC_OK){
            return response.getEntity().getContent();
        }
        return null;
    }

    /**
     * get方式请求
     * @param url 请求url
     * @param params 请求参数
     * @return {@link java.io.InputStream}
     * @throws IOException
     */
    public static InputStream get(String url, Map<String, Object> params) throws IOException {
        HttpGet httpGet = new HttpGet(url);
        //设置请求头
        httpGet.setHeaders(getHeaders());
        //设置参数
        setParams(httpGet, params);
        HttpResponse response = client.execute(httpGet);
        Log.i(TAG, response.getStatusLine().toString());
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            HttpEntity entity = response.getEntity();
            return entity.getContent();
        }
        return null;
    }

    /**
     * 请求一个文件
     * @param url 请求url
     * @param params 请求参数，可以为null
     * @param file {@link java.io.File}
     * @return 返回文件对象
     */
    public static File getFile(String url,Map<String, Object> params, File file){
        FileOutputStream out = null;
        try {
            InputStream in = get(url, params);
            //4KB的缓冲
            byte[] buff = new byte[1024*4];
            out = new FileOutputStream(file);
            do {
                int c = in.read(buff);
                if(c<0){
                    break;
                }
                out.write(buff, 0, c);
            }while(true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out!=null){
                try {
                    out.close();
                } catch (IOException e) {
                    Log.e(TAG, "关闭流出错"+ e.getMessage());
                }
            }
        }
        return file;
    }

}