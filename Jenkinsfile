timestamps {
  timeout(time: var.timeoutTime, unit: var.timeoutUnit) {
    catchError {
      parallel(
        BPPDAV: {
          node('dockerclient-pivotal_jdk17') {

            stage('init') {
              PreInit()
              NotifyStash()
              GitCheckout(gitUrl: 'ssh://git@stash.trusted.visa.com:7999/CM/webframe.git')
              def BV_DEVELOP = 'CYBS_Snapshot'
              def BV_RELEASE = 'CYBS_Release'
              setProperties(
                BV_DEVELOP: BV_DEVELOP,
                BV_RELEASE: BV_RELEASE,
                PACKAGE_TYPE: 'library',
                JIRA_PROJECT_KEY: 'ALTP'
              )
              CheckoutCmtools()
              InitMaven()
              CheckoutDeployment()
              PostInit()
            }

            try {

              stage('compile_and_test') { //To pass a flag, add parameter, flag: '<flag>'
                PreCompileTest()
                GitMvnInstallDeploy()
                GitRunSonar()
                PostCompileTest()
              }
            } catch (err) {
              NotifyStash(state: "FAILED")
              log.error("$err")
              sh 'exit 1'
            } finally {
              generateSurefireReport()
            }

            NotifyStash(state: "SUCCESS")
            parallel (
              nexusiq : {
                stage('nexusiq') {
                  nexusiq(
                    appName: '0063798_ALTP',
                    appId: '0063798_ALTP',
                    organizationName: '', // PD TEAM TODO: obtain from https://visawiki.trusted.visa.com/pages/viewpage.action?spaceKey=releng&title=Nexus+IQ+integration+with+Jenkins
                    //OPTIONAL: excludes: '',
                    //OPTIONAL: inclues: '', // defaults to: **/*.jar, **/*.war, **/*.ear, **/*.zip, **/*.tar.gz
                    featureBranchScan: false // set to true to run scans on feature branches
                  )
                }
              },
              blackduck: {
                stage('blackduck') {
                  blackduck(
                    cd: 'package',
                    SHORT_NAME: 'ALTP',
                    ASKNOW_ID: '0063798',
                    ARCHIVE_TYPE: 'jar',
                    STATE: 'ON'
                  )
                }
              }
            )
          }
        },

        CHECKMARX: {
          node('dockerclient-pivotal_jdk17') {
            stage('checkmarx') {
              GitCheckout(gitUrl: 'ssh://git@stash.trusted.visa.com:7999/CM/webframe.git')
              runCheckmarxScan(
                projectName: 'ALTP_0063798',
                preset: '100018', groupId: '{CHECKMARX_GROUPID}',
                excludeFolders: '*test*,package,tcserver,veracode-upp,utilities,tokenvaluefiles,grails-app'
              )
            }

          }
        }
      )

    }

    node('utils') {
      buildFinally()
    }

  }
}

