pipeline {
    agent any

    parameters {
        choice(
            name: 'API_GROUP',
            choices: ['all', 'user', 'product', 'order'],
            description: 'Select API group to test'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/your-repo/rest-assured-framework.git'
            }
        }

        stage('Test') {
            steps {
                script {
                    // Map Jenkins parameter to TestNG group
                    def testGroup = params.API_GROUP == 'all' ? '.*' : params.API_GROUP
                    sh "mvn clean test -Dtest.group=$testGroup"
                }
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport*.html',
                    reportName: 'API Test Report',
                    reportTitles: ''
                ])
            }
        }
    }

    post {
        always {
            emailext(
                subject: "API Tests: ${currentBuild.result ?: 'SUCCESS'} - Build #${env.BUILD_NUMBER}",
                body: """<p>Build Result: ${currentBuild.result ?: 'SUCCESS'}</p>
                         <p>API Group Tested: ${params.API_GROUP}</p>
                         <p>Report: <a href="${env.BUILD_URL}HTML_Report/">HTML Report</a></p>""",
                to: 'team@example.com',
                attachLog: true,
                attachmentsPattern: 'test-output/ExtentReport*.html'
            )
        }
    }
}