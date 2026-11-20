FROM eclipse-temurin:17-jre-jammy
VOLUME /tmp
COPY target/partydj.jar partydj.jar
ENTRYPOINT ["java","-jar","/partydj.jar"]