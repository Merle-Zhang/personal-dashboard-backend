# https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#container-images
# https://spring.io/guides/topicals/spring-boot-docker/
# https://medium.com/codex/write-production-ready-optimized-dockerfile-for-spring-boot-application-8fec0906a894

FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR application

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

RUN ./mvnw package -DskipTests

RUN java -Djarmode=layertools -jar target/*.jar extract


FROM eclipse-temurin:17-jre-alpine
VOLUME /tmp

COPY --from=build application/dependencies/ ./
COPY --from=build application/spring-boot-loader/ ./
COPY --from=build application/snapshot-dependencies/ ./
COPY --from=build application/application/ ./

RUN addgroup -S application && adduser -S application -G application
USER application

ENTRYPOINT ["java","org.springframework.boot.loader.JarLauncher"]
