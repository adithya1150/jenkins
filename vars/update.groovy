def call(){
    script {
        sh '''
        #!/bin/sh
        sh ~/$erppath/pidscript.sh
       /usr/local/bin/daemonize  /home/sdwot/erp/bin/python /home/sdwot/$erppath/$folder/sdwot.py -c /home/sdwot/$erppath/.erp_serverrc -u all -d $dbname
        echo "An update has been started"
        echo "Please wait for 15 mins"
        /bin/sleep 100
        '''
    }
    restart()
}
