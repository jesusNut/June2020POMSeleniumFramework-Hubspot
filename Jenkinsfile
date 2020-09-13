pipeline {
  agent any
  stages {
    stage('Build Dev') {
      parallel {
        stage('Build Dev') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=dev'
          }
        }

      }
    }

    stage('Build QA-Chrome') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -Denv=qa'
          }
        }

      }
    }
    
    stage('Build QA-Chrome-2') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -Denv=dev'
          }
        }

      }
    }

   

    
    stage('Publish reports') {
           steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: '/allure-results']]
                    ])
                }
            }
        }
    
    

  }
  tools {
    maven 'M3'
  }
}