def call() {
    script {
        dbname=sh(script: '$prod_db$(date +%d%b%y%H%M)', returnStdout: true).trim()
        sh '''
          #!/bin/sh
          rm -rf ~/dbs/*
          PGPASSWORD=$prod_dbpasswd pg_dump -h $prod_host --no-owner --no-acl -U $prod_dbuser $prod_db >~/dbs/$prod_db.sql
          DBNAME='"'$dbname'"'
          dbname=$prod_db$TIMESTAMP
          PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser postgres -c "create database $DBNAME;"        
          PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser $dbname < ~/dbs/$prod_db.sql
          sh ~/pidscript.sh
          scp -r sdwot@$prod_host:/usr/jail/$jailname/home/sdwot/erp/data/filestore/$prod_db ~/erp/data/filestore/
          mv  ~/erp/data/filestore/$prod_db ~/erp/data/filestore/$dbname
        '''
        update()
    }
}
