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

    stage('Build QA') {
      parallel {
        stage('Build QA') {
          steps {
            sh 'mvn clean install -DskipTests=true'
          }
        }

        stage('chrome') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=chrome'
          }
        }

        stage('firefox') {
          steps {
            sh 'mvn test -Denv=qa -Dbrowser=firefox'
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