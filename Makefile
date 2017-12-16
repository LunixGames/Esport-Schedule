
IMAGE_NAME = esport-centos7
CONTAINER_NAME = esport-app

.PHONY: build
build: build-docker build-s2i

build-docker:
	docker build -t $(IMAGE_NAME) .

build-s2i:
	s2i build . $(IMAGE_NAME) $(CONTAINER_NAME)

.PHONY: test
test:
	docker build -t $(IMAGE_NAME)-candidate .
	IMAGE_NAME=$(IMAGE_NAME)-candidate test/run