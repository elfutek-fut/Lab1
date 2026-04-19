FROM postgres

ENV POSTGRES_DB="flowers-postgres"

COPY init.sql /docker-entrypoint-initdb.d/