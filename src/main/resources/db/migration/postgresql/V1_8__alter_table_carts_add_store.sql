ALTER TABLE carts ADD COLUMN store_id BIGINT;

ALTER TABLE carts ADD CONSTRAINT FK_CARTS_ON_STORE FOREIGN KEY (store_id) REFERENCES stores (id);