#!/usr/bin/bash

# Spins up Docker conatiner with official MySQL container
# @TODO: Mount sample date to DB with scripts (use `-v` to mount)

docker run --rm \
    --name mysql \
    -p 3306:3306 \
    -v /home/camdyn/Sandbox/simple-banking-app/tools:/repo/tools \
    -e MYSQL_ROOT_PASSWORD=password \
    mysql


## MySQL commonds of interest:
#   - mysql -u root -p
#   - `CREATE DATABASE $db_name`
#   - `USE $db_name`