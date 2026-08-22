CREATE TABLE permissions (
                             id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                             name VARCHAR(100) NOT NULL,

                             key VARCHAR(50) NOT NULL,

                             description VARCHAR(255),

                             active BOOLEAN NOT NULL DEFAULT TRUE,

                             created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                             updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                             CONSTRAINT uk_permissions_key UNIQUE (key)
);

INSERT INTO permissions (
    name,
    key,
    description
)
VALUES
    (
        'Visualizar',
        'VIEW',
        'Permite visualizar o recurso'
    ),
    (
        'Criar',
        'CREATE',
        'Permite criar registros do recurso'
    ),
    (
        'Atualizar',
        'UPDATE',
        'Permite atualizar registros do recurso'
    ),
    (
        'Deletar',
        'DELETE',
        'Permite deletar registros do recurso'
    );