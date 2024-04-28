pipeline {
    agent any

//     triggers {
//         pollSCM('* * * * *')
//     }

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

         stage("Package") {
             steps {
                sh "./gradlew build"
             }
         }

         stage("Docker build")
         {
             steps {
                sh "docker build -t alan171223/calculator1:${BUILD_TIMESTAMP} ."
             }
         }

         stage("Docker push")
         {
              steps
              {
                 sh "docker push alan171223/calculator1:1.1.1"
              }
         }

         stage("Deploy to staging")
         {
              steps
              {
                 sh "docker run -d --rm -p 8088:8088 --name calculator1 alan171223/calculator1::${BUILD_TIMESTAMP}"
              }
         }

         stage("Acceptance test")
         {
              steps
              {
                  sleep time: 30, unit: 'SECONDS'
                  sh "chmod +x acceptance_test.sh && ./acceptance_test.sh"
              }
         }
    }

    post {
          always {
                 sh "docker stop calculator1"
          }
    }
}