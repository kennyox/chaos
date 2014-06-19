rollback;
insert into tag (id,name,description) values (1,'NT','NT');
insert into tag (id,name,description)  values (2,'KL','KL');
insert into tag (id,name,description)  values (3,'HK','HK');
insert into tag (id,name,description)  values (4,'gosen','gosen');
insert into tag (id,name,description)  values (5,'wilson','wilson');
insert into tag (id,name,description)  values (6,'lining','li ning');
insert into tag (id,name,description)  values (7,'yonex','yonex');
insert into tag (id,name,description)  values (8,'racket','racket');
insert into tag (id,name,description)  values (9,'shuttlecock','shuttlecock');
insert into tag (id,name,description)  values (10,'2U','2U');
insert into tag (id,name,description)  values (11,'3U','3U');
insert into tag (id,name,description)  values (12,'4U','4U');
insert into tag (id,name,description)  values (13,'5U','5U');
insert into tag (id,name,description)  values (14,'3G','3G');
insert into tag (id,name,description)  values (15,'4G','4G');
insert into tag (id,name,description)  values (16,'大圍','大圍');
insert into tag (id,name,description)  values (17,'荃灣','荃灣');
insert into tag (id,name,description)  values (18,'沙田','沙田');
insert into tag (id,name,description)  values (19,'新手','新手');
insert into tag (id,name,description)  values (20,'高手','高手');

insert into tag_group (id, name) values (1, "location");
insert into tag_group (id, name) values (2, "weight");
insert into tag_group (id, name) values (3, "grip size");
insert into tag_group (id, name) values (4, "brand name");
insert into tag_group (id, name) values (5, "level");

insert into tag_group_list (id, tag_group_id, tag_id) values (1,1,1);
insert into tag_group_list (id, tag_group_id, tag_id) values (2,1,2);
insert into tag_group_list (id, tag_group_id, tag_id) values (3,1,3);
insert into tag_group_list (id, tag_group_id, tag_id) values (4,1,16);
insert into tag_group_list (id, tag_group_id, tag_id) values (5,1,17);
insert into tag_group_list (id, tag_group_id, tag_id) values (6,1,18);
insert into tag_group_list (id, tag_group_id, tag_id) values (7,2,10);
insert into tag_group_list (id, tag_group_id, tag_id) values (8,2,11);
insert into tag_group_list (id, tag_group_id, tag_id) values (9,2,12);
insert into tag_group_list (id, tag_group_id, tag_id) values (10,2,13);
insert into tag_group_list (id, tag_group_id, tag_id) values (11,3,14);
insert into tag_group_list (id, tag_group_id, tag_id) values (12,3,15);
insert into tag_group_list (id, tag_group_id, tag_id) values (13,4,4);
insert into tag_group_list (id, tag_group_id, tag_id) values (14,4,5);
insert into tag_group_list (id, tag_group_id, tag_id) values (15,4,6);
insert into tag_group_list (id, tag_group_id, tag_id) values (16,4,7);


insert into country (id, name, chi_name) values(1,'Singapore','Singapore');
insert into country (id, name, chi_name) values(2,'Japan','Japan');
insert into country (id, name, chi_name) values(3,'China','China');

insert into level (id, name, description, chi_description) values (1, 'newbie', 'beginner','新手');
insert into level (id, name, description, chi_description) values (2, 'beginner', 'beginner','初級');
insert into level (id, name, description, chi_description) values (3, 'advance player', 'advance player','高手');

insert into level_tag (id, level_id, tag_id) values (1,1,19);
insert into level_tag (id, level_id, tag_id) values (2,2,19);
insert into level_tag (id, level_id, tag_id) values (3,3,20);

insert into location (id, name, address, phone) values(1,'美林','tai wai','24541234');
insert into location (id, name, address, phone) values(2,'源禾路','sha tin','29541234');
insert into location (id, name, address, phone) values(3,'牛頭角行市','kowloon bay','29341234');
insert into location (id, name, address, phone) values(4,'洛克道','灣仔','29321134');

insert into location_tag (id, location_id, tag_id) values (1,1,1);
insert into location_tag (id, location_id, tag_id) values (2,2,1);
insert into location_tag (id, location_id, tag_id) values (3,3,2);
insert into location_tag (id, location_id, tag_id) values (4,4,3);
insert into location_tag (id, location_id, tag_id) values (5,1,16);
insert into location_tag (id, location_id, tag_id) values (6,2,18);

insert into brand (id, name) values(1,'Gosen');
insert into brand (id, name) values(2,'Wilson');
insert into brand (id, name) values(3,'Li Ning');
insert into brand (id, name) values(4,'yonex');

insert into brand_tag (id, brand_id, tag_id) values(1,1,4);
insert into brand_tag (id, brand_id, tag_id) values(2,2,5);
insert into brand_tag (id, brand_id, tag_id) values(3,3,6);
insert into brand_tag (id, brand_id, tag_id) values(4,4,7);


insert into racket (id, brand_id, code, name,balance_point,frame,shaft,weight,grip,color,remarks) 
values (1,1,'RA1700','ROOTS AERMET 1700',300,null,11,'85','black blue',1,'');
insert into racket (id, brand_id, code, name,balance_point,frame,shaft,weight,grip,color,remarks) 
values (2,1,'RA6000P','ROOTS AERMET 6000 PRO',300,null,11,'85','blue',1,'');
insert into racket (id, brand_id, code, name,balance_point,frame,shaft,weight,grip,color,remarks) 
values (3,1,'RISSEN','RYOGA ISSEN',300,null,11,'85','black',1,'');
insert into racket (id, brand_id, code, name,balance_point,frame,shaft,weight,grip,color,remarks) 
values (4,1,'RISSEN2011','RYOGA ISSEN(2011)',300,null,11,'85','black',1,'');
insert into racket (id, brand_id, code, name,balance_point,frame,shaft,weight,grip,color,remarks) 
values (5,1,'RTENBU','RYOGA TENBU',300,null,11,'85','black',1,'');
insert into racket (id, brand_id, code, name,balance_point,frame,shaft,weight,grip,color,remarks) 
values (6,4,'NS9900','nano speed 9900',300,null,11,'85','black',1,'');

insert into racket_tag (id, racket_id, tag_id) values (1,1,4);
insert into racket_tag (id, racket_id, tag_id) values (2,2,4);
insert into racket_tag (id, racket_id, tag_id) values (3,3,4);
insert into racket_tag (id, racket_id, tag_id) values (4,4,4);
insert into racket_tag (id, racket_id, tag_id) values (5,5,4);
insert into racket_tag (id, racket_id, tag_id) values (6,6,7);
insert into racket_tag (id, racket_id, tag_id) values (7,1,12);
insert into racket_tag (id, racket_id, tag_id) values (8,2,12);
insert into racket_tag (id, racket_id, tag_id) values (9,3,12);
insert into racket_tag (id, racket_id, tag_id) values (10,4,12);
insert into racket_tag (id, racket_id, tag_id) values (11,5,12);
insert into racket_tag (id, racket_id, tag_id) values (12,6,12);
insert into racket_tag (id, racket_id, tag_id) values (13,1,14);
insert into racket_tag (id, racket_id, tag_id) values (14,2,14);
insert into racket_tag (id, racket_id, tag_id) values (15,3,14);
insert into racket_tag (id, racket_id, tag_id) values (16,4,14);
insert into racket_tag (id, racket_id, tag_id) values (17,5,14);
insert into racket_tag (id, racket_id, tag_id) values (18,6,14);

insert into user (id,user_name, password, email, level_id) values(1,'kenny','198342','kenny_ox@me.com',1);
insert into user (id,user_name, password, email, level_id) values(2,'kennyng','198342','abc@123',1);
insert into user (id,user_name, password, email, level_id) values(3,'testing','198342','cde@222',3);

insert into user_tag (id,user_id, tag_id) values (1,1,1);
insert into user_tag (id,user_id, tag_id) values (2,2,1);
insert into user_tag (id,user_id, tag_id) values (3,3,1);

insert into user_role (id, user_id, role) values(1, 1,'ROLE_MASTER');
insert into user_role (id, user_id, role) values(2, 2,'ROLE_ADMIN');
insert into user_role (id, user_id, role) values(3, 3,'ROLE_ADMIN');

insert into event (id, date, location_id, level_id, public_event, status, game_type, max_participant,creator_id,create_date)
values (1, '2014-06-19', 1, 1, 0,0,0,6,1,'2014-06-18 15:00:00');

insert into event_details(id, event_id, court_no, start_time, end_time)
values (1, 1, 3, '2014-06-19 14:00:00','2014-06-19 16:00:00');
insert into event_details(id, event_id, court_no, start_time, end_time)
values (2, 1, 4, '2014-06-19 14:00:00','2014-06-19 15:00:00');

insert into event_tag( id, event_id, tag_id) values (1,1,19);
insert into event_tag( id, event_id, tag_id) values (2,1,1);
insert into event_tag( id, event_id, tag_id) values (3,1,16);

insert into event_admin (id, event_id, user_id, update_dtm) values (1,1,1,'2014-06-19 14:00:00');

insert into event_invitee (id, event_id, user_id, email, status ) values (1,1,null,'nmh809@ha.org.hk',0);

insert into event_participant ( id, event_id, user_id) values (1,1,1);
insert into event_participant ( id, event_id, user_id) values (2,1,2);

