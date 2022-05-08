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
//          stage('BUILD DOCKER IMAGE') {
//             steps{
//                 script {
//                     dockerImage = docker.build registry + ":latest"
//                 }
//             }
//         }
        stage('Verify Tooling') {
            steps {
                 sh '''
                    docker version
                    docker info
                    docker-compose --version
                    curl --version
                    jq --version
                '''
            }
        }
        stage('Prune Docker Data')
        {
            steps{
                sh 'docker system prune -a --volumes -f'
            }
        }
        stage('START Containers')
        {
            steps
            {
            sh 'docker-compose up -d --no-colo --wait'
            sh 'docker compose ps'
            }
        }
        stage('Run Tests')
        {
            steps{
                sh 'curl http://localhost:9090 | jq'
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
            //}
    }

}
