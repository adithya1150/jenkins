def call(){
    script {
        sh '''
         #!/bin/bash
         pwd
         sh ~/.stopservices.sh
         rm -rf node_modules
         npm update -f
         nohup  npm start &
         '''
    }
}
