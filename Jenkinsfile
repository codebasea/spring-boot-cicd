pipeline {
    agent any
    tools {
        maven '3.9.4'
    }

    stages {
        stage('Build Maven') {
            steps {
                echo 'Hello World'
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: '203ea52b-089f-421b-907e-1dfff40ea572', url: 'https://github.com/codebasea/spring-boot-cicd']])
                bat 'mvn clean install'
            }
        }
         stage('Build Docker Image') {
             steps {
                  script {
                      bat 'docker build -t prk54989/spring-boot-docker .'
                  }
             }
         }
         stage('Push Image to Docker Hub') {
             steps {
                  script {
                     withCredentials([string(credentialsId: 'docker-hub-pwd', variable: 'dockerhubpwd')]) {
                     bat 'docker login -u prk54989 -p ${docker-hub-pwd}'
                     bat 'docker push prk54989/spring-boot-docker'
                    }
                  }
             }
         }

    }
}



