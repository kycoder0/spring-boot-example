pipeline {
    environment {
        PATH = "$PATH:/usr/local/bin"
    }
    agent any
    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        jdk 'java-16'
    }

    stages {

        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git branch: 'main', url: 'https://github.com/trev-dev0/spring-boot-example.git'
                sh '/usr/local/bin/docker-compose down -v'
                sh '/usr/local/bin/docker-compose up -d'
                // Run Maven on a Unix agent.
                withMaven(maven: 'M3') {
                     sh "mvn clean package"
                }
            }
            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.

                success {
                    sh "echo success"

                }
            }
        }
    }
}