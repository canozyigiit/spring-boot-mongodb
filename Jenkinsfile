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
        withCredentials([usernamePassword( credentialsId: 'docker-hub-credentials', usernameVariable: "${USERNAME}", passwordVariable: "${PASSWORD}")]) {
            docker.withRegistry('', 'docker-hub-credentials') {
                 sh "docker login -u ${USERNAME} -p ${PASSWORD}"
                 sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
            }
        }
    }
    }
  }