properties( [
        buildDiscarder( logRotator( numToKeepStr: '15', artifactNumToKeepStr: '3') ),
        disableConcurrentBuilds(),
])

timestamps {
    timeout(time: 30, unit: 'MINUTES') {
        //environment variable needs to match the Tausight github credential in http://<Jenkins instance>/credentials/
        GIT_CREDENTIALS_ID = 'tausight-github-key-shermaneric'
        SLACK_CHANNEL='#jenkins'

        node('eric_test_node') {
            try {
                stage("Prep and Checkout SCM") {
                    deleteDir() // deleteDir ensures fresh checkouts of repos each time
                    checkout scm
                }
                stage("Update something") {
                    sh "echo \$(date) > myfile"
                }
                currentBuild.result = 'SUCCESS'
            } catch (e) {
                currentBuild.result = "FAILURE"
                println e
                error()
            } finally {
            }
        }
    }
}

def tagAndPush() {
    sshagent (credentials: [GIT_CREDENTIALS_ID]) {
        sh('git config user.email "shermaneric@gmail.com"')
        sh('git config user.name "Eric SHerman"')
        sh('git add --all')
        sh("git commit -m 'test push Jenkins'")
        sh('git push')
    }
}



