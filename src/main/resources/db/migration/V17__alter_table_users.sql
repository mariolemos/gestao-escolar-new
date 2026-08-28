alter table users drop column role;

INSERT INTO public.users
(id, cpf, "password", "name", active, profile_id)
VALUES('a2b2f256-9368-4fae-8669-7966bca28940'::uuid, '85806128539', '$2a$10$OWCFTMPGNDEmstnRog2Zx.VAYxa47cdpQteXz0eT6xV7GcJsyqYSC', 'wagner cupertino lemos', true, 'a747e317-12b2-4e97-82ac-d583ea704141'::uuid);