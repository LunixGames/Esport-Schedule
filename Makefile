run:
	docker run -p 8080:8080 -v "${CURDIR}":/opt/app es-app
build:
	docker build . -t es-app