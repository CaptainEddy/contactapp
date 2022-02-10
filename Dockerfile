FROM adoptopenjdk/openjdk11:alpine-jre

COPY .target/1001_2021_12_07_Mini_Project_01-0.0.1-SNAPSHOT.jar /usr/app

WORKDIR /usr/app

RUN sh -c 'touch 1001_2021_12_07_Mini_Project_01-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java", "-jar", "1001_2021_12_07_Mini_Project_01-0.0.1-SNAPSHOT.jar"]