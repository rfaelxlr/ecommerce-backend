ALTER TABLE carts
ADD COLUMN customer_id BIGINT;


ALTER TABLE carts ADD CONSTRAINT FK_CARTS_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);

