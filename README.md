# 스프링 클라우드 유레카 예제

## 실행 방법
**도커, 도커 컴포즈가 설치된 상태여야 합니다.**

### 시작하기

먼저 각 프로젝트의 루트로 이동해 ./gradlew build를 이용해 모두 빌드해주세요.

프로젝트를 클론한뒤 docker-compose.yml 이 존재하는 경로로 이동하세요.  

`docker-compose up -d`

위 명령어를 이용해 시작할 수 있습니다.

컨테이너가 띄워지면 멤버, 팀서비스의 데이터를 초기화해야됩니다.

http://localhost:8080/init, http://localhost:8081/init

각각 두개의 데이터가 저장됩니다.  
이제 http://localhost:8080/members/1 or http://localhost:8080/members/2 로 데이터를 확인할 수 있습니다. 



### 종료하기

`docker-compose down` 


