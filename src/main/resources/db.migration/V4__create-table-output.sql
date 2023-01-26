CREATE TABLE public.output
(
    id          UUID NOT NULL,
    store_id    UUID,
    conveyor_id UUID,
    total       BYTEA,
    freight     BYTEA,
    tax         BYTEA,
    CONSTRAINT pk_output PRIMARY KEY (id)
);

ALTER TABLE public.output
    ADD CONSTRAINT FK_OUTPUT_ON_CONVEYOR FOREIGN KEY (conveyor_id) REFERENCES public.conveyor (id);

ALTER TABLE public.output
    ADD CONSTRAINT FK_OUTPUT_ON_STORE FOREIGN KEY (store_id) REFERENCES public.store (id);