Simple project that up nginx inside container.  Nginx "welcome page" contains container_id and date. 

To build a project
docker build -t testnginx .

How to run:
docker run --rm -d -p 80:80 testnginx
