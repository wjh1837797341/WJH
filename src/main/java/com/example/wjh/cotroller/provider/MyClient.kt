package com.example.wjh.cotroller.provider

import com.dtflys.forest.annotation.Body
import com.dtflys.forest.annotation.Post
import com.dtflys.forest.annotation.Request
import com.example.wjh.dto.AccessTokenDTO


interface MyClient {
    @Post(url = "https://github.com/login/oauth/access_token", contentType = "application/json")
    fun mypost(@Body s:String?): String?

    @Request(url = "https://github.com/login/oauth/access_token", dataType = "text")
    fun getData(): String?
}