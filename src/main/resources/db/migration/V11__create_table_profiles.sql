CREATE TABLE profiles (
                          id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                          name VARCHAR(100) NOT NULL,

                          key VARCHAR(100) NOT NULL,

                          description VARCHAR(255),

                          active BOOLEAN NOT NULL DEFAULT TRUE,

                          created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                          updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                          CONSTRAINT uk_profiles_key UNIQUE (key)
);

INSERT INTO profiles (
    name,
    key,
    description,
    active
)
VALUES (
           'ADMIN',
           'ADMIN',
           'Perfil de administrador do sistema',
           TRUE
       );