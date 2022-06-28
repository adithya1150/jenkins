def call(){
       sh '''
        #!/bin/bash
        cd $client_path
        rm -rf node_modules package-lock.json build
        npm update -f
        npm run build
        nohup serve -s build &
        '''
}
