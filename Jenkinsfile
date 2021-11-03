pipeline {
agent any
environment {
IMAGE_REGISTRY = 'dockerhub.detaysoft.com/das/das-api'
IMAGE_VERSION = 'latest'
IMAGE_REGISTRY_CREDENTIAL = 'dockerhubcreds'
DOCKER_REGISTRY_URL = ""
}
stages {
stage('Build') {
agent {
docker {
image 'maven:3.8.1-adoptopenjdk-11'
args '-v $HOME/.m2:/root/.m2'
reuseNode true
}
}
steps {
sh """
mvn compile jib:dockerBuild
"""
}
}

stage('Docker Publish') {
steps {
withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://dockerhub...soft.com"]) {
sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
}
}
}

stage('Deploy Docker-compose') {
steps {
sh "docker-compose -f /opt/das-deployment/docker-compose.yaml stop das-api"
withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://dockerhub...soft.com"]) {
sh "docker-compose -f /opt/das-deployment/docker-compose.yaml pull das-api"
}
dir('/opt/das-deployment') {
sh "docker-compose up -d das-api"
}
}
}
}
}