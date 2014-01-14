
insert into USERS (username,email,password) values ('admin','gmail','8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918');
insert into USERS (username,email,password) values ('user','gmail','04f8996da763b7a969b1028ee3007569eaf3a635486ddab211d512c85b9df8fb');
insert into USERS (username,email,password) values ('serena','sere.disabatino@gmail.com','5e42e5c6483833eb0a4fb292c5e5aecfb53563724a5ea4145b6bbe5bb132c25b');
insert into USERS (username,email,password) values ('ciro','andrea.cirigiano@gmail.com','bb3625483bd43ccdfa894eb7a88187d3ee261d4fdd2b001a7320f4a4f396bc5c');
insert into USERS (username,email,password) values ('billi','stefano.bielli@gmail.com','ddae89d7ff30f88b1abefb0b6ae2aabd63b10b972134fbfff52097acbd57cf10');

insert into GROUPS (idGroup) values ('ADMIN');
insert into GROUPS (idGroup) values ('USER');

insert into USER_GROUP (username,idGroup) values ('admin','ADMIN');
insert into USER_GROUP (username,idGroup) values ('user','USER');
insert into USER_GROUP (username,idGroup) values ('serena','ADMIN');
insert into USER_GROUP (username,idGroup) values ('ciro','ADMIN');
insert into USER_GROUP (username,idGroup) values ('billi','USER');
