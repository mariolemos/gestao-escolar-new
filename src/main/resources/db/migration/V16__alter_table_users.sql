ALTER TABLE users
    ADD COLUMN profile_id UUID;

ALTER TABLE users
    ADD CONSTRAINT fk_users_profile
        FOREIGN KEY (profile_id)
            REFERENCES profiles (id);

CREATE INDEX idx_users_profile_id
    ON users (profile_id);