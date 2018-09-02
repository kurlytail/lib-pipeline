

def call() {
// sh('cp -r jenkins jenkins-lib; cd jenkins-lib && rm -rf .git && git init && git add --all . && git commit -m init &> /dev/null') 
    def repoPath = sh(returnStdout: true, script: 'pwd').trim() + "/jenkins"
    library identifier: 'local-lib@master', retriever: modernSCM([$class: 'GitSCMSource', remote: repoPath])
}
