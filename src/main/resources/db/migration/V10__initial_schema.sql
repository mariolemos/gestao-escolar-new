CREATE TABLE users (
                       id UUID PRIMARY KEY,
                       cpf VARCHAR(11) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       name VARCHAR(150) NOT NULL,
                       role VARCHAR(20) NOT NULL,
                       active BOOLEAN
);

CREATE TABLE drivers (
                         id UUID PRIMARY KEY,
                         user_id UUID NOT NULL,
                         cnh VARCHAR(20),
                         phone VARCHAR(20)
);

CREATE TABLE vehicles (
                          id UUID PRIMARY KEY,
                          plate VARCHAR(10),
                          model VARCHAR(100),
                          capacity INTEGER,
                          active BOOLEAN
);

CREATE TABLE locations (
                           id UUID PRIMARY KEY,
                           vehicle_id UUID,
                           latitude DOUBLE PRECISION,
                           longitude DOUBLE PRECISION,
                           speed DOUBLE PRECISION,
                           created_at TIMESTAMP
);