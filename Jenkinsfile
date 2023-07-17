pipeline{
  agent any
  tools{
    maven 'M2_HOME'
  }
  stages{
    stage('git clone'){
      steps{
        git branch: 'master',
        credentialsId: 'Git-lab-cred',
        url: ''
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
