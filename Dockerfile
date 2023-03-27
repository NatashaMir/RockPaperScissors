FROM eclipse-temurin:17-jdk-jammy as base
COPY /build/libs/rock-paper-scissors.jar rock-paper-scissors.jar
EXPOSE 8082
CMD java $JAVA_OPTIONS -jar -Dspring.profiles.active=$SPRING_PROFILE rock-paper-scissors.jar
