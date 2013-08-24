insert into user values(1,'kenny','198342');
insert into user values(2,'kennyng','198342');
insert into user values(3,'testing','198342');

insert into project values('master','dummy project');
insert into project values('test','testing project');
insert into project values('secondProject','second project');

insert into project_user values(1, 'master',1);
insert into project_user values(2, 'test',2);
insert into project_user values(3, 'secondProject',3);

insert into user_role values(1, 1,'ROLE_MASTER');
insert into user_role values(2, 2,'ROLE_ADMIN');
insert into user_role values(3, 3,'ROLE_ADMIN');

insert into content values(1,'i01','pen','pen pen','test');
insert into content values(2,'i02','TX','xperia TX','test');
insert into content values(3,'i03','wallet','wallet wallet','test');
insert into content values(4,'i04','notebook','notebook','test');

insert into tag values (1,'MainPageTag','Tag which show in main page','test',0);
insert into tag values (2,'Favorites','favorites item','test',0);
insert into tag values (3,'Electrical','personal item','test',1);
insert into tag values (4,'computer','computer related items','test',1);
insert into tag values (5,'phone','phone related item','test',1);
insert into tag values (6,'stationery','stationery','test',1);
insert into tag values (7,'OfficeStationery','office stationery','test',1);

insert into tag_tag values (1,1,2,0);
insert into tag_tag values (2,1,3,0);
insert into tag_tag values (3,1,4,0);
insert into tag_tag values (4,1,5,0);


insert into tag_tag values (5,2,3,0);
insert into tag_tag values (6,2,6,0);

insert into tag_tag values (7,3,4,1);
insert into tag_tag values (8,3,5,1);
insert into tag_tag values (9,6,7,1);
insert into tag_tag values (10,1,5,0);
insert into tag_tag values (11,1,5,0);
insert into tag_tag values (12,1,5,0);
insert into tag_tag values (13,1,5,0);
insert into tag_tag values (14,1,5,0);
insert into tag_tag values (15,1,5,0);
insert into tag_tag values (16,1,5,0);
insert into tag_tag values (17,1,5,0);
insert into tag_tag values (18,1,5,0);
insert into tag_tag values (19,1,5,0);


insert into content_tag values(1,1,6);
insert into content_tag values(2,1,7);
insert into content_tag values(3,2,3);
insert into content_tag values(4,2,5);
insert into content_tag values(5,3,2);
insert into content_tag values(6,4,3);
insert into content_tag values(7,4,4);