pipeline {
    agent any
    options {
        timeout(time: 12, unit: 'HOURS')
    }
    stages {
        stage(build) {
            steps {
                sh 'pwd'
                sh 'ls -lah'
                sh 'source .bashrc'
                sh 'cd app'
                sh 'gradle build'
            }
        }
    }
}
