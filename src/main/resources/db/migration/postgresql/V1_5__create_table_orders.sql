CREATE TABLE "orders" (
  id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
   creation_date TIMESTAMP WITHOUT TIME ZONE,
   modified_date TIMESTAMP WITHOUT TIME ZONE,
   active BOOLEAN NOT NULL,
   status VARCHAR(50),
   shipment_date TIMESTAMP WITHOUT TIME ZONE,
   delivery_date TIMESTAMP WITHOUT TIME ZONE,
   cart_id BIGINT,
   CONSTRAINT pk_order PRIMARY KEY (id)
);

ALTER TABLE "orders" ADD CONSTRAINT FK_ORDER_ON_CART FOREIGN KEY (cart_id) REFERENCES carts (id);