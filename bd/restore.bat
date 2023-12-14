set PGPASSWORD=postgres123
cd bd
pg_restore.exe -c --host localhost --port 5432 --username "postgres" --dbname "vmcdb" --verbose --no-password "bkp.sql"