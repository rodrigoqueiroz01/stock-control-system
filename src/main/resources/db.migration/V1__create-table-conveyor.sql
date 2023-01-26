CREATE TABLE public.conveyor
(
    id                        UUID         NOT NULL,
    name_conveyor             VARCHAR(255) NOT NULL,
    address_country           VARCHAR(2)   NOT NULL,
    address_state             VARCHAR(5)   NOT NULL,
    address_city              VARCHAR(100) NOT NULL,
    address_district          VARCHAR(255) NOT NULL,
    address_street            VARCHAR(255) NOT NULL,
    address_number            INTEGER      NOT NULL,
    address_complement        VARCHAR(100),
    address_reference         VARCHAR(255) NOT NULL,
    address_formatted_address VARCHAR(255) NOT NULL,
    address_postal_code       VARCHAR(9)   NOT NULL,
    data_cnpj                 VARCHAR(18)  NOT NULL,
    data_subscription         VARCHAR(100) NOT NULL,
    data_contact              VARCHAR(100) NOT NULL,
    data_telephone            VARCHAR(15)  NOT NULL,
    CONSTRAINT pk_conveyor PRIMARY KEY (id)
);