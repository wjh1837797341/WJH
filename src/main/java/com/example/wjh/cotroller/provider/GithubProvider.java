package com.example.wjh.cotroller.provider;

import com.alibaba.fastjson.JSON;
import com.dtflys.forest.config.ForestConfiguration;
import com.example.wjh.dto.AccessTokenDTO;
import com.example.wjh.dto.GithubUser;
import okhttp3.*;

import org.jetbrains.annotations.Nullable;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
public class GithubProvider{
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
//        OkHttpClient client = new OkHttpClient();
//        MediaType mediaType= MediaType.get("application/json; charset=utf-8");
//        RequestBody body=RequestBody.create(JSON.toJSONString(accessTokenDTO),mediaType);
//        Request request=new Request
//                .Builder()
//                .url("https://github.com/login/oauth/access_token")
//                .post(body)
//                .build();
//        try (Response response =client.newCall(request).execute();){
//            String s = response.body().string();
//            System.out.println(s);
//            return response.body().string();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;

// 实例化Forest配置对象
        ForestConfiguration configuration = ForestConfiguration.configuration();
        configuration.setBackendName("httpclient");

        // 通过Forest配置对象实例化Forest请求接口
        MyClient myClient = configuration.createInstance(MyClient.class);

        // 调用Forest请求接口，并获取响应返回结果
        String result = myClient.mypost(JSON.toJSONString(accessTokenDTO));
        System.out.println(result);
        return null;

    }


    public GithubUser getGithubUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+accessToken)
                .build();
        try  {
            Response response = client.newCall(request).execute();
            String s = response.body().string();
            GithubUser githubUser= (GithubUser) JSON.parseObject(s,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
