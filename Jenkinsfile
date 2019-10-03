pipeline {
    agent any
    environment{
    FOO = "STAGE"
    }
    tools{
    maven 'MAVEN-3.6.2'
    jdk 'JDK1.8'
    }
    stages {
        stage("Build"){
            steps {
                echo 'Building....'
                echo "${FOO}"
            }
        }
        stage("Test"){
            steps{
                echo ' Testing....'
            }
        }
        stage("Deploy"){
            steps {
                echo 'Deploying....'
            }
        }
    }
    post {
        always {
            echo "Compiling Project"
            mvn compile
        }
    }
}
