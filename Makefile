all: build-docker build-docker-compose build-api build-ui

up:
	docker-compose up

build-ui:
	 docker run --rm -it -v "${CURDIR}":/opt/app -w /opt/app/frontend es-app /bin/bash \
	 -c "npm install; ./node_modules/.bin/ng build --output-path ../src/main/resources/static/frontend"

build-api:
	docker run --rm -it -v "${CURDIR}":/opt/app -w /opt/app es-app mvn package

build-docker:
	docker build ./docker/backend -t es-app

build-docker-compose:
	docker-compose build

docker-stop:
	docker stop $(shell docker ps -q)