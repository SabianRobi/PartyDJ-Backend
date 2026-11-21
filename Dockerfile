FROM eclipse-temurin:17-jre-jammy
VOLUME /tmp
COPY target/PartyDJ-Backend.jar PartyDJ-Backend.jar
ENTRYPOINT ["java","-jar","/PartyDJ-Backend.jar"]
