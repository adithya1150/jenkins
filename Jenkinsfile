properties([
    parameters([
        [$class: 'ChoiceParameter',
            choiceType: 'PT_SINGLE_SELECT',
            filterLength: 1,
            filterable: false,
            name: 'Environment',
            script: [
                $class: 'GroovyScript',
                fallbackScript: [
                    classpath: [],
                    sandbox: false,
                    script: 'return ["Please select proper environment"]'
                ],
                script: [
                    classpath: [],
                    sandbox: false,
                    script: 'return ["Select:selected","Production","Training"]'
                ]
            ]
        ],
        [$class: 'CascadeChoiceParameter', 
            choiceType: 'PT_SINGLE_SELECT', 
            filterLength: 1, 
            filterable: false, 
            name: 'AGENT',
            referencedParameters: 'Environment',
            script: [
                $class: 'GroovyScript', 
                fallbackScript: [
                    classpath: [], 
                    sandbox: false, 
                    script: 'return["Please select proper environment"]'
                ], 
                script: [
                    classpath: [], 
                    sandbox: false, 
                    script: '''if(Environment.equals("Production")) { return ["Select:selected","test", "Saideepa", "Cenerg", "Rocktec", "Sdforging", "Jaya", "Rockbit"]}else if(Environment.equals("Training")) { return ["Select:selected","test","saideepat","jayat","drilltecht","rockbitt", "rocktect", "cenergt", "test","sdforgingt"] }else { return ["Please select environment"]}'''
                ]
            ]
        ],
        [$class: 'CascadeChoiceParameter', 
            choiceType: 'PT_SINGLE_SELECT', 
            filterLength: 1, 
            filterable: false, 
            name: 'Action',
            referencedParameters: 'Environment',
            script: [
                $class: 'GroovyScript', 
                fallbackScript: [
                    classpath: [], 
                    sandbox: false, 
                    script: 'return["Please select proper action"]'
                ], 
                script: [
                    classpath: [], 
                    sandbox: false, 
                    script: '''if(Environment.equals("Production")) { return ["Select:selected","logs", "restart", "update", "pullupdate", "pullrestart"]}else if(Environment.equals("Training")) { return ["Select:selected","logs","restart","snapshot","pullupdate","pullrestart"]}else { return ["Please select action"]}'''
                ]
            ]
        ] 
    ])
])
def logs (){
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
def restart ()  {
    script {
       sh '''
       #!/bin/sh
       sh ~/pidscript.sh
       /usr/local/bin/daemonize  /home/sdwot/erp/bin/python /home/sdwot/erp/$folder/sdwot.py -c /home/sdwot/erp/.erp_serverrc
       '''
    }
}
def update (){
    script {
        sh '''
        #!/bin/sh
        set +x
        sh ~/pidscript.sh
        /usr/local/bin/daemonize -E BUILD_ID=dontKillMe ~/erp/bin/python ~/erp/$folder/sdwot.py -c ~/erp/.erp_serverrc -u all -d $prod_db
        echo "An update has been started"
        echo "Please wait for 15 mins"
        /bin/sleep 100
        sh ~/pidscript.sh         
        /usr/local/bin/daemonize  /home/sdwot/erp/bin/python /home/sdwot/erp/$folder/sdwot.py -c /home/sdwot/erp/.erp_serverrc
        '''
        }
}
def snapshot () {
    script {
        sh '''
        #!/bin/sh
        rm -rf ~/dbs/*
        PGPASSWORD=$prod_dbpasswd pg_dump -h $pod_host --no-owner --no-acl -U $prod_dbuser $prod_db >~/dbs/$prod_db.sql
        TIMESTAMP=`date +%d%b%y%H%M | tr '[:upper:]' '[:lower:]'`
        DBNAME=$prod_db$TIMESTAMP
        PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser postgres -c "create database $prod_db"
        PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser $prod_db < ~/dbs/$prod_db.sql
        sh ~/pidscript.sh
        PGPASSWORD=$prod_dbpasswd psql -h $training_host -U $prod_dbuser postgres -c "alter database $prod_db rename to $DBNAME"
        scp -r sdwot@$prod_host:/usr/jail/$jailname/home/sdwot/erp/data/filestore/$prod_db ~/erp/data/filestore/
        mv  ~/erp/data/filestore/$prod_db ~/erp/data/filestore/$DBNAME
        /usr/local/bin/daemonize -E BUILD_ID=dontKillMe /home/sdwot/erp/bin/python /home/sdwot/erp/$folder/sdwot.py -c /home/sdwot/erp/.erp_serverrc -d $DBNAME -u all
        echo "An update has been started"
        echo "Please wait for 15 mins"
        /bin/sleep 900
        sh ~/pidscript.sh
        /usr/local/bin/daemonize /home/sdwot/erp/bin/python /home/sdwot/erp/$folder/sdwot.py -c /home/sdwot/erp/.erp_serverrc
        '''
    }
}
pipeline {
    agent {
        label params.AGENT == "any" ? "" : params.AGENT 
    }
    environment { JENKINS_NODE_COOKIE= 'do_not_kill'}
    
    options { timestamps () }
    stages {
        stage ('defining variables'){
            steps {
                buildName "# ${BUILD_NUMBER} |$env.Environment | $AGENT | $action"
                script{
                    switch(env.AGENT) {    
                    case 'Saideepa':
                    env.prod_db         =   "saideepa"
                    env.folder          =   "saideepa"
                    break
                    case 'Cenerg':
                    env.prod_db         =   "c2_prod"
                    env.folder          =   "cenerg"
                    break
                    case 'Rocktec':
                    env.prod_db         =   "rocktec"
                    env.folder          =   "saideepa"
                    break
                    case 'Sdforging':
                    env.prod_db         =   "sdforging" 
                    env.folder          =   "saideepa"                                     
                    break
                    case 'Jaya':
                    env.prod_db         =   "jaya" 
                    env.folder          =   "saideepa"                                     
                    break
                    case 'Rockbit':
                    env.prod_db         =   "rockbit" 
                    env.folder          =   "saideepa"                                     
                    break    
                    case 'test':
                    env.prod_db         =   "jaya"
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "jaya"
                    env.prod_dbpasswd   =   "jaya"
                    env.prod_hostname   =   "jaya"
                    env.training_host   =   "192.168.181.252"                    
                    env.prod_host       =   "192.168.181.222"                    
                    break
                    case 'saideepat':
                    env.prod_db         =   "saideepa" 
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "saideepa"
                    env.prod_dbpasswd   =   "saideepa"
                    env.prod_hostname   =   "saideepa"                      
                    env.training_host   =   "192.168.181.252"                    
                    env.prod_host       =   "192.168.181.222" 
                    break
                    case 'jayat':
                    env.prod_db         =   "jaya"
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "jaya"
                    env.prod_dbpasswd   =   "jaya"
                    env.prod_hostname   =   "jaya"
                    env.training_host   =   "192.168.181.252"                    
                    env.prod_host       =   "192.168.181.222"
                    break
                    case 'drilltecht':
                    env.prod_db         =   "drilltech"
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "drilltech"
                    env.prod_dbpasswd   =   "drilltech"                  
                    env.jailname        =   "drilltech" 
                    env.training_host   =   "192.168.181.252"                    
                    env.prod_host       =   "192.168.181.222"
                    break
                    case 'rockbitt':
                    env.prod_db         =   "rockbit" 
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "rockbit"
                    env.prod_dbpasswd   =   "rockbit"  
                    env.jailname        =   "rockbit"                  
                    env.ip              =   "192.168.181.246"
                    env.training_host   =   "192.168.181.252"                                                          
                    break
                    case 'rocktect':
                    env.prod_db         =   "rocktec" 
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "rocktec"
                    env.prod_dbpasswd   =   "rocktec"
                    env.jailname        =   "rocktec"                   
                    env.training_host   =   "192.168.6.3"                    
                    env.prod_host       =   "192.168.6.111"                                      
                    break
                    case 'cenerg':
                    env.prod_db         =   "c2_prod" 
                    env.folder          =   "cenerg"
                    env.prod_dbuser     =   "cenerg"
                    env.prod_dbpasswd   =   "cenerg"
                    env.jailname        =   "cenerg"                   
                    env.training_host   =   "192.168.6.3"                    
                    env.prod_host       =   "192.168.6.111"                                      
                    break
                    case 'sdforging':
                    env.prod_db         =   "sdforging" 
                    env.folder          =   "saideepa"
                    env.prod_dbuser     =   "sdf"
                    env.prod_dbpasswd   =   "sdf"
                    env.jailname        =   "sdf"                   
                    env.training_host   =   "192.168.6.3"                    
                    env.prod_host       =   "192.168.6.111"                                      
                    break                    
                    }
                }
            }
        }
        stage ('checking logs') {
            when {
                expression { action == "logs" }
            }
            steps  { 
               logs()
            }
        }
        stage ('restart') {
            when {
                expression { action == "restart"}
            }
            steps ('restarting the instance') {
                restart()
            }
        }
        stage ('update') {
            when {
                allOf {  
                expression { action == "update" }
                expression { env.Environment == "Production" }
                }
            }
            parallel {
                stage ('update') {
                    input {
                       message "Are you sure you want to proceed?"
                    }
                    steps ('updating erp') {
                        update()
                    }
                }    
                stage ('logs') {
                   steps  {            
                        logs()
                    }           
                }
            }
        }
        stage ('pull update') {
            when {
                allOf {
                    expression { action == "pullupdate" }
                    expression { env.Environment == "Production" }
                }
            }
            parallel {
                stage ('pullupdate') {
                    steps {
                        script {
                            sh '''
                            #!/bin/sh
                            cd ~/erp/$folder
                            git fetch
                            C=`git rev-list HEAD...origin/master --count`
                            set +x
                            if [ $C -eq 0 ]
                            then
                            echo "no new commits were found"
                            else
                            git fetch
                            git reset --hard
                            git  pull origin master
                            update()
                            fi                            
                            '''
                        }
                    }
                }                     
                stage ('logs') {
                   steps  {            
                        logs()
                        }
                    }           
                }
            }
        stage ('pull restart') {
            when {
                expression { action == "pullrestart" }
            }
            steps  {
                script{
                    sh '''
                    #!/bin/sh
                    cd ~/erp/$folder
                    git fetch
                    C=`git rev-list HEAD...origin/master --count`
                    set +x
                    if [ $C -eq 0 ]
                    then
                    echo "no new commits were found"
                    else
                    git fetch
                    git reset --hard
                    git  pull origin master                                       
                    fi
                    restart()
                    '''                                                     
                }
            }
        }
        stage ('training pull update') {
            when {
                expression { action == "pullupdate" }
            }
            parallel {
                stage ('pullupdate') {
                    input {
                        message "Are you sure you want to proceed?"
                    }
                    steps {
                        script {
                            sh '''
                            #!/bin/sh
                            cd ~/erp/$folder                        
                            git  pull origin master
                            '''
                            fi
                        }
                        snapshot()
                    }   
                }
                stage ('logs') {
                   steps  {            
                        logs()
                        }
                    }           
                }
            }
        stage ('snapshot') {
            when {
                allOf {
                    expression { env.Environment == "Training" }
                    expression { action == "pullupdate" }
                }
            }
            steps {
                snapshot() 
                }
            }
        }
    }
