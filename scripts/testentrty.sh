#!/bin/bash
date=$(date)
container=$(hostname)
echo container id is $container > /var/www/html/index.nginx-debian.html
echo date when container is build is $date >> /var/www/html/index.nginx-debian.html