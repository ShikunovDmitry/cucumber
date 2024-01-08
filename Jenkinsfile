pipeline {
    agent any
     tools { 
        maven 'maven3' 
    }
    stages {
        stage('Build') { 
            steps {
                sh "mvn clean test -Dbrowser=${params.browser} -Denv=${params.env}" 
            }
        }
    }
}
