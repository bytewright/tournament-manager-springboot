#!/bin/sh
set -eu

echo "starting docker containers"
cd /vagrant/docker
/usr/local/bin/docker-compose pull
/usr/local/bin/docker-compose up -d
echo "start docker done"
