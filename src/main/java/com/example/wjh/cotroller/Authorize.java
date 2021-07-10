package com.example.wjh.cotroller;

import com.example.wjh.cotroller.provider.GithubProvider;
import com.example.wjh.dto.AccessTokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;


@Controller
public class Authorize {
    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code) {
        AccessTokenDTO accessTokenDTO=new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri("http://localhost:8080/callback");
        accessTokenDTO.setClient_id("5f523bc80e897e8065f7");
        accessTokenDTO.setClient_secret("01d9a2b90948c3f82ab556f2456e7bf8c94f41ba");
        githubProvider.getAccessToken(accessTokenDTO);
        return "index";
    }
}
