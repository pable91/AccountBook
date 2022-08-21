# payhere

# 1️⃣ 기술 스택
    - SpringBoot
    - JPA
    - MySQL
    - java 11
    - Spring Security + JWT

# 2️⃣ API 요청 및 응답
### 회원가입[POST]
    http://localhost:8080/user/signup
    
    {
        "email" : "kim@naver.com",
        "nickname" : "kim",
        "password" : "1234566"
    }

---
    
    {
    	"result": "Success",
    	"type": "회원가입 완료",
    	"data": {
        	"id": 1,
        	"email": "kim@naver.com",
        	"password": "$2a$10$6o2wB8WKAFJdccqWBZUDZ.uUknPljnHe9XIqOPsG9Yuz44gGdBTP."
    	}
    }
### 로그인[POST]
    http://localhost:8080/user/login
    
    {
      "email" : "kim@naver.com",
      "password" : "123456"
    }
    
---
    
     {
    	"result": "Success",
    	"type": "로그인 완료",
    	"data": "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhY2Nlc3NfdG9rZW4iLCJpYXQiOjE2NjEwOTM0MjgsImV4cCI6MTY2MTA5MzUxNSwiZW1haWwiOiJiIn0.Mim4DlhnC8MkHGfpWrmW3vMx7eqGz6jN8emDNTb3AEs"
    }

### 로그아웃[POST]
    http://localhost:8080/user/logout

---

    {
    	"result": "Success",
    	"type": "로그아웃 완료",
    	"data": ""
    }
    
### 가계부 내역 등록[POST]
    http://localhost:8080/account/events

    {
      "email" : "kim@naver.com",
      "action" : "ADD",
      "money" : "100",
      "content" : "test content"
    }
    
---
    
    {
    	"result": "Success",
    	"type": "요청한 가계부 등록이 성공하였습니다",
    	"data": {
        		"email": "kim@naver.com",
        		"money": 100,
        		"content": "test content"
    	}
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
    
---

	{
    	"result": "Success",
    	"type": "요청한 가계부 수정을 성공하였습니다",
    	"data": {
        		"email": "kim@naver.com",
        		"accountId": 1,
        		"money": 500,
        		"content": "modify ok"
    	}
	}

### 가계부 내역 삭제[POST]
    http://localhost:8080/account/events
    
    {
      "email" : "kim@naver.com",
      "action" : "DELETE",
      "accountId" : "1"
    }

---
	{
    	"result": "Success",
    	"type": "요청한 가계부 삭제가 성공하였습니다",
    	"data": {
	        	"email": "kim@naver.com",
        		"accountId": 1
    	}
	}
	
### 가계부 내역 되돌리기[POST]
    http://localhost:8080/account/events

    {
      "email" : "kim@naver.com",
      "action" : "RESTORE",
      "accountId" : "1"
    }
    
---
    
    {
    	"result": "Success",
    	"type": "요청한 가계부를 복구 성공하였습니다",
    	"data": {
        		"email": "kim@naver.com",
        		"accountId": 1
    	}
    }
    
### 가계부 내역 전체 보기[GET]
    http://localhost:8080/account/find
    
---
	
	{
	    "result": "Success",
	    "type": "find all account",
	    "data": [
	        {
	            "createdDate": "2022-08-22T00:18:40",
	            "modifiedDate": "2022-08-22T00:21:55",
	            "id": 1,
	            "email": "kim@naver.com",
	            "money": 100,
	            "content": "test content",
	            "active": true
	        },
	        {
	            "createdDate": "2022-08-22T00:24:28",
	            "modifiedDate": "2022-08-22T00:24:28",
	            "id": 2,
	            "email": "you@naver.com",
	            "money": 20000,
	            "content": "test content",
	            "active": true
	        },
	        {
	            "createdDate": "2022-08-22T00:24:47",
	            "modifiedDate": "2022-08-22T00:24:47",
	            "id": 3,
	            "email": "tea@naver.com",
	            "money": 20000,
	            "content": "test content",
	            "active": true
	        }
	    ]
	}

### 가계부 내역 단건 보기[GET]
    http://localhost:8080/account/find/{email}
    
---
	{
	    "result": "Success",
	    "type": "find account",
	    "data": {
	        "createdDate": "2022-08-22T00:18:40",
	        "modifiedDate": "2022-08-22T00:21:55",
	        "id": 1,
	        "email": "kim@naver.com",
	        "money": 100,
	        "content": "test content",
	        "active": true
	    }
	}

# 3️⃣ DDL
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


