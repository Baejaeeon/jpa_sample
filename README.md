# jpa_sample
Sample Code for JPA

### 실행방법
1. 초기 데이터베이스가 설정이 되어 있지 않으므로 application.properties의 샘플 데이터베이스 정보 기입
```
사용할 데이터베이스 정보 기입
spring.datasource.platform=derby
spring.datasource.url=jdbc:derby://localhost:1527/sampleDB;create=true
spring.datasource.username=sample
spring.datasource.password=sample

spring.jpa.hibernate.ddl-auto 값을 true로 설정 (애플리케이션 기동 시 테이블 생성)

초기 테이블이 생성되면 none으로 설정
```
2. SampleApplication 기동

### CRUD 테스트 (City로 한정)
- City 목록 조회
[GET] /sample/api/city

- 특정 id 값의 city 조회
[GET] /sample/api/city/{id}

- city 생성
[POST] /sample/api/city
body
```
{
  "country": "UK",
  "map": "30.895112, -70.036366",
  "name": "LA",
  "state": "FL"
}
```

- 특정 id 값의 city 수정
[PUT] /sample/api/city/{id}

- 특정 id 값의 city 삭제
[DELETE] /sample/api/city/{id}
