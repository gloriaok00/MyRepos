package com.example.demo.pingshi.http;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;


public class HttpUtil {

    private static Logger log = LoggerFactory.getLogger(HttpUtil.class);

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * 实现发送https的get请求
     *
     * @param baseUrl    发送地址
     * @param headers    传入header的map, 例如cookies等，当无值时，传入null即可
     * @param parameters 传入参数的map;当无参数时，传入的map=null即可
     */
    public static String httpsget(String baseUrl, Map<String, String> parameters, Map<String, String> headers) {

        //创建一个返回值对象
        CloseableHttpResponse response = null;
        String entityString = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(baseUrl);
            //创建一个httpclient对象
            CloseableHttpClient httpClient = HttpUtil.createSSLClientDefault();
            if (parameters != null && parameters.size() > 0) {
                for (Map.Entry<String, String> temp : parameters.entrySet()) {
                    //循环map里面的每一对键值对，然后获取key和value即时想要的参数的 key和value
                    uriBuilder.addParameter(temp.getKey(), temp.getValue());
                }
            }
            //产生一个httpget连接
            HttpGet get = new HttpGet(uriBuilder.build());
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> temp : headers.entrySet()) {
                    get.setHeader(temp.getKey(), temp.getValue());
                }
            }
            //执行请求
            response = httpClient.execute(get);
            //取响应的结果
            HttpEntity entity = response.getEntity();
            entityString = EntityUtils.toString(entity, "utf-8");
        } catch (URISyntaxException | IOException e) {
            log.error("httpsget方法异常:", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("httpsget方法异常:", e);
            }
        }
        return entityString;
    }

    /**
     * 实现发送http的get请求
     *
     * @param baseUrl    发送地址
     * @param headers    传入header的map, 例如cookies等，当无值时，传入null即可
     * @param parameters 传入参数的map;当无参数时，传入的map=null即可
     */
    public static String httpget(String baseUrl, Map<String, String> parameters, Map<String, String> headers) {

        //创建一个返回值对象
        CloseableHttpResponse response = null;
        String entityString = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(baseUrl);
            //创建一个httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            if (parameters != null && parameters.size() > 0) {
                for (Map.Entry<String, String> temp : parameters.entrySet()) {
                    //循环map里面的每一对键值对，然后获取key和value即时想要的参数的 key和value
                    uriBuilder.addParameter(temp.getKey(), temp.getValue());
                }
            }
            //产生一个httpget连接
            HttpGet get = new HttpGet(uriBuilder.build());
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> temp : headers.entrySet()) {
                    get.setHeader(temp.getKey(), temp.getValue());
                }
            }
            //执行请求
            response = httpClient.execute(get);
            //取响应的结果
            HttpEntity entity = response.getEntity();
            entityString = EntityUtils.toString(entity, "utf-8");
        } catch (URISyntaxException | IOException e) {
            log.error("httpget方法异常:", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("httpget方法异常:", e);
            }
        }
        return entityString;
    }

    /**
     * 实现发送http的get请求
     *
     * @param baseUrl    发送地址
     * @param headers    传入header的map, 例如cookies等，当无值时，传入null即可
     * @param parameters 传入参数的map;当无参数时，传入的map=null即可
     * @return response
     */
    public static CloseableHttpResponse httpgetResponse(String baseUrl, Map<String, String> parameters, Map<String, String> headers) {

        //创建一个返回值对象
        CloseableHttpResponse response = null;
        String entityString = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(baseUrl);
            //创建一个httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            if (parameters != null && parameters.size() > 0) {
                for (Map.Entry<String, String> temp : parameters.entrySet()) {
                    //循环map里面的每一对键值对，然后获取key和value即时想要的参数的 key和value
                    uriBuilder.addParameter(temp.getKey(), temp.getValue());
                }
            }
            //产生一个httpget连接
            HttpGet get = new HttpGet(uriBuilder.build());
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> temp : headers.entrySet()) {
                    get.setHeader(temp.getKey(), temp.getValue());
                }
            }
            //执行请求
            response = httpClient.execute(get);
            return response;
        } catch (URISyntaxException | IOException e) {
            log.error("httpget方法异常:", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("httpget方法异常:", e);
            }
        }
        return response;
    }

    /**
     * 实现发送http的post请求
     *
     * @param baseUrl    发送地址
     * @param headers    传入header的map, 例如cookies等，当无值时，传入null即可
     * @param parameters 传入参数的map;当无参数时，传入的map=null即可
     */
    public static String httpPost(String baseUrl, String parameters, Map<String, String> headers) {

        //创建一个返回值对象
        CloseableHttpResponse response = null;
        String entityString = null;
        try {
            URIBuilder uriBuilder = new URIBuilder(baseUrl);
            //创建一个httpclient对象
            CloseableHttpClient httpClient = HttpClients.createDefault();
            //产生一个httpPost连接
            HttpPost post = new HttpPost(uriBuilder.build());
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> temp : headers.entrySet()) {
                    post.setHeader(temp.getKey(), temp.getValue());
                }
            }
            StringEntity myEntity = new StringEntity(parameters);
            post.setEntity(myEntity);
            //执行请求
            response = httpClient.execute(post);
            //取响应的结果
            HttpEntity entity = response.getEntity();
            entityString = EntityUtils.toString(entity, "utf-8");
        } catch (URISyntaxException | IOException e) {
            log.error("httpPost方法异常:", e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error("httpPost方法异常:", e);
            }
        }
        return entityString;
    }

    /**
     * 实现发送http的delete请求
     *
     * @param url     发送地址
     * @param param   传入参数的map;当无参数时，传入的map=null即可
     * @param headers 传入header的map, 例如cookies等，当无值时，传入null即可
     */
    public static String httpDelete(String url, Map<String, String> param, Map<String, String> headers) {
        // 创建Httpclient对象
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建Http Delete请求
            HttpDelete httpDelete = new HttpDelete(uri);
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> temp : headers.entrySet()) {
                    httpDelete.setHeader(temp.getKey(), temp.getValue());
                }
            }
            // 执行http请求
            response = httpClient.execute(httpDelete);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return resultString;
    }

    /**
     * 实现发送https的delete请求
     *
     * @param url     发送地址
     * @param param   传入参数的map;当无参数时，传入的map=null即可
     * @param headers 传入header的map, 例如cookies等，当无值时，传入null即可
     */
    public static String httpsDelete(String url, Map<String, String> param, Map<String, String> headers) {
        // 创建Httpclient对象
        CloseableHttpResponse response = null;
        String resultString = "";
        try {
            CloseableHttpClient httpClient = HttpUtil.createSSLClientDefault();
            // 创建uri
            URIBuilder builder = new URIBuilder(url);
            if (param != null) {
                for (String key : param.keySet()) {
                    builder.addParameter(key, param.get(key));
                }
            }
            URI uri = builder.build();
            // 创建Http Delete请求
            HttpDelete httpDelete = new HttpDelete(uri);
            if (headers != null && headers.size() > 0) {
                for (Map.Entry<String, String> temp : headers.entrySet()) {
                    httpDelete.setHeader(temp.getKey(), temp.getValue());
                }
            }
            // 执行http请求
            response = httpClient.execute(httpDelete);
            resultString = EntityUtils.toString(response.getEntity(), "UTF-8");
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }

        return resultString;
    }

    /**
     * 发送http-post请求
     *
     * @param url         发送地址
     * @param requestJson 消息体
     * @param headers     传入header的map, 例如cookies等，当无值时，传入null即可
     */
    public static String httpPostJson(String url, Map<String, String> headers, String requestJson) {
        HttpPost httpPost = new HttpPost(url);
        //设置header
        if (headers != null) {
            for (String header : headers.keySet()) {
                httpPost.setHeader(header, headers.get(header));
            }
        }
        try {
            StringEntity stringEntity = new StringEntity(requestJson, Charset.forName("UTF-8"));
            stringEntity.setContentEncoding("UTF-8");
            httpPost.setEntity(stringEntity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        CloseableHttpClient hc = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = hc.execute(httpPost);
            HttpEntity entity = response.getEntity();
            return parseEntity(entity);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            try {
                if (hc != null) {
                    hc.close();
                }

                if (response != null) {
                    response.close();
                }

            } catch (Exception e2) {
                log.error(e2.getMessage(), e2);
            }
        }
        return null;
    }

    private static String parseEntity(HttpEntity entity) {
        StringBuffer out = new StringBuffer();
        try (InputStream is = entity.getContent()) {
            byte[] b = new byte[4096];
            for (int n; (n = is.read(b)) != -1; ) {
                out.append(new String(b, 0, n));
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return out.toString();
    }


    /**
     * SSL
     */
    private static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();
    }
}
