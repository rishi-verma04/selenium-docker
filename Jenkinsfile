pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //bat
                sh "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //bat
                sh "docker build -t=rishiyudi04/selenium-docker:${BUILD_NUMBER} ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        sh "docker login --username=${user} --password=${pass}"
			      //  sh "docker push rishiyudi04/selenium-docker:${BUILD_NUMBER}"
			        sh "docker push rishiyudi04/selenium-docker:latest"


			    }
            }
        }
    }
}