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

# 3️⃣ API 성공시 응답 JSON

# 4️⃣ DDL
### account(가계부 내역)
    create table payhere.account
    (
	    account_id bigint not null
	    	        primary key,
	    created_date datetime null,
	    modified_date datetime null,
	    active bit not null,
	    content varchar(255) null,
	    email varchar(255) null,
	    money int not null
    );
    
### User()
    create table payhere.user
    (
	    id bigint auto_increment
		        primary key,
	    email varchar(255) not null,
	    password varchar(255) not null,
	    constraint UK_ob8kqyqqgmefl0aco34akdtpe
		        unique (email)
    );


