pipeline {
  agent any
  environment {
    IMAGE_REGISTRY = 'canozyigiit/spring-boot-mongodb'
    IMAGE_VERSION = 'latest'
    IMAGE_REGISTRY_CREDENTIAL = 'dockerhub'
    DOCKER_REGISTRY_URL = ""
    USERNAME='canozyigiit'
    PASSWORD='verylongpasswordhere'
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
                withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://registry.hub.docker.com"]) {
                    sh "docker push ${IMAGE_REGISTRY}"
                }
            }
        }
    }
  }