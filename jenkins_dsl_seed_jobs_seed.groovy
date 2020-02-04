job('Seed_Prod-Jenkins-Job-Generator') {
    
    wrappers {
        preBuildCleanup()
    }
    
    scm {
        git {
          remote {
            name('origin')
            url('git@github.com:shermaneric/jenkins_dsl_main.git')
            credentials('jenkins_shermandemo_com_private_ssh_key')
            branch('origin/master')
          }
        }
    }
    steps {//process main jobs
        dsl {
            external 'lp_prod_jenkins/current_gen/**/*'
            additionalClasspath 'src'
        }
    }
    steps {//process next_gen jobs
        dsl {
            external 'lp_prod_jenkins/next_gen/**/*'
            additionalClasspath 'src'
        }
    }
    steps {//process seed_job
        dsl {
            external 'lp_prod_jenkins/seed_job/**/*'
            additionalClasspath 'src'
        }
    }

    triggers
      {
        cron("0 */4 * * *")
      }
}