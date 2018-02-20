FROM java:8-alpine
MAINTAINER Your Name <you@example.com>

ADD target/uberjar/lumifoo.jar /lumifoo/app.jar

EXPOSE 3000

CMD ["java", "-jar", "/lumifoo/app.jar"]
