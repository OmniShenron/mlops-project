pipeline {
    agent any

    environment {
        MLFLOW_TRACKING_URI = "http://mlflow:5000"
    }

    stages {
        stage('Check Changes') {
            steps {
                script {
                    def changedFiles = sh(script: 'git diff --name-only HEAD~1 HEAD', returnStdout: true).trim()
                    if (!changedFiles.contains('trainer/train.py') && !changedFiles.contains('serve/app.py')) {
                        echo "No relevant changes detected, skipping pipeline."
                        currentBuild.result = 'SUCCESS'
                        return
                    }
                    echo "Changes detected: ${changedFiles}"
                }
            }
        }

        stage('Build Trainer') {
            steps { sh 'docker-compose build trainer' }
        }

        stage('Run Training') {
            steps { sh 'docker-compose run --rm trainer' }
        }

        stage('Build Serve API') {
            steps { sh 'docker-compose build serve' }
        }

        stage('Deploy Serve API') {
            steps { sh 'docker-compose up -d serve' }
        }
    }

    post {
        always {
            echo "Pipeline finished."
            sh 'docker ps -a'
        }
    }
}
