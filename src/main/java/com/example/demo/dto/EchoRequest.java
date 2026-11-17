package com.example.demo.dto;

/**
 * 回显接口的请求体。
 */
public class EchoRequest {

    private String content;

    public EchoRequest() {
    }

    public EchoRequest(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
