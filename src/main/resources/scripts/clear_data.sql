-- Здесь должен быть скрипт, чистящий таблицы vacancy и employer с учетом внешних ключей
TRUNCATE vacancy RESTART IDENTITY CASCADE;
TRUNCATE employer RESTART IDENTITY CASCADE;
