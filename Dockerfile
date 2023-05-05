FROM openjdk:17
FROM maven:3.2 AS build
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app

#Copying the Bash Script for configuring the Postgres Image Application
COPY configure-postgres-password.sh /usr/src/app/docker-entrypoint-initdb.d/

# Set the script as executable
RUN chmod +x /docker-entrypoint-initdb.d/configure-postgres-password.sh


RUN mvn -f /usr/src/app/pom.xml clean package -DskipTests

COPY --from=build /usr/src/app/target/spring-library-management.jar /usr/app/

#---------------------------------------------------------
#Used to run when Jenkins gets configured
#RUN curl -X POST -u jenkins_user:jenkins_token "http://jenkins_url/job/my_project/buildWithParameters?GIT_URL=my_git_repo&GIT_BRANCH=my_branch&MAVEN_CMD=mvn clean install&DOCKER_IMAGE=my_docker_image:my_tag"
#---------------------------------------------------------

EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/app/spring-library-management.jar"]

#EXPOSE 8080
