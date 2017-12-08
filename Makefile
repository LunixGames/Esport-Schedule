all: build-docker build-server build-ui

server:
	docker run --rm -v "${CURDIR}":/opt/app -p 8080:8080 es-app

build-ui:
	 docker run --rm -it -v "${CURDIR}":/opt/app -w /opt/app/frontend es-app /bin/bash \
	 -c "npm install; ./node_modules/.bin/ng build --output-path ../src/main/resources/static/frontend"

build-api:
	docker run --rm -it -v "${CURDIR}":/opt/app -w /opt/app es-app mvn package

build-docker:
	docker build . -t es-app

docker-stop:
	docker stop $(shell docker ps -q)