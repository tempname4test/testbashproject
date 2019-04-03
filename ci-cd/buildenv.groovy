import groovy.json.JsonOutput

properties([
        disableConcurrentBuilds(),
        parameters([
            string(
                name: 'git_branch',
                defaultValue: 'add_dockerfile',
                description: 'which branch should be tested',
            )
        ])
])

node ('jenkins-master'){
    stage ("fetch repo") { 
        git branch: "${git_branch}",
        credentialsId: '21166286-7c40-48ae-a653-35f886acc509',
        url: "git@github.com:tempname4test/testbashproject.git" 
    }
    stage ("build and run container") { 
        dir("ansible"){
            sh """ ansible-playbook -i hosts ./test_configuration.yml  """  
        }
    }
    stage ("test") { 
        sh "curl 3.19.53.148" 
    }
}
