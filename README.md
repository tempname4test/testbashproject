Simple project that up nginx inside container.  Nginx "welcome page" contains container_id and container creation date. 

To change welcome page, you need to modify:
scripts/testentrty.sh

Deploy process is based on Ansible. Expected that you have clean Ubuntu server (Ubuntu 16) and connection by ssh key (without password) like on AWS.
Ansible do the following steps:
- install python (needed for Ansible functioning)
- install basic soft (Docker)
- copy files for building containers
- build new container
- run container
- make test (curl request)
Currently IP for build server is hardcoded in hosts file. If you want make build on  another server, please change the ip in "ansible/hosts" file

Deployment process is wrapped into Jenins pipeline file (ci-cd/buildenv.groovy)


To build project for local test, please use the following command:
docker build -t testnginx .
Run created container:
docker run --rm -d -p 80:80 testnginx
Test container:
curl 127.0.0.1
