def call(){
        sh '''
         cd $backend_path
         sh ~/.stopservices.sh
         rm -rf node_modules
         npm update -f
         nohup  npm start &
         '''
}
