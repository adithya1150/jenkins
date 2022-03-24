def call(){           
   script {
     sh '''
     #!/bin/sh
     set +x
     /usr/bin/tail -f ~/erp/log/erp.log & PID=$!
     /bin/sleep 100
     /bin/kill $PID
     '''
    }
}
