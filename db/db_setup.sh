#!/usr/bin/bash

export MYSQL_ROOT="root"
export MYSQL_PASS="password"

mysql -u ${MYSQL_ROOT} -p ${MYSQL_PASS} "CREATE DATABASE banking_database"
mysql -u ${MYSQL_ROOT} -p ${MYSQL_PASS} "$(cat /repo/tools/sql/schema.sql)"
mysql -u ${MYSQL_ROOT} -p ${MYSQL_PASS} "$(cat /repo/tools/sql/data.sql)"