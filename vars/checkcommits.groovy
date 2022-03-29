def call() {
         script {
             sh '''
             cd ~/$erppath/$folder
             git fetch
             C=`git rev-list HEAD...origin/feature/Saideepa --count`
             echo -e "$C" > ~/$erppath/commitcount
             '''
         }
}
