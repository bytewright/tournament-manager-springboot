#!/bin/sh
set -eu

echo "install docker start"
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/ubuntu $(lsb_release -cs) stable"
sudo apt-get update
apt-cache policy docker-ce
sudo apt-get install -y docker-ce

#enable docker REST api
DOCKER_API_PORT=$1
echo "enabling docker REST API on port $DOCKER_API_PORT"
sudo sed -r -i.bak "s|ExecStart=(.*)|& -H tcp://0.0.0.0:$DOCKER_API_PORT -H unix:///var/run/docker.sock|" /lib/systemd/system/docker.service

sudo systemctl daemon-reload
sudo systemctl enable docker
sudo systemctl start docker
sudo curl -s -L https://github.com/docker/compose/releases/download/1.21.2/docker-compose-`uname -s`-`uname -m` -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose

#sudo echo "PATH=${PATH}:/usr/local/bin/" >> /root/.bashrc
sudo usermod -aG docker vagrant

echo "install docker done"
