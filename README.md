# springboot-demo

一个基于 Spring Boot 3.3 + Java 17 的示例项目，内置三个 REST 接口，用于演示最小可运行的 Web 服务骨架。

## 技术栈

| 组件 | 版本 |
| --- | --- |
| JDK | 17 |
| Spring Boot | 3.3.5 |
| 构建工具 | Maven |
| 端口 | 8080 |

## 目录结构

```
springboot-demo
├── pom.xml
└── src
    ├── main
    │   ├── java/com/example/demo
    │   │   ├── DemoApplication.java          # 启动类
    │   │   ├── controller/DemoController.java # 三个接口
    │   │   └── dto                           # 请求/响应模型
    │   └── resources/application.properties
    └── test/java/com/example/demo
        └── DemoApplicationTests.java         # 接口单元测试
```

## 接口说明

| 方法 | 路径 | 说明 |
| --- | --- | --- |
| GET | `/api/hello` | 打招呼，支持 `name` 参数，默认 `World` |
| GET | `/api/time` | 返回服务器当前时间（Asia/Shanghai） |
| POST | `/api/echo` | 回显请求体中的 `content` 字段 |

### 1. GET /api/hello

```bash
curl "http://localhost:8080/api/hello?name=WorkBuddy"
```

```json
{
  "success": true,
  "message": "OK",
  "data": {
    "message": "Hello, WorkBuddy!",
    "length": 9
  }
}
```

### 2. GET /api/time

```bash
curl "http://localhost:8080/api/time"
```

```json
{
  "success": true,
  "message": "OK",
  "data": {
    "iso": "2026-11-17T16:20:00+08:00[Asia/Shanghai]",
    "localDateTime": "2026-11-17T16:20:00",
    "epochMillis": 1763367600000,
    "zone": "Asia/Shanghai"
  }
}
```

### 3. POST /api/echo

```bash
curl -X POST "http://localhost:8080/api/echo" \
  -H "Content-Type: application/json" \
  -d '{"content":"hello"}'
```

```json
{
  "success": true,
  "message": "OK",
  "data": {
    "content": "hello",
    "receivedAt": "2026-11-17T16:20:00"
  }
}
```

## 运行方式

```bash
# 启动服务
mvn spring-boot:run

# 或先打包再运行
mvn clean package
java -jar target/springboot-demo-0.0.1-SNAPSHOT.jar

# 执行测试
mvn test
```
