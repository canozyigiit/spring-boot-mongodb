// pipeline {
//   agent any
//   def app
//   environment {
//     IMAGE_REGISTRY = "canozyigiit/spring-jenkinsfile-ex"
//     IMAGE_VERSION = 'latest'
//     IMAGE_REGISTRY_CREDENTIAL = 'dockerhub'
//     DOCKER_REGISTRY_URL = ""
//   }
//     stages {
//        stage('Build') {
//             agent {
//                 docker {
//                     image 'maven:3.8.1-adoptopenjdk-11'
//                     args '-v $HOME/.m2:/root/.m2'
//                     reuseNode true
//                 }
//             }
//             steps {
//                 sh """
//                 mvn compile jib:dockerBuild
//                 """
//             }
//        }
//        stage('Build image') {
//                /* This builds the actual image */
//
//                docker.build("canozyigiit/spring-jenkinsfile-ex")
//        }
//
//        stage('Test image') {
//
//            app.inside {
//                echo "Tests passed"
//            }
//        }
//        stage('Push image') {
//             steps {
//                 withDockerRegistry([credentialsId: "${IMAGE_REGISTRY_CREDENTIAL}", url: "https://registry.hub.docker.com"]) {
//                     sh "docker push ${IMAGE_REGISTRY}:${IMAGE_VERSION}"
//                 }
//             }
//        }
//     }
//   }
node {
    agent any
    stage('Clone repository') {
        /* Cloning the Repository to our Workspace */

        checkout scm
    }

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

    stage('Test image') {

        app.inside {
            echo "Tests passed"
        }
    }

    stage('Push image') {
        /*
			You would need to first register with DockerHub before you can push images to your account
		*/
        docker.withRegistry('https://registry.hub.docker.com', 'docker-hub') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
            }
                echo "Trying to Push Docker Build to DockerHub"
    }
}