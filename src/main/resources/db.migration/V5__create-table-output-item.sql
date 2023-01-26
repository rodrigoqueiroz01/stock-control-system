CREATE TABLE public.output_item
(
    id       UUID NOT NULL,
    batch    VARCHAR(255),
    quantity INTEGER,
    value    BYTEA,
    CONSTRAINT pk_outputitem PRIMARY KEY (id)
);