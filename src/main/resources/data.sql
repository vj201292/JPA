create table person(
  id integer not null,
  name varchar(255) not null,
  location varchar(255),
  birth_date timestamp,
  primary key(id)
);

insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values (10001,'Vijay','Bangalore',sysdate());


insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values (10002,'Sam','Chennai',sysdate());

insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values (10003,'Raj','Hyderabad',sysdate());

insert into person(ID,NAME,LOCATION,BIRTH_DATE)
values (10004,'Vijay','Bangalore',sysdate());
