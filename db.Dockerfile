FROM postgres
ENV POSTGRES_PASSWORD password
ENV POSTGRES_DB spring
COPY db/init.sql /docker-entrypoint-initdb.d/