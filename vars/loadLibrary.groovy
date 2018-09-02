

def call() {
    sh('cd jenkins && rm -rf .git && git init && git add --all . && git commit -m init &> /dev/null') 
    def repoPath = sh(returnStdout: true, script: 'pwd').trim() + "/jenkins"
    library identifier: 'local-lib@master', retriever: modernSCM([$class: 'GitSCMSource', remote: repoPath])
}
