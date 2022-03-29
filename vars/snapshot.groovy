def snapshot () {
    script {
        sh '''
        #!/bin/sh
        rm -rf ~/dbs/*
        PGPASSWORD=$prod_dbpasswd pg_dump -h $pod_host --no-owner --no-acl -U $prod_dbuser $prod_db >~/dbs/$prod_db.sql
        TIMESTAMP=`date +%d%b%y%H%M | tr '[:upper:]' '[:lower:]'`
        DBNAME=$prod_db$TIMESTAMP
//         PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser postgres -c "create database $prod_db"
//         PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser $prod_db < ~/dbs/$prod_db.sql
//         sh ~/pidscript.sh
//         PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser postgres -c "alter database $prod_db rename to $DBNAME"
//         scp -r sdwot@$prod_host:/usr/jail/$jailname/home/sdwot/erp/data/filestore/$prod_db ~/erp/data/filestore/
//         mv  ~/erp/data/filestore/$prod_db ~/erp/data/filestore/$DBNAME
        '''
        echo $DBNAME
        //update($DBNAME)
    }
}
