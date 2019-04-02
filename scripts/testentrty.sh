#!/bin/bash
date=$(date)
container=$(hostname)
echo container id is $container > /var/www/html/index.nginx-debian.html
echo date when you start the $date >> /var/www/html/index.nginx-debian.html