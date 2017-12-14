
# esport-schedule
FROM openshift/base-centos7

ENV ESPORT_SCHEDULE 1.0

LABEL maintainer="luladjiev@gmail.com" \
      io.k8s.description="Platform for building Spring.io project" \
      io.k8s.display-name="Esport-Schedule builder" \
      io.openshift.expose-services="8080:http"
#      io.openshift.tags="builder,x.y.z,etc."

RUN curl --silent --location https://rpm.nodesource.com/setup_8.x | bash - && \
    yum install -y java-1.8.0-openjdk maven nodejs && \
    yum clean all -y

# TODO (optional): Copy the builder files into /opt/app-root
# COPY ./<builder_folder>/ /opt/app-root/

COPY ./s2i/bin/ /usr/libexec/s2i

RUN chown -R 1001:1001 /opt/app-root

USER 1001

EXPOSE 8080

 CMD ["/usr/libexec/s2i/usage"]
