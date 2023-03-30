pipeline {
    agent any
  
    stages {
        stage('Test') {
            steps {
                sh "gradle clean test"
            }
  
            post {                
                success {
                   publishHTML([
                      allowMissing: false, 
                      alwaysLinkToLastBuild: false, 
                      keepAll: false, 
                      reportDir: 'lib/target/site/serenity/', 
                      reportFiles: 'index.html', 
                      reportName: 'Test Report', 
                      reportTitles: 'Test Report', 
                      useWrapperFileDirectly: true])
                }
            }
        }
    }
}
