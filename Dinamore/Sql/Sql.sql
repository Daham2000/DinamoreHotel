create database Dinomore;
use Dinomore;

create table Customer(
	C_id varchar(30),
	C_name varchar(30),
	Phonenum int(10),
	constraint primary key(C_id)
)engine=innodb;

create table TeleOparator(
	Toid varchar(8),
	Toname varchar(30),
	constraint primary key(Toid)
)engine=innodb;

create table Corder(
	O_id varchar(25),
	Order_time datetime,
	Toid varchar(8),
	C_name varchar(30),
	constraint primary key(O_id),
	constraint FOREIGN key(Toid) REFERENCES TeleOparator(Toid)
)engine=innodb;

create table Chief(
	CheifId varchar(8),
	CheifName varchar(30),
	constraint primary key(CheifId)
)engine=innodb;

create table OrderDetails(
	O_id varchar(25),
	CheifId varchar(8),
	TimeSpend time,
	Prossing_time time,
	OrderFinishTime datetime,
	Qty int,
	constraint primary key(O_id,CheifId),
	constraint FOREIGN key(O_id) REFERENCES Corder(O_id),
	constraint FOREIGN key(CheifId) REFERENCES Chief(CheifId)
)engine=innodb;

insert into Customer VALUES("C001","Nimal herath",0774545888);  