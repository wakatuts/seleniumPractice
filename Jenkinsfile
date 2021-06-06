node {
   stage('Git checkout') { // for display purposes
        git 'https://github.com/wakatuts/seleniumPractice.git'
   }
   stage('Test') {
        try {
            sh "mvn verify"
        } catch (err) {
            
        } finally {
        	 script {
              allure([
                includeProperties: false,
                jdk: '',
                properties: [],
                reportBuildPolicy: 'ALWAYS',
                results: [[path: 'target/allure-results']]
              ])
            }
        }
   }
   stage('Results') {
      junit '**/target/surefire-reports/*.xml'
   }
}
