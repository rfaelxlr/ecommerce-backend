CREATE TABLE IF NOT EXISTS categories (
                id BIGSERIAL NOT NULL,
                creation_date timestamp without time zone,
                modified_date timestamp without time zone,
                active BOOLEAN,
                name VARCHAR(255),
                CONSTRAINT category_id_pk PRIMARY KEY (id)
);