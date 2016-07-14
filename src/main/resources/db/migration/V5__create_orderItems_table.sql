CREATE TABLE orderItems (
  order_id VARCHAR(255) UNIQUE,
  product_id VARCHAR(255) NOT NULL,
  quantity INTEGER,
  amount DOUBLE,
  FOREIGN KEY (order_id) REFERENCES orders(id) ON DELETE SET NULL,
  FOREIGN KEY (product_id) REFERENCES products(id)
);

