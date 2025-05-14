pipeline {
    agent any

    tools {
        maven 'MAVEN399'
        jdk 'JDK21'
    }

    environment {
        DOCKER_IMAGE = 'ecovimil/app'
    }

    stages {
        stage('Compile Stage') {
            steps {
                withMaven(maven: 'MAVEN399') {
                    bat 'mvn clean compile'
                }
            }
        }

        stage('Testing Stage') {
            steps {
                withMaven(maven: 'MAVEN399') {
                    bat 'mvn test'
                }
            }
        }

        stage('Package Stage') {
            steps {
                withMaven(maven: 'MAVEN399') {
                    bat 'mvn package'
                }
            }
        }

        stage('Integration Tests') {
            steps {
                bat 'run_integration_tests.bat' // o reemplazar con comandos reales si no existe
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t %DOCKER_IMAGE%:%BUILD_NUMBER% .'
            }
        }

        stage('Deploy to Staging') {
            steps {
                bat '''
                    docker stop eco-movil-staging || exit 0
                    docker rm eco-movil-staging || exit 0
                    docker run -d --name eco-movil-staging -p 8081:8080 %DOCKER_IMAGE%:%BUILD_NUMBER%
                '''
            }
        }

        // Puedes agregar una etapa de pruebas en Staging aquí si lo deseas

        stage('Deploy to Production') {
            when {
                branch 'main'
            }
            steps {
                bat '''
                    docker tag %DOCKER_IMAGE%:%BUILD_NUMBER% %DOCKER_IMAGE%:latest
                    docker push %DOCKER_IMAGE%:latest
                    docker stop eco-movil-prod || exit 0
                    docker rm eco-movil-prod || exit 0
                    docker run -d --name eco-movil-prod -p 80:8080 %DOCKER_IMAGE%:latest
                '''
            }
        }
    }

    post {
        success {
            echo "Despliegue exitoso del build #${env.BUILD_NUMBER}"
        }
        failure {
            echo "El despliegue falló en el build #${env.BUILD_NUMBER}"
        }
    }
}
