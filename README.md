# Spring Clean Architecture Lab

본 저장소는 엔터프라이즈 환경에서의 유지보수성과 확장성을 고려한 **백엔드 아키텍처 설계의 모범 사례**를 보여주기 위한 연구소입니다.

## 🏗 아키텍처: Clean Architecture (Hexagonal)

의존성 규칙(Dependency Rule)을 준수하여, 비즈니스 로직(Domain)이 외부 프레임워크(Spring, JPA)나 UI에 의존하지 않도록 설계되었습니다.

### Layer 구조
- **Domain**: 순수 Java 코드로 작성된 엔티티 및 비즈니스 규칙.
- **Application**: 유즈케이스(Use Case) 및 포트(Port) 정의.
- **Infrastructure**: 외부 라이브러리(JPA, Redis)의 구현체(Adapter).
- **Presentation**: REST API 컨트롤러.

## 🛠 Tech Stack
- **Framework**: Spring Boot 3.2.5 (Java 17)
- **Persistence**: Spring Data JPA + H2 (Embedded)
- **DevOps**: Docker, GitHub Actions
- **Testing**: JUnit5, AssertJ, Mockito (TDD 지향)

## 📖 Tech Wiki / ADR (Architecture Decision Records)

### 1. 왜 클린 아키텍처인가?
시니어 개발자로서 시스템의 수명 주기를 고려할 때, 특정 기술(프레임워크, DB)에 대한 결합도를 낮추는 것이 가장 중요하다고 판단했습니다. 이 구조를 통해 추후 DB를 MongoDB로 바꾸거나, 외부 API 연동 방식이 변경되어도 비즈니스 핵심 로직은 전혀 수정할 필요가 없습니다.

### 2. DTO vs Domain Entity 분리
Presentation 레이어의 DTO와 Domain 레이어의 Entity를 엄격히 분리합니다. 이는 API 스펙 변경이 비즈니스 로직에 영향을 주지 않도록 하기 위함입니다.

## 🚀 DevOps & CI/CD
- **Docker**: `Dockerfile`을 통해 멀티 스테이지 빌드를 적용하여 실행 이미지를 최소화했습니다.
- **GitHub Actions**: 모든 Push 발생 시 `./gradlew test`를 수행하여 코드의 안정성을 자동 검증합니다.
