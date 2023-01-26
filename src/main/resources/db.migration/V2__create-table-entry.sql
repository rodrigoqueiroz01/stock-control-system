CREATE TABLE public.entry
(
    id          UUID NOT NULL,
    conveyor_id UUID,
    order_entry TIMESTAMP WITHOUT TIME ZONE,
    date_entry  TIMESTAMP WITHOUT TIME ZONE,
    total       BYTEA,
    freight     BYTEA,
    number_nf   INTEGER,
    tax         BYTEA,
    CONSTRAINT pk_entry PRIMARY KEY (id)
);

ALTER TABLE public.entry
    ADD CONSTRAINT FK_ENTRY_ON_CONVEYOR FOREIGN KEY (conveyor_id) REFERENCES public.conveyor (id);