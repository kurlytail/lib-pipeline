

def call() {
    sh('cp -r jenkins jenkins-lib; cd jenkins-lib && rm -rf .git && git init && git add --all . && git config user.email test@test && git config user.name test && git commit -m init') 
    def repoPath = sh(returnStdout: true, script: 'pwd').trim() + "/jenkins-lib"
    sh "git ls-remote ${repoPath}"
    library identifier: 'local-lib@master', retriever: modernSCM([$class: 'GitSCMSource', remote: repoPath])
}
