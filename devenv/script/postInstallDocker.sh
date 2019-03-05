#!/bin/sh
set -eu

# create convenience script for listing running docker containers
cat <<EOF > "/home/vagrant/listContainers.sh"
#!/bin/sh
set -eu -o pipefail

docker ps --all --format 'table {{.ID}}\t{{.Names}}\t{{.CreatedAt}}\t{{.Status}}\t{{.Size}}'

EOF

chmod +x "/home/vagrant/listContainers.sh"

# use this for additional tasks after docker start
