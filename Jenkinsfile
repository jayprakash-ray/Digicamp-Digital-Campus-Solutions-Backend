pipeline
{
     environment
    {
        registry = "jpray/digicamp_backend_using_jenkins"
        registryCredential = 'docker-cred'
        dockerImage = ''
    }
    agent any
    stages
    {
        stage('GIT PULL')
        {
          steps
          {
            // Get some code from a GitHub repository
            git url: 'https://github.com/jayprakash-ray/Digicamp-Digital-Campus-Solutions-Backend.git', branch: 'main',
            credentialsId: 'git_cred'
          }

       }
       stage('BUILD')
       {
           steps
           {
               sh 'mvn clean install'

           }
       }
        stage('TESTING') {
            steps {
                // Unit testing on compiled source code.
                sh "mvn test"
            }
        }
         stage('BUILD DOCKER IMAGE') {
            steps{
                script {
                    dockerImage = docker.build registry + ":latest"
                }
            }
        }
                stage('PUSH TO DOCKERHUB') {
                    steps{
                        script {
                            docker.withRegistry( '', registryCredential ) {
                            dockerImage.push()
                            }
                        }
                    }
                }
//             stage('ANSIBLE IMAGE DEPLOY'){
//                 steps{
//                                   ansiblePlaybook becomeUser: null, colorized: true, disableHostKeyChecking: true, installation: 'Ansible', inventory: 'ansible-deploy/inventory', playbook: 'ansible-deploy/deploy-image.yml', sudoUser: null
//                          }

//                         }
//     }
}

