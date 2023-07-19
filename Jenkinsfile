pipeline{
  agent any
  tools{
    maven 'Maven_Home'
  }
  stages{
    stage('git clone'){
      steps{
        git branch: 'master',
        credentialsId: 'git-hub-cred',
        url: 'https://github.com/sudharsang2/maven-pipelinedemo.git'
      }
    }
    stage('Compile and Clean'){
      steps{
        sh "mvn clean compile"
      }
    }
    stage('Test'){
      steps{
        sh "mvn test"
      }
    }
    stage('Deploy'){
      steps{
        sh "mvn package"
      }
    }
  }
}
