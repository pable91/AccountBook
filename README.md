# payhere

# 1️⃣ 기술 스택
    - SpringBoot
    - JPA
    - MySQL
    - java 11
    - Spring Security + JWT

# 2️⃣ API
### 회원가입[POST]
    http://localhost:8080/user/signup
    
    {
        "email" : "kim@naver.com",
        "nickname" : "kim",
        "password" : "1234566"
    }

### 로그인[POST]
    http://localhost:8080/user/login
    
    {
      "email" : "kim@naver.com",
      "password" : "123456"
    }

### 로그아웃[POST]
    http://localhost:8080/user/logout

### 가계부 내역 등록[POST]
    http://localhost:8080/account/events

    {
      "email" : "kim@naver.com",
      "action" : "ADD",
      "money" : "100",
      "content" : "test content"
    }
### 가계부 내역 수정[POST]
    http://localhost:8080/account/events

    {
      "email" : "kim@naver.com",
      "action" : "MODIFY",
      "accountId" : "1",
      "money" : "500",
      "content" : "modify ok"
    }
### 가계부 내역 삭제[POST]
    http://localhost:8080/account/events
    
    {
      "email" : "kim@naver.com",
      "action" : "DELETE",
      "accountId" : "1"
    }
### 가계부 내역 되돌리기[POST]
    http://localhost:8080/account/events

    {
      "email" : "kim@naver.com",
      "action" : "RESTORE",
      "accountId" : "1"
    }
### 가계부 내역 전체 보기[GET]
    http://localhost:8080/account/find

### 가계부 내역 단건 보기[GET]
    http://localhost:8080/account/find/{email}
