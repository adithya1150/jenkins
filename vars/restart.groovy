def call ()  {
    script {
       sh '''
       #!/bin/sh
       sh ~/$erppath/pidscript.sh
       /usr/local/bin/daemonize  /home/sdwot/erp/bin/python /home/sdwot/$erppath/$folder/sdwot.py -c /home/sdwot/$erppath/.erp_serverrc
       '''
    }
}
