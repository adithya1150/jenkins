
def variables() {
    script{
       switch(env.AGENT) {            
            case 'test':
                env.prod_db         =   "jaya"
                env.folder          =   "sdwot"
                env.prod_dbuser     =   "jaya"
                env.prod_dbpasswd   =   "jaya"
                env.prod_hostname   =   "jaya"
                env.erppath         =   "$taskid"
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"                    
            break
            case 'saideepat':
                env.prod_db         =   "saideepa" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "saideepa"
                env.prod_dbpasswd   =   "saideepa"
                env.prod_hostname   =   "saideepa"                      
                env.erppath         =   "$taskid"
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222" 
            break
            case 'jayat':
                env.prod_db         =   "jaya"
                env.folder          =   "sdwot"
                env.prod_dbuser     =   "jaya"
                env.prod_dbpasswd   =   "jaya"
                env.prod_hostname   =   "jaya"
                env.erppath         =   "$taskid"                
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"
            break
            case 'drilltecht':
                env.prod_db         =   "drilltech"
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "drilltech"
                env.prod_dbpasswd   =   "drilltech"                  
                env.jailname        =   "drilltech"
                env.erppath         =   "$taskid"                 
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"
            break
            case 'rockbitt':
                env.prod_db         =   "rockbit" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "rockbit"
                env.prod_dbpasswd   =   "rockbit"  
                env.jailname        =   "rockbit"
                env.erppath         =   "$taskid"                                  
                env.ip              =   "192.168.181.246"
                env.training_host   =   "192.168.181.252"                                                          
            break
            case 'rocktect':
                env.prod_db         =   "rocktec" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "rocktec"
                env.prod_dbpasswd   =   "rocktec"
                env.erppath     =   "$taskid"                                   
                env.training_host   =   "192.168.6.3"                    
                env.prod_host       =   "192.168.6.111"                                      
            break
            case 'cenergt':
                env.prod_db         =   "c2_prod" 
                env.folder          =   "cenerg"
                env.prod_dbuser     =   "cenerg"
                env.prod_dbpasswd   =   "cenerg"
                env.jailname        =   "cenerg" 
                env.erppath         =   "$taskid"                                  
                env.training_host   =   "192.168.6.3"                    
                env.prod_host       =   "192.168.6.111"                                      
            break
            case 'sdforgingt':
                env.prod_db         =   "sdforging" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "sdf"
                env.prod_dbpasswd   =   "sdf"
                env.jailname        =   "sdf" 
                env.erppath         =   "$taskid"                                  
                env.training_host   =   "192.168.6.3"                    
                env.prod_host       =   "192.168.6.111"                                      
            break            
        }
    }
}
