import groovy.json.JsonOutput

properties([
        disableConcurrentBuilds(),
        parameters([
            string(
                name: 'server_ip',
                defaultValue: '3.19.53.148',
                description: 'fresh ubuntu 16 ip',
            )
        ])
])

node ('jenkins-master'){
    stage ("add server ip to ansible hosts file") { 
        dir("ansible"){
            sh """ echo '[testdeployment]' > ansible/hosts""" 
            sh """ echo testhostname ansible_host=${server_ip} >> ansible/hosts"""
        } 
    }
    stage ("build and run container") { 
        dir("ansible"){
            sh """ ansible-playbook -i hosts ./test_configuration.yml """ 
        }
    }
    stage ("test") { 
        sh " curl ${server_ip}" 
    }
}
