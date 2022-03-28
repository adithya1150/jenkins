def call(logpath){
 script {
     sh '''
     #!/bin/sh
     set +x
     /usr/bin/tail -f ~/$logpath/log/erp.log & PID=$!
     /bin/sleep 100
     /bin/kill $PID
     '''
    }
}
