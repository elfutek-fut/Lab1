FROM mysql

ENV MYSQL_DATABASE="flowers-mysql"

COPY initial_data.sql /docker-entrypoint-initdb.d/