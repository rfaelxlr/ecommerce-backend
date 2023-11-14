CREATE TABLE customers (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   name VARCHAR(255),
   email VARCHAR(255),
   password VARCHAR(255),
   creation_date TIMESTAMP WITHOUT TIME ZONE,
   modified_date TIMESTAMP WITHOUT TIME ZONE,
   active BOOLEAN NOT NULL,
   ddd VARCHAR(2),
   phone VARCHAR(9),
   identifier VARCHAR(11),
   birth_date date,
   receive_emails BOOLEAN NOT NULL,
   receive_sms BOOLEAN NOT NULL,
   receive_whatsapp BOOLEAN NOT NULL,
   CONSTRAINT pk_customers PRIMARY KEY (id)
);

ALTER TABLE customers ADD CONSTRAINT uc_customers_email UNIQUE (email);