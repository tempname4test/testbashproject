import groovy.json.JsonOutput

properties([
        disableConcurrentBuilds(),
        parameters([
            string(
                name: 'server_ip',
                defaultValue: '3.19.53.148',
                description: 'fresh ubuntu 16 ip',
            ),
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

    stage ("add server ip to ansible hosts file") { 
        dir("ansible"){
            sh """ sed "s/HostIP/$server_ip/g" hosts_template > hosts """ 
        } 
    }
    stage ("build and run container") { 
        dir("ansible"){
            sh """ eval `ssh-agent -s` && ssh-add ~/.ssh/tmp_key && ansible-playbook -i hosts ./test_configuration.yml  """  
        }
    }
    stage ("test") { 
        sh " curl ${server_ip}" 
    }
}
