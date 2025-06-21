pipeline {
    agent any

    parameters {
        choice(
            name: 'API_GROUP',
            choices: ['all', 'GetUsers', 'GetBookingIds'],
            description: 'Select API group to test'
        )
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/piyushpandey999/APIAutomation.git'
            }
        }

        stage('Test') {
            steps {
                script {
                    // Map Jenkins parameter to TestNG group
                    def testGroup = params.API_GROUP == 'all' ? '.*' : params.API_GROUP

                    // Use bat for Windows or sh for Unix/Linux
                    if (isUnix()) {
                        sh "mvn clean test -Dtest.group=${testGroup}"
                    } else {
                        bat "mvn clean test -Dtest.group=${testGroup}"
                    }
                }
            }
        }

        stage('Report') {
            steps {
                publishHTML([
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'Reports',
                    reportFiles: 'AutomationTestReport*.html',
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
                to: 'piyushpandey3399@gmail.com',
                attachLog: true,
                attachmentsPattern: 'Reports/AutomationTestReport*.html'
            )
        }
    }
}