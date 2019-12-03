pipeline {
  agent none
  stages {
    stage('Test') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2'
        }

      }
      steps {
        sh 'mvn clean verify'
      }
    }

    stage('Build Producton') {
      agent {
        docker {
          image 'maven:3-alpine'
          args '-v /root/.m2:/root/.m2'
        }

      }
      steps {
        sh 'mvn clean package -Dproduction'
      }
    }

    stage('Build Image') {
      steps {
        script {
          app = docker.build("yogstation/yogstation-achievements-api")
          docker.withRegistry('https://registry.hub.docker.com', 'yogstation-docker-hub-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
          }
        }

      }
    }

    stage('Deploy') {
      agent {
        docker {
          image 'k3integrations/kubectl'
        }

      }
      steps {
        withKubeConfig([credentialsId: 'yogstation-kubeconf-credentials']) {
          sh 'kubectl set image --namespace yogstation-services deployment/yogstation-achievements-api yogstation-achievements-api=yogstation/yogstation-achievements-api:${BUILD_NUMBER}'
        }
      }
    }

  }
}