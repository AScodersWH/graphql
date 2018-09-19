CREATE table product(
    id int primary key auto_increment unique,
    name VARCHAR(255),
    price VARCHAR(255),
    `user_id` INTEGER,
    foreign key (user_id) references user(id)
);
