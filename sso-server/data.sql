create table `t_user`
(
    `id` bigint(20) not null auto_increment,
    `user_name` varchar(255) not null,
    `pass_word` varchar(255) not null,
    primary key (`id`) using btree
) engine = innodb auto_increment = 1 default charset = utf8;

create table `t_role`
(
    `id` bigint(20) not null auto_increment,
    `user_name` varchar(255) not null,
    `role` varchar(255) not null,
    primary key (`id`) using btree
) engine = innodb auto_increment = 1 default charset = utf8;