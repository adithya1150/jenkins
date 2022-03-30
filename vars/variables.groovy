
def call() {
    script{
       switch(env.Instance) {
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
                env.folder          =   "sdwot"
                env.prod_dbuser     =   "jaya"
                env.prod_dbpasswd   =   "jaya"
                env.prod_hostname   =   "jaya"
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"  
                env.apache_path     =   "/etc/httpd/conf.d"                    
                env.ip              =   "192.168.181.248"
                env.apache_host     =   "192.168.181.253"
                env.public_ip       =   "14.97.205.78"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"
            break
            case 'saideepat':
                env.prod_db         =   "saideepa" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "saideepa"
                env.prod_dbpasswd   =   "saideepa"
                env.prod_hostname   =   "saideepa"                      
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"                
                env.apache_path     =   "/etc/httpd/conf.d"
                env.ip              =   "192.168.181.249"                    
                env.apache_host     =   "192.168.181.253"                    
                env.public_ip       =   "14.97.205.78"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"
            break
            case 'jayat':
                env.prod_db         =   "jaya"
                env.folder          =   "sdwot"
                env.prod_dbuser     =   "jaya"
                env.prod_dbpasswd   =   "jaya"
                env.prod_hostname   =   "jaya"              
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"
                env.apache_path     =   "/etc/httpd/conf.d"
                env.ip              =   "192.168.181.248"                    
                env.apache_host     =   "192.168.181.253"                    
                env.public_ip       =   "14.97.205.78"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"
            break
            case 'drilltecht':
                env.prod_db         =   "drilltech"
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "drilltech"
                env.prod_dbpasswd   =   "drilltech"                  
                env.jailname        =   "drilltech"                 
                env.training_host   =   "192.168.181.252"                    
                env.prod_host       =   "192.168.181.222"
                env.apache_path     =   "/etc/httpd/conf.d"
                env.ip              =   "192.168.181.247"                   
                env.apache_host     =   "192.168.181.253"                    
                env.public_ip       =   "14.97.205.78"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"           
            break
            case 'rockbitt':
                env.prod_db         =   "rockbit" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "rockbit"
                env.prod_dbpasswd   =   "rockbit"  
                env.jailname        =   "rockbit"                                 
                env.ip              =   "192.168.181.246"
                env.training_host   =   "192.168.181.252"
                env.apache_path     =   "/etc/httpd/conf.d"
                env.ip              =   "192.168.181.246"                   
                env.apache_host     =   "192.168.181.253"                    
                env.public_ip       =   "14.97.205.78"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"
            break
            case 'rocktect':
                env.prod_db         =   "rocktec" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "rocktec"
                env.prod_dbpasswd   =   "rocktec"                                 
                env.training_host   =   "192.168.6.3"                    
                env.prod_host       =   "192.168.6.111"
                env.apache_path     =   "/usr/local/etc/apache24/extra"
                env.ip              =   "192.168.6.254"
                env.apache_host     =   "192.168.6.111"
                env.public_ip       =   "14.97.148.62"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"
            break
            case 'cenergt':
                env.prod_db         =   "c2_prod" 
                env.folder          =   "cenerg"
                env.prod_dbuser     =   "cenerg"
                env.prod_dbpasswd   =   "cenerg"
                env.jailname        =   "cenerg"                                  
                env.training_host   =   "192.168.6.3"                    
                env.prod_host       =   "192.168.6.111"
                env.apache_path     =   "/usr/local/etc/apache24/extra"                    
                env.ip              =   "192.168.6.245"
                env.apache_host     =   "192.168.6.111"
                env.public_ip       =   "14.97.148.62"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/cenerg.git"           
            break
            case 'sdforgingt':
                env.prod_db         =   "sdforging" 
                env.folder          =   "saideepa"
                env.prod_dbuser     =   "sdf"
                env.prod_dbpasswd   =   "sdf"
                env.jailname        =   "sdf"                                   
                env.training_host   =   "192.168.6.3"                    
                env.prod_host       =   "192.168.6.111" 
                env.apache_path     =   "/usr/local/etc/apache24/extra"                    
                env.ip              =   "192.168.6.239"                
                env.apache_host     =   "192.168.6.111"
                env.public_ip       =   "14.97.148.62"
                env.url             =   "ssh://git@phabricator.sdwot.ai:2223/source/saideepa.git"  
            break            
        }
    }
}


