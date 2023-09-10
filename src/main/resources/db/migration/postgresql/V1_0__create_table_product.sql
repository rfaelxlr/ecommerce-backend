CREATE TABLE IF NOT EXISTS products (
                id BIGSERIAL NOT NULL,
                creation_date timestamp without time zone,
                modified_date timestamp without time zone,
                active BOOLEAN,
                name VARCHAR(255),
                ean VARCHAR(13),
                price DOUBLE PRECISION,
                CONSTRAINT product_id_pk PRIMARY KEY (id)
);