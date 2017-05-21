The only 2 folders to use:
    - src : compiler source with jflex and cup
    - tests : contains test files

makeAll.sh and run.sh run in Unix

to create a compilater :
    - go to /src
    - execute command: 
    
        source MakeAll.sh

to test the compilater :
    - alsways go to folder /src to compile a file by typing :
    
        source run.sh -gen ../tests/file.js
        
    - for help :
        source run.sh -help
