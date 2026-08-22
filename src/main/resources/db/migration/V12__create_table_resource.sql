CREATE TABLE resources (
                           id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                           name VARCHAR(100) NOT NULL,

                           key VARCHAR(100) NOT NULL,

                           description VARCHAR(255),

                           active BOOLEAN NOT NULL DEFAULT TRUE,

                           created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                           updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                           CONSTRAINT uk_resources_key UNIQUE (key)
);