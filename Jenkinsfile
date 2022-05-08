pipeline
{
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
    }
}

