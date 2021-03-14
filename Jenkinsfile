stage('Build image') {
  app = docker.build("linnovate-devops/test2")
}
stage('Push image') {
  docker.withRegistry('https://eu.gcr.io', 'gcr:gcr-key') {
    app.push("${env.BUILD_NUMBER}")
    app.push("latest")
  }
}