CREATE TABLE carts (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   creation_date TIMESTAMP WITHOUT TIME ZONE,
   modified_date TIMESTAMP WITHOUT TIME ZONE,
   active BOOLEAN NOT NULL,
   total DECIMAL,
   shipment_cost DECIMAL,
   CONSTRAINT pk_cart PRIMARY KEY (id)
);