create table if not exists ecommerce.product  (
                                                  id INT PRIMARY KEY ,
                                                  name varchar(100) NOT NULL ,
    description text,
    image varchar(255),
    price float(5) NOT NULL,
    created_at timestamptz,
    updated_at timestamptz
    );

alter table ecommerce.products alter column id type bigint;

insert into ecommerce.products
(id, name, description, image, price, created_at, updated_at)
values(1,'T-Shirt','this is so cool', '', 123.45,'2023-07-22 01:08:25-00','2023-07-22 01:08:25-00');


create table if not exists ecommerce.categories(
                                                   id BIGINT PRIMARY KEY,
                                                   name varchar(100) NOT NULL,
    description text,
    created_at timestamptz,
    updated_at timestamptz
    );

alter table  ecommerce.products add column category_id bigint
    constraint cate_fk_product references ecommerce.categories(id);

insert into ecommerce.categories (id, name, description, created_at, updated_at)
values (1,'T-shirt','all kinds of T-shirt', '2023-07-23 01:08:25-00','2023-07-23 01:08:25-00');

update ecommerce.products set category_id = 1, name = 'BBC T-shirt' where ecommerce.products.id = 1;