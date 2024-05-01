pipeline {
    agent any
    options {
        timeout(time: 12, unit: 'HOURS')
    }
    stages {
        stage(build) {
            steps {
                echo "[OUTPUT] Pipeline in Build stage"
                cd app
                gradle build
            }
        }
    }
}
