pipeline {
    agent any
    environment{
    FOO = "STAGE"
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
}
