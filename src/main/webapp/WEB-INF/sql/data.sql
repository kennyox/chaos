insert into country values(1,'Singapor','Singapor');
insert into country values(2,'Japan','Japan');
insert into country values(3,'China','Japan');

insert into user values(1,'kenny','198342');
insert into user values(2,'kennyng','198342');
insert into user values(3,'testing','198342');


insert into user_role values(1, 1,'ROLE_MASTER');
insert into user_role values(2, 2,'ROLE_ADMIN');
insert into user_role values(3, 3,'ROLE_ADMIN');

insert into tag values (1,'NT','NT');
insert into tag values (2,'KL','KL');
insert into tag values (3,'HK','HK');
insert into tag values (4,'gosen','gosen');
insert into tag values (5,'wilson','wilson');
insert into tag values (6,'lining','li ning');
insert into tag values (7,'yonex','yonex');
insert into tag values (8,'racket','racket');
insert into tag values (9,'shuttlecock','shuttlecock');
insert into tag values (10,'2U','2U');
insert into tag values (11,'3U','3U');
insert into tag values (12,'4U','4U');
insert into tag values (13,'5U','5U');
insert into tag values (14,'3G','3G');
insert into tag values (15,'4G','4G');

insert into brand values(1,4,'Gosen');
insert into brand values(2,5,'Wilson');
insert into brand values(3,6,'Li Ning');
insert into brand values(4,7,'yonex');

insert into brand_tag values(1,1,8);
insert into brand_tag values(2,2,8);
insert into brand_tag values(3,3,8);
insert into brand_tag values(4,4,8);
insert into brand_tag values(5,4,9);

insert into racket values (1,1,'RA1700','ROOTS AERMET 1700',300,null,null,11,15,'black blue',1,'');
insert into racket values (2,1,'RA6000P','ROOTS AERMET 6000 PRO',300,null,null,11,15,'blue',1,'');
insert into racket values (3,1,'RISSEN','RYOGA ISSEN',300,null,null,11,15,'black',1,'');
insert into racket values (4,1,'RISSEN2011','RYOGA ISSEN(2011)',300,null,null,11,15,'black',1,'');
insert into racket values (5,1,'RTENBU','RYOGA TENBU',300,null,null,11,15,'black',1,'');
insert into racket values (6,4,'NS9900','nano speed 9900',300,null,null,11,15,'black',1,'');

insert into racket_tag values(1,1,4);
insert into racket_tag values(2,2,4);
insert into racket_tag values(3,2,10);
insert into racket_tag values(4,3,4);
insert into racket_tag values(5,3,10);
insert into racket_tag values(6,4,4);
insert into racket_tag values(7,4,10);
insert into racket_tag values(8,5,4);
insert into racket_tag values(9,5,10);
insert into racket_tag values(10,6,7);
insert into racket_tag values(11,6,10);
