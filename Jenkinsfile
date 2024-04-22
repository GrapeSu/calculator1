pipeline {
    agent any

    triggers {
        pollSCM('* * * * *')
    }

    stages {
        stage("Compile")
        {
            steps {
                sh "./gradlew compileJava"
            }
        }

        stage("Unit Test")
        {
            steps{
                sh "./gradlew test"
            }
        }

        stage("Code Coverage")
        {
            steps{
                sh "./gradlew jacocoTestReport"
                publishHTML (target: [
                                      reportDir: 'build/reports/jacoco/test/html',
                                      reportFiles: 'index.html',
                                      reportName: "JaCoCo Report"
                            ])
                sh "./gradlew jacocoTestCoverageVerification"
            }
        }

        stage("Static code analysis")
        {
             steps{
                 sh "./gradlew checkstyleMain"
                 publishHTML (target: [ reportDir: 'build/reports/checkstyle/',
                                        reportFiles: 'main.html',
                                        reportName: "Checkstyle Report"
                 ])
             }
        }
    }

    post {
          always
          {
               mail to: 'shoujiewang0902@gmail.com',
               subject: "Completed Pipeline: ${currentBuild.fullDisplayName}",
               body: "Your build completed, please check: ${env.BUILD_URL}"
          }
    }
}