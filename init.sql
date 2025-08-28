-- Grant permissions to the yu71 user from any host
CREATE
USER IF NOT EXISTS 'yu71'@'%' IDENTIFIED BY '53cret';
GRANT ALL PRIVILEGES ON movie_reservation.* TO
'yu71'@'%';
FLUSH
PRIVILEGES;