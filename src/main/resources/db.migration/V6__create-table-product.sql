CREATE TABLE public.product
(
    id            UUID             NOT NULL,
    provider_id   UUID,
    description   VARCHAR(255)     NOT NULL,
    weight        DOUBLE PRECISION NOT NULL,
    controlled    BOOLEAN          NOT NULL,
    min_quantity  INTEGER          NOT NULL,
    category_type VARCHAR(100)     NOT NULL,
    product_id    UUID,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

ALTER TABLE public.product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES entry_item (id);

ALTER TABLE public.product
    ADD CONSTRAINT FK_PRODUCT_ON_PRODUCTl2EoOa FOREIGN KEY (product_id) REFERENCES public.output_item (id);

ALTER TABLE public.product
    ADD CONSTRAINT FK_PRODUCT_ON_PROVIDER FOREIGN KEY (provider_id) REFERENCES public.provider (id);