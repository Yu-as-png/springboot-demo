package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.EchoRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 三个示例接口：
 * 1. GET  /api/hello?name=xxx  打招呼
 * 2. GET  /api/time            服务器当前时间
 * 3. POST /api/echo            回显请求体
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    /**
     * 接口一：打招呼。
     * 示例：GET /api/hello?name=WorkBuddy
     */
    @GetMapping("/hello")
    public ApiResponse<Map<String, Object>> hello(
            @RequestParam(name = "name", defaultValue = "World") String name) {

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("message", "Hello, " + name + "!");
        data.put("length", name.length());

        return ApiResponse.ok(data);
    }

    /**
     * 接口二：服务器当前时间。
     * 示例：GET /api/time
     */
    @GetMapping("/time")
    public ApiResponse<Map<String, Object>> time() {
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("iso", now.toString());
        data.put("localDateTime", now.toLocalDateTime().toString());
        data.put("epochMillis", now.toInstant().toEpochMilli());
        data.put("zone", now.getZone().getId());

        return ApiResponse.ok(data);
    }

    /**
     * 接口三：回显请求体。
     * 示例：POST /api/echo  {"content":"hello"}
     */
    @PostMapping("/echo")
    public ResponseEntity<ApiResponse<Map<String, Object>>> echo(@RequestBody(required = false) EchoRequest request) {
        EchoRequest body = request == null ? new EchoRequest() : request;

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("content", body.getContent());
        data.put("receivedAt", LocalDateTime.now().toString());

        return ResponseEntity.ok(ApiResponse.ok(data));
    }
}
