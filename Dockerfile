FROM fedora

RUN dnf update -y && dnf install -y java-1.8.0-openjdk maven
RUN curl --silent --location https://rpm.nodesource.com/setup_8.x | bash - && dnf install -y nodejs

WORKDIR /opt/app

EXPOSE 8080

CMD cd ./frontend && npm install && \
    ./node_modules/.bin/ng build --output-path ../src/main/resources/static && \
    cd .. && mvn package && \
    java -jar target/EsportSchedule-0.0.1-SNAPSHOT.jar