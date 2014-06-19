drop database cb_chaos;
create database cb_chaos;
use cb_chaos;
create table tag(
	id integer, 
	name varchar(50), 
	description varchar(2000),
	PRIMARY KEY (id),
	CONSTRAINT tag_name UNIQUE(name)
);

create table tag_group(
	id integer, 
	
	name varchar(200),
	PRIMARY KEY (id),
	CONSTRAINT group_name UNIQUE(name)
);

create table tag_group_list(
	id integer,
	tag_group_id integer, 
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT tag_group UNIQUE (tag_group_id,tag_id)
);

	
create table country(
	id integer,
	name varchar(200),
	chi_name varchar(20),
	PRIMARY KEY (id)
);

create table level(
	id integer,
	name varchar(200),
	description varchar(2000),
	chi_description varchar(200),
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT level_name UNIQUE (name)
);

create table level_tag(
	id integer,
	level_id integer,
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT level_tag UNIQUE (level_id, tag_id),
	foreign key (level_id) references level(id),
	foreign key (tag_id) references tag(id)
);

create table location(
	id integer,
	name varchar(2000) not null,
	address varchar(2000) not null,
	google_map_url varchar(5000),
	phone varchar(10),
	PRIMARY KEY (id)
);

create table location_tag(
	id integer,
	location_id integer,
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT location_tag UNIQUE (location_id, tag_id),
	foreign key (location_id) references location(id),
	foreign key (tag_id) references tag(id)
);

create table brand(
	id integer,
	name varchar(200),
	logo varchar(2000),
	PRIMARY KEY (id),
	CONSTRAINT brand_name UNIQUE(name)
);

create table brand_tag(
	id integer,
	brand_id integer,
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT brand_tag UNIQUE(brand_id, tag_id),
	foreign key (brand_id) references brand(id),
	foreign key (tag_id) references tag(id)
);


create table racket(
	id integer,
	brand_id integer,
	code varchar(200),
	name varchar(200),
	balance_point double,
	frame varchar(200),
	shaft varchar(200),
	weight varchar(200),
	grip varchar(200),
	color varchar(200),
	remarks varchar(5000),
	PRIMARY KEY (ID),
	foreign key (brand_id) references brand(id),
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


create table user(
	id integer, 
	user_name varchar(50) not null, 
	password varchar(50) not null,
	first_name varchar(2000),
	last_name varchar(2000),
	nick_name varchar(2000),
	icon varchar(2000),
	email varchar(50) not null,
	level_id integer,
	create_dtm timestamp null,
	last_update_dtm timestamp not null default current_timestamp,
	PRIMARY KEY (id),
	foreign key (level_id) references level(id),
	CONSTRAINT unique_name UNIQUE(user_name),
	CONSTRAINT email UNIQUE(email)
);

create table user_tag(
	id integer,
	user_id integer,
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT user_tag UNIQUE(user_id, tag_id),
	foreign key (user_id) references user(id),
	foreign key (tag_id) references tag(id)
);

create table user_role(
	id integer, 
	user_id integer , 
	role varchar(50) not null,
	PRIMARY KEY (id),
	CONSTRAINT user_role_unique_key UNIQUE(user_id,role) , 
	foreign key (user_id) references user(id)
);


create table event(
	id integer,
	date date,
	location_id integer,
	level_id integer,
	public_event bit,
	status integer,
	game_type int, 
	max_participant integer,
	remark varchar(2000),
	creator_id integer,
	create_date timestamp,
	PRIMARY KEY (id),
	INDEX location_index (location_id),
	foreign key (location_id) references location(id),
	foreign key (level_id) references level(id),
	foreign key (creator_id) references user(id)
	
);

create table event_details(
	id integer,
	event_id integer,
	court_no integer,
	start_time timestamp,
	end_time timestamp,
	PRIMARY KEY (id),
	foreign key (event_id) references event(id)
);

create table event_tag(
	id integer,
	event_id integer,
	tag_id integer,
	PRIMARY KEY (id),
	CONSTRAINT event_tag UNIQUE(event_id, tag_id),
	foreign key (event_id) references event(id),
	foreign key (tag_id) references tag(id)
);

create table event_admin(
	id integer,
	event_id integer,
	user_id integer,
	update_dtm timestamp default current_timestamp,
	PRIMARY KEY (id),
	foreign key (user_id) references user(id),
	foreign key (event_id) references event(id),
	CONSTRAINT event_admin UNIQUE(event_id,user_id)
);

create table event_invitee(
	id integer,
	event_id integer,
	user_id integer,
	email varchar(200),
	status integer DEFAULT NULL,
	PRIMARY KEY (id),
	foreign key (user_id) references user(id),
	foreign key (event_id) references event(id),
	CONSTRAINT event_invitee UNIQUE(event_id, user_id)
);

create table event_participant(
	id integer,
	event_id integer,
	user_id integer,
	PRIMARY KEY (id),
	foreign key (user_id) references user(id),
	foreign key (event_id) references event(id),
	CONSTRAINT event_participant UNIQUE(event_id, user_id)
);

