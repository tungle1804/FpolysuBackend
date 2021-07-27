create database polysu
go
use polysu
go

-- users
CREATE TABLE users(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email VARCHAR(100),
_password VARCHAR(100),
name NVARCHAR(100),
business_name NVARCHAR(200),
phone NVARCHAR(15),
_role VARCHAR(15),
)

-- menu
CREATE TABLE menu(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_users INT FOREIGN KEY REFERENCES users(id),
name_menu NVARCHAR(30),
color_menu NVARCHAR(50),
_status BIT 
)

--button
CREATE TABLE button (
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_menu INT FOREIGN KEY REFERENCES menu(id),
name_button NVARCHAR(100),
color_text NVARCHAR(300),
link NVARCHAR(300),
icon NVARCHAR(300),
color_background NVARCHAR(300),
color_icon NVARCHAR(300)  
)
exec sp_rename dataocustomer, dataofcustomer 
-- dataofcustom
create table dataofcustomer(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_users INT FOREIGN KEY REFERENCES users(id),
fullname NVARCHAR(100),
phone varchar(15),
email NVARCHAR(100),
_address NVARCHAR(200),
content NVARCHAR(MAX),
notes NVARCHAR(MAX),
)

-- servicefee
create table servicefee(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
name_service NVARCHAR(200),
price INT,
)

-- payment_history
create table payment_history(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_users INT FOREIGN KEY REFERENCES users(id),
id_service INT FOREIGN KEY REFERENCES servicefee(id),
date_end datetime,
_status nvarchar(100),
)

-- button_fake
CREATE TABLE button_fake (
id_button INT  NOT NULL PRIMARY KEY,
name_button NVARCHAR(100) ,
color_text NVARCHAR(300) ,
link NVARCHAR(300) ,
icon NVARCHAR(300),
color_background NVARCHAR(300),
color_icon NVARCHAR(300) 
)


select * from users
-- insert user
insert into users(email,_password,name,business_name,phone,_role) values('lekhuongduy1998@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('leanhtung@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('leducbinh@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('duongtunglam@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('nguyenbavinh@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('vuthanhnam@gmail.com','duy123','Duy','CD FPT','0972222111','customer')
insert into users(email,_password,name,business_name,phone,_role) values('abc@gmail.com','duy123','Duy','CD FPT','0972222111','employee')

select * from menu
-- insert menu
insert into menu (id_users,name_menu,color_menu,_status) values(5,'alo','red',1)
insert into menu (id_users,name_menu,color_menu,_status) values(6,'call','red',0)
insert into menu (id_users,name_menu,color_menu,_status) values(7,'email','red',1)
insert into menu (id_users,name_menu,color_menu,_status) values(5,'call','blue',0)
insert into menu (id_users,name_menu,color_menu,_status) values(5,'email','black',1)


-- insert button
select * from button
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(1,'call','red','24h.com.vn',':))','red','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(2,'call','black','https://www.24h.com.vn/',':))','red','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(1,'call','blue','https://www.google.com/',':))','black','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(2,'facebook','yellow','https://www.24h.com.vn/',':))','yellow','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(3,'massage','red','https://www.24h.com.vn/',':))','black','blue')

-- insert dataofcustomer
select * from dataofcustomer

insert into dataofcustomer(id_users,fullname,phone,email,_address,content,notes) values(5,N'Lê Đức bình','044445566','ducbinh@gmail.com',N'Nghệ An',N'tôi được nhận vào công ty savis',N'abc')
insert into dataofcustomer(id_users,fullname,phone,email,_address,content,notes) values(6,N'lê anh tùng','0343445566','leanhtung@gmail.com',N'phú thọ',N'thu nhập 1000$',N'chị 97')
insert into dataofcustomer(id_users,fullname,phone,email,_address,content,notes) values(5,N'Vũ thành Nan','033445566','thanhnam93@gmail.com',N'Nam định',N'tôi mới có người yêu',N'thuu')
insert into dataofcustomer(id_users,fullname,phone,email,_address,content,notes) values(5,N'Lê khương duy','044445566','lekhuongduy@gmail.com',N'ha noi',N'THPT lý tử tấn',N'cyz')
insert into dataofcustomer(id_users,fullname,phone,email,_address,content,notes) values(6,N'duong tung lam','0343445566','tunglam@gmail.com',N'Hà Nội',N'thu nhập 10000$',N'chưa có người yêu')

-- insert servicefee
select * from servicefee

insert into servicefee(name_service,price) values('1 tháng',59000)
insert into servicefee(name_service,price) values('3 tháng',130000)
insert into servicefee(name_service,price) values('6 tháng',200000)
insert into servicefee(name_service,price) values('12 tháng',350000)

-- insert payment_history
select * from payment_history

insert into payment_history(id_users,id_service,date_end,_status) values(5,2,GETDATE(),'đã thanh toán')
insert into payment_history(id_users,id_service,date_end,_status) values(6,3,GETDATE(),'đã thanh toán')
insert into payment_history(id_users,id_service,date_end,_status) values(5,5,GETDATE(),'đã thanh toán')
insert into payment_history(id_users,id_service,date_end,_status) values(7,4,GETDATE(),'đã thanh toán')
insert into payment_history(id_users,id_service,date_end,_status) values(5,2,GETDATE(),'đã thanh toán')