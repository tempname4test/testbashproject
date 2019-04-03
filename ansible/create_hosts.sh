#!/bin/bash
ip=$1
sed "s/HostIP/$ip/g" hosts_template > hosts