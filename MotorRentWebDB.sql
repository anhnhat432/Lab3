--drop database MotorRentWebDB
create database MotorRentWebDB
go
use MotorRentWebDB
go
CREATE TABLE Account (
id int primary key identity,
username nvarchar(100),
password nvarchar(100)
)
go 
insert into Account values 
('customer' , 'customer'),
('admin' , 'admin')
go
CREATE TABLE [Motor] (
id int primary key identity,
motorname nvarchar(100),
motorprice float,
motorimageurl nvarchar(500),
)
go
insert into [Motor] values 
('SYM Star' , 500000, 'image/SYMStar.jpg'),
('Wave' , 400000, 'image/Wave.jpg'),
('Dream' , 450000, 'image/Dream.jpg'),
(' Jupiter' , 650000, 'image/Jupiter.png')
go
CREATE TABLE [AccountRentMotor] (
id int primary key identity,
userId int REFERENCES Account(id),
motorId int REFERENCES [Motor](id),
namerent nvarchar(100),
email nvarchar(100),
phonenumber nvarchar(100),
rentdate DATETIME
)
select * from [AccountRentMotor]


