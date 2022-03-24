def call(file){           
   script {
     sh '''
     #!/bin/sh
     set +x
     /usr/bin/tail -f ~/$file/log/erp.log & PID=$!
     /bin/sleep 100
     /bin/kill $PID
     '''
    }
}
