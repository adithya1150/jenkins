def call (erppath)  {
    script {
       sh '''
       #!/bin/sh
       sh ~/$erppath/pidscript.sh
       /usr/local/bin/daemonize  /home/sdwot/erp/bin/python /home/sdwot/$erppath/$folder/sdwot.py -c /home/sdwot/erp/.erp_serverrc
       '''
    }
}
