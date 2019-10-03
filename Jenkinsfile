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
    post {
        always {
            echo "Compiling Project"
            mvn compile
            echo "Running Employee Soriting"
            mvn exec:java -Dexec.mainClass=com.rishab.sorting.EmployeeSorting
        }
    }
}
