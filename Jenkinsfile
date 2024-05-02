pipeline {
    agent any
    options {
        timeout(time: 12, unit: 'HOURS')
    }
    stages {
        stage(build) {
            steps {
                sh '''
                    . ./.bashrc
                    cd app
                    gradle build
                '''
            }
        }
    }
}
