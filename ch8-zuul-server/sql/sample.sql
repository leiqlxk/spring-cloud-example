create table zuul_route(
       id bigint(19) primary key auto_increment,
       path varchar(64),
       service_id varchar(32),
       url varchar(64),
       strip_prefix varchar(32),
       retryable int(1),
       enabled int(1),
       description varchar(64)
)