def call(){
      sh '''
      #!/bin/bash
      ~/store-venv/bin/python3 -m pip install -r $backend_path/store/requirements.txt
      nohup ~/store-venv/bin/python3 $backend_path/store/app.py &
      '''
}
