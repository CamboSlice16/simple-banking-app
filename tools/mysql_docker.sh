#!/usr/bin/bash

# Spins up Docker conatiner with official MySQL container
# @TODO: Mount sample date to DB with scripts (use `-v` to mount)

docker run --rm \
    --name mysql-db \
    -p 3307:3306 \
    -e MYSQL_ROOT_PASSWORD=password \
    mysql


## MySQL commonds of interest:
#   - `CREATE DATABASE $db_name`
#   - `USE $db_name`