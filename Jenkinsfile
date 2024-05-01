pipeline {
    agent any
    options {
        timeout(time: 12, unit: 'HOURS')
    }
    stages {
        stage(build) {
            steps {
                sh 'cd app'
                sh 'gradle build'
            }
        }
    }
}
