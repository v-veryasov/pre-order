CREATE ROLE auth WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    CREATEDB
    CREATEROLE
    NOREPLICATION
    ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:lx+M0qd+9+Xd73bSl4FqGA==$N0VB/0h4X5ISIWifyE6fq3voeGPA7n2z+7qekW31QU8=:fenJgxBDmt5Idv0S7hd3WezNczijZHDzjTQlp8haJMY=';

CREATE DATABASE "pre-order-auth"
    WITH
    OWNER = auth
    ENCODING = 'UTF8'
--     LC_COLLATE = 'English_United States.1252'
--     LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE ROLE booking WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    CREATEDB
    CREATEROLE
    NOREPLICATION
    ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:EZVYLsu1DV3yY2aWL2Vkkw==$JdZiwSmMkTnxNaUujwUgkFRTlDStlZ2NCvwqZ5yKu+U=:YXDtucOobXJ1Z9mdBFtsi94RP449pNbVYyky+nCxXEc=';

CREATE DATABASE "pre-order-booking"
    WITH
    OWNER = booking
    ENCODING = 'UTF8'
--     LC_COLLATE = 'English_United States.1252'
--     LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;

CREATE ROLE profile WITH
    LOGIN
    NOSUPERUSER
    INHERIT
    CREATEDB
    CREATEROLE
    NOREPLICATION
    ENCRYPTED PASSWORD 'SCRAM-SHA-256$4096:mr0brelWvYOgRWLImzijSQ==$KQi9yoy6fQeph5OtsqbgeWLcRT5/RIu6DSL7B+j/pbU=:U82OfkcSzP2HltIFdO3/aR5NegXu6bjY/9njEUd4rHI=';

CREATE DATABASE "pre-order-profile"
    WITH
    OWNER = profile
    ENCODING = 'UTF8'
--     LC_COLLATE = 'English_United States.1252'
--     LC_CTYPE = 'English_United States.1252'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1;