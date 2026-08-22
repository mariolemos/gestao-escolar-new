CREATE TABLE profile_resource_permissions (
                                                profile_resource_id UUID NOT NULL,

                                                permission_id UUID NOT NULL,

                                                created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

                                                CONSTRAINT pk_profile_resource_permissions
                                                    PRIMARY KEY (
                                                                 profile_resource_id,
                                                                 permission_id
                                                        ),

                                                CONSTRAINT fk_prp_profile_resource
                                                    FOREIGN KEY (profile_resource_id)
                                                        REFERENCES profile_resources (id)
                                                        ON DELETE CASCADE,

                                                CONSTRAINT fk_prp_permission
                                                    FOREIGN KEY (permission_id)
                                                        REFERENCES permissions (id)
  );