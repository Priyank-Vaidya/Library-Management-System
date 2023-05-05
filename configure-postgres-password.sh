#!/bin/bash
#Version 1.0.0
#--------------------------------------------
#Name: Priyank Vaidya
#Project: CloudScale Library Managemet System Assignment
#--------------------------------------------

#This is the script to configure the postgres password and database while running the container
#Please ensure that the Password is stored as an environment variable by using
# ENV POSTGRES_PASSWORD=<password> in the VM Instance running

#{ VM Instance > Run the Postgres Image-File > Run the Application Container } -----> Containerized Application


set -e

echo "Configuring PostgreSQL password..."

psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
    ALTER USER postgres PASSWORD '$POSTGRES_PASSWORD';
EOSQL

echo "PostgreSQL password configured!"