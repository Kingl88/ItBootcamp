# **_Тестовое задание_**


В проекте были использованы следующие технологии:
- Spring framework (Spring Boot v3.1.2) - основной фреймворк использующийся в проекте;
- MySql8 - в качестве основной базы данных для хранения информации;
- H2 - в качестве тестовой базы данных для хранения информации;
- Flyway - для поддержания целостности базы данных и контролем изменений;
- Maven - в качестве сборщика проектов;
- Log4j2 как система логирования;
- Docker и Docker Compose для контейнеризации проекта;
- Swagger - используется для создания интерактивной документации.

### **_Запуск проекта._**

**Требования для работы проекта:**

- Docker;
- Java 17 или выше;
- Git;

**Порядок действий:**

- git clone https://github.com/Kingl88/ItBootcamp.git;
- cd ItBootcamp;
- .\mvnw.cmd clean package;
- java -jar REST-module\target\REST-module-1.0-SNAPSHOT.jar.

После запуска сервиса при переходе по ссылке http://localhost:8089/swagger-ui/index.html можно ознакомиться с документацией сконфигурированной **_Swagger_**.
