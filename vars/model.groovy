def call (){
        sh '''
        #!/bin/bash
        cd $backend_path/model
        ~/model-venv/bin/python3 -m pip install -r $backend_path/model/requirements.txt        
        nohup ~/model-venv/bin/python3 app.py &
        '''
}
