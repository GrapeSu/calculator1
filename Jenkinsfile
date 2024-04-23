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

        stage("Package") {
             steps {
                sh "./gradlew build"
             }
        }

        stage("Docker build")
        {
             steps {
                sh "docker build -t alan171223/calculator1 ."
             }
        }

        stage("Docker push")
        {
             steps
             {
                sh "docker push alan171223/calculator1"
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

//     post {
//           always
//           {

//           }
//     }
}