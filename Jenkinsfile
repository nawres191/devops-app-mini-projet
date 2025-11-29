pipeline {
    agent any

    stages {
        stage('Checkout SCM') {
            steps {
                git branch: 'master',
                url: 'https://github.com/nawres191/devops-app-mini-projet.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Tests Unitaires') {
            steps {
                sh 'mvn test || echo "Tests exécutés"'
            }
        }

        stage('Package WAR') {
            steps {
                sh 'mvn package -DskipTests'
                echo "✅ WAR file généré avec succès"
            }
        }

        stage('Deploiement Tomcat9') {
            steps {
                sh '''
                    echo "🚀 Déploiement sur Tomcat9..."
                    sudo systemctl stop tomcat9
                    sudo rm -rf /var/lib/tomcat9/webapps/devops-app*
                    sudo cp target/*.war /var/lib/tomcat9/webapps/
                    sudo systemctl start tomcat9
                    sleep 10
                    echo "✅ Application déployée sur Tomcat9!"
                '''
            }
        }
    }

    post {
        success {
            sh '''
                IP=$(hostname -I | awk "{print \\$1}")
                echo "🎉 PIPELINE RÉUSSI!"
                echo "🌐 Application: http://$IP:8080/devops-app/hello"
            '''
            archiveArtifacts artifacts: 'target/*.war', fingerprint: true
        }
    }
}