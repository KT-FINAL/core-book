# Book Service

## 개요

Book Service는 사용자가 책을 등록하고 삭제하며, 자신의 책 목록을 조회할 수 있는 RESTful API를 제공합니다. 이 서비스는 Spring Boot를 기반으로 하며, JWT를 사용하여 사용자 인증을 처리합니다.

## 주요 기능

- **책 등록**: 사용자는 JWT 토큰을 통해 인증된 후, 책을 등록할 수 있습니다.
- **책 삭제**: 사용자는 자신이 등록한 책을 삭제할 수 있습니다.
- **책 조회**: 사용자는 자신의 책 목록을 조회할 수 있습니다.

## 기술 스택

- **Java 11**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **JWT (JSON Web Token)**

## 설정 방법

1. **프로젝트 클론**

   ```bash
   git clone https://github.com/your-repo/book-service.git
   cd book-service
   ```

2. **데이터베이스 설정**

   PostgreSQL 데이터베이스를 설정하고, `application.properties` 파일에 데이터베이스 연결 정보를 입력합니다.

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   ```

3. **빌드 및 실행**

   Maven을 사용하여 프로젝트를 빌드하고 실행합니다.

   ```bash
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

## API 사용법

### 책 등록

- **Endpoint**: `/api/books/register`
- **Method**: `POST`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`
- **Body**: 
  ```json
  {
    "title": "Book Title",
    "author": "Author Name",
    "allBook": {
      "id": 1
    }
  }
  ```

### 책 삭제

- **Endpoint**: `/api/books/{id}`
- **Method**: `DELETE`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`

### 책 조회

- **Endpoint**: `/api/books/user`
- **Method**: `GET`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`

## 기여 방법

1. 이 저장소를 포크합니다.
2. 새로운 브랜치를 생성합니다. (`git checkout -b feature/your-feature`)
3. 변경 사항을 커밋합니다. (`git commit -m 'Add some feature'`)
4. 브랜치에 푸시합니다. (`git push origin feature/your-feature`)
5. Pull Request를 생성합니다.

## 라이센스

이 프로젝트는 MIT 라이센스를 따릅니다. 자세한 내용은 LICENSE 파일을 참조하세요.