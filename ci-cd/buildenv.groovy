import groovy.json.JsonOutput

properties([
        disableConcurrentBuilds(),
        parameters([
            string(
                name: 'server_ip',
                description: 'fresh ubuntu 16 ip',
            )
        ])
])

node ('jenkins-master'){
    // try {
        echo "clone CICD repo and latest changes"
}
