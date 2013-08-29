drop table racket_photo if exists;
drop table racket_comments if exists;
drop table racket if exists;
drop table racket_tag if exists;
drop table user_detail if exists;
drop table user_role if exists;
drop table user if exists;
drop table country if exists;
drop table brand_tag if exists;
drop table brand if exists;
drop table location_tag if exists;
drop table location if exists;
drop table level if exists;
drop table tag if exists;

create table tag(
	id integer identity primary key, 
	name varchar(50), 
	description varchar(2000),
	CONSTRAINT tag_name UNIQUE(name)
);

create table level(
	id integer identity primary key,
	name varchar(200),
	description varchar(2000),
	chi_description varchar(200),
	CONSTRAINT level_name UNIQUE (name)
);

create table location(
	id integer identity primary key,
	address varchar(2000) not null,
	google_map_url varchar(5000),
	phone varchar(10)	
);

create table location_tag(
	id integer identity primary key,
	location_id integer,
	tag_id integer,
	CONSTRAINT location_tag UNIQUE (location_id, tag_id),
	foreign key (location_id) references location(id),
	foreign key (tag_id) references tag(id)
);


create table brand(
	id integer identity primary key,
	brand_tag integer,
	name varchar(200),
	CONSTRAINT brand_name UNIQUE(name), 
	foreign key (brand_tag) references tag(id)
);

create table brand_tag(
	id integer identity primary key,
	brand_id integer,
	tag_id integer,
	CONSTRAINT brand_tag UNIQUE(brand_id, tag_id),
	foreign key (brand_id) references brand(id),
	foreign key (tag_id) references tag(id)
);

create table country(
	id integer identity primary key,
	name varchar(200),
	chi_name varchar(20)
);

create table user(
	id integer identity primary key, 
	user_name varchar(50) not null, 
	password varchar(50) not null, 
	CONSTRAINT unique_name UNIQUE(user_name)
);


create table user_role(
	id integer identity primary key, 
	user_id integer , 
	role varchar(50) not null,
	CONSTRAINT user_role_unique_key UNIQUE(user_id,role) , 
	foreign key (user_id) references user(id)
);

create table user_detail(
	id integer identity primary key, 
	user_id integer, 
	first_name varchar(50), 
	last_name varchar(50),
	nick_name varchar(50),
	icon varchar(2000), 
	email varchar(50), 
	level_id integer, 
	foreign key (level_id) references level(id)
);


create table racket(
	id integer,
	brand_id integer,
	code varchar(200),
	name varchar(200),
	balance_point double,
	frame varchar(200),
	shaft varchar(200),
	weight_tag integer,
	grip varchar(200),
	color varchar(200),
	country integer,
	remarks varchar(5000),
	PRIMARY KEY (ID),
	foreign key (country) references country(id),
	foreign key (brand_id) references brand(id),
	foreign key (weight_tag) references tag(id),
	CONSTRAINT racket_brand_name UNIQUE(brand_id,name),
	CONSTRAINT racket_brand_code UNIQUE(brand_id,code)
);

create table racket_tag(
	id integer,
	racket_id integer,
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT racket_tag UNIQUE(racket_id, tag_id),
	foreign key (racket_id) references racket(id),
	foreign key (tag_id) references tag(id)
);

