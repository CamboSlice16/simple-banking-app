FROM mysql

WORKDIR /home/banking

ENV MYSQL_ROOT_PASSWORD=password \
    MYSQL_USER=bank_user \
    MYSQL_PASSWORD=password \
    MYSQL_DATABASE=banking_database

COPY ./sql_scripts /docker_entrypoint-initdb.d

EXPOSE 3306