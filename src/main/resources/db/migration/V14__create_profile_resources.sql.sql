CREATE TABLE profile_resources (
                                   id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

                                   profile_id UUID NOT NULL,

                                   resource_id UUID NOT NULL,

                                   created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                   CONSTRAINT fk_profile_resources_profile
                                       FOREIGN KEY (profile_id)
                                           REFERENCES profiles (id),

                                   CONSTRAINT fk_profile_resources_resource
                                       FOREIGN KEY (resource_id)
                                           REFERENCES resources (id),

                                   CONSTRAINT uk_profile_resource
                                       UNIQUE (profile_id, resource_id)
);