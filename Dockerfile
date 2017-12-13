FROM fedora:27

ADD . /opt/app

WORKDIR /opt/app

RUN dnf update -y && dnf install -y java-1.8.0-openjdk maven && \
    curl --silent --location https://rpm.nodesource.com/setup_8.x | bash - && \
    dnf install -y nodejs && \
    dnf clean all

RUN cd ./frontend && \
    npm install && ./node_modules/.bin/ng build -prod --output-path ../src/main/resources/static/frontend && \
    cd .. && \
    cp env.example src/main/resources/env.properties && \
    mvn package

EXPOSE 8080

CMD java -jar target/EsportSchedule-0.0.1-SNAPSHOT.jar