CREATE TABLE entry_item
(
    id       UUID NOT NULL,
    entry_id UUID,
    batch    VARCHAR(255),
    quantity INTEGER,
    value    BYTEA,
    CONSTRAINT pk_entryitem PRIMARY KEY (id)
);

ALTER TABLE entry_item
    ADD CONSTRAINT FK_ENTRYITEM_ON_ENTRY FOREIGN KEY (entry_id) REFERENCES public.entry (id);