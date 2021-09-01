create database polysu
go
use polysu
go

-- users
CREATE TABLE users(
email NVARCHAR(50) NOT NULL PRIMARY KEY,
_password VARCHAR(100),
name NVARCHAR(100),
business_name NVARCHAR(200),
phone NVARCHAR(15),
_role VARCHAR(15),
)

-- menu
CREATE TABLE menu(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
name_menu NVARCHAR(30),
color_menu NVARCHAR(50),
_status BIT 
)
--them column menu
ALTER TABLE menu
ADD menu_type VARCHAR(20);
ALTER TABLE menu
ADD menu_location VARCHAR(20);
ALTER TABLE menu
ADD menu_code VARCHAR(50);
--button
CREATE TABLE button (
id NVARCHAR(10)  NOT NULL PRIMARY KEY,
id_menu INT FOREIGN KEY REFERENCES menu(id),
name_button NVARCHAR(100),
color_text NVARCHAR(300),
link NVARCHAR(300),
icon NVARCHAR(300),
color_background NVARCHAR(300),
color_icon NVARCHAR(300)  
)


-- dataofcustom
create table dataofcustomer(
id  nvarchar(20) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
fullname NVARCHAR(100),
phone varchar(15),
email_customer NVARCHAR(100),
_address NVARCHAR(200),
content NVARCHAR(MAX),
notes NVARCHAR(MAX),
create_date NVARCHAR(20)
)

-----------------------
-- servicefee
create table servicefee(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
name_service NVARCHAR(200),
price INT,
)

-- payment_history
create table payment_history(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
id_service INT FOREIGN KEY REFERENCES servicefee(id),
date_end datetime,
_status nvarchar(100),
)
-- button fake

CREATE TABLE button_fake (
id_button INT  NOT NULL PRIMARY KEY,
name_button NVARCHAR(100) NOT NULL,
color_text NVARCHAR(300) NOT NULL,
link NVARCHAR(300) NOT NULL,
icon NVARCHAR(300) NOT NULL,
color_background NVARCHAR(300) NOT NULL,
color_icon NVARCHAR(300) NOT NULL
) 


----1 button -> 1 modal
----1 modal  -> nhieu truong
---- 1 truong -> 1 value

CREATE TABLE modal (
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_button NVARCHAR(10) FOREIGN KEY REFERENCES dbo.button(id),
id_dataofcustomer NVARCHAR(20) FOREIGN KEY REFERENCES dbo.dataofcustomer(id),
input_name NVARCHAR(50) NOT NULL,
input_value NVARCHAR(50) 
) 
DROP TABLE  dbo.modal
update modal SET input_value ='column4' set where id = '30'
--insert modal
SELECT * FROM dbo.modal WHERE id_button='2254'
INSERT INTO dbo.modal( id_button,input_name,input_value)VALUES  (14,N'GioiTinh','Nam')
INSERT INTO dbo.modal( id_button,input_name,input_value)VALUES  (14,N'DoTuoi','TrungBinh')
INSERT INTO dbo.modal( id_button,input_name,input_value)VALUES  (14,N'CMTND','1232454356')

select * from users
DELETE dbo.users WHERE email='tung@gmail.com'
-- insert user
insert into users(email,_password,name,business_name,phone,_role) values('lekhuongduy1998@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('leanhtung@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('leducbinh@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('duongtunglam@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('nguyenbavinh@gmail.com','duy123','Duy','CD FPT','0972222111','admin')
insert into users(email,_password,name,business_name,phone,_role) values('vuthanhnam@gmail.com','duy123','Duy','CD FPT','0972222111','customer')
insert into users(email,_password,name,business_name,phone,_role) values('abc@gmail.com','duy123','Duy','CD FPT','0972222111','employee')
insert into users(email,_password,name,business_name,phone,_role) values('tung@gmail.com','duy123','Duy','CD FPT','0972222111','customer')

select * from menu WHERE email='test1@gmail.com'

-- insert menu
insert into menu (email,name_menu,color_menu,_status) values('tung@gmail.com','alo','red',1)
insert into menu (email,name_menu,color_menu,_status) values('duongtunglam@gmail.com','call','red',0)
insert into menu (email,name_menu,color_menu,_status) values('leanhtung@gmail.com','email','red',1)
insert into menu (email,name_menu,color_menu,_status) values('test1@gmail.com','call','blue',0)
insert into menu (email,name_menu,color_menu,_status) values('lekhuongduy1998@gmail.com','email','black',1)
insert into menu (email,name_menu,color_menu,_status) values('vuthanhnam@gmail.com','email','black',1)
insert into menu (email,name_menu,color_menu,_status) values('vuthanhnam@gmail.com','zalo','black',0)
insert into menu (email,name_menu,color_menu,_status) values('test@gmail.com','zalo','black',0)
UPDATE dbo.menu SET email='vuthanhnam@gmail.com' WHERE id='11'

SELECT * FROM dbo.menu WHERE email ='leanhtung@gmail.com'
-- insert button
select * from button WHERE id_menu='96'
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(17,'call','red','24h.com.vn','zalo.png','red','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(16,'call','black','https://www.24h.com.vn/',':))','red','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(1,'call','blue','https://www.google.com/',':))','black','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(2,'facebook','yellow','https://www.24h.com.vn/',':))','yellow','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(3,'massage','red','https://www.24h.com.vn/',':))','black','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(12,'massage','red','https://www.24h.com.vn/',':))','black','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(11,'facebook','red','https://www.24h.com.vn/',':))','black','blue')
insert into button(id_menu,name_button,color_text,link,icon,color_background,color_icon) values(13,'facebook','red','https://www.24h.com.vn/',':))','black','blue')
-- insert dataofcustomer
select * from dbo.dataofcustomer left JOIN dbo.modal ON modal.id_dataofcustomer = dataofcustomer.id 
WHERE dbo.dataofcustomer.id='CU802047' SELECT * FROM dbo.modal where dbo.modal.id_dataofcustomer = 'CU629067'
select * from dbo.users
DELETE dbo.dataofcustomer
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('abc@gmail.com',N'Lê Đức bình','044445566','ducbinh@gmail.com',N'Nghệ An',N'tôi được nhận vào công ty savis',N'abc')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('duongtunglam@gmail.com',N'lê anh tùng','0343445566','leanhtung@gmail.com',N'phú thọ',N'thu nhập 1000$',N'chị 97')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('leanhtung@gmail.com',N'Vũ thành Nan','033445566','thanhnam93@gmail.com',N'Nam định',N'tôi mới có người yêu',N'thuu')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('leducbinh@gmail.com',N'Lê khương duy','044445566','lekhuongduy@gmail.com',N'ha noi',N'THPT lý tử tấn',N'cyz')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('lekhuongduy1998@gmail.com',N'duong tung lam','0343445566','tunglam@gmail.com',N'Hà Nội',N'thu nhập 10000$',N'chưa có người yêu')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('vuthanhnam@gmail.com',N'vu thanh nam','0343445566','thanhnam93@gmail.com',N'Hà Nội',N'thu nhập 10000$',N'chưa có người yêu')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('vuthanhnam@gmail.com',N'vu thanh nam','123456789','thanhnam93@gmail.com',N'Hà Nội',N'thu nhập cao',N'chưa có người yêu')
insert into dataofcustomer(email,fullname,phone,email_customer,_address,content,notes) values('tung@gmail.com',N'test','123456789','test1@gmail.com',N'Hà Nội',N'thu nhập cao',N'chưa có người yêu')
-- insert servicefee
select * from servicefee

insert into servicefee(name_service,price) values('1 tháng',59000)
insert into servicefee(name_service,price) values('3 tháng',130000)
insert into servicefee(name_service,price) values('6 tháng',200000)
insert into servicefee(name_service,price) values('12 tháng',350000)

-- insert payment_history
select * from payment_history
select * from users
insert into payment_history(email,id_service,date_end,_status) values('abc@gmail.com',1,GETDATE(),'đã thanh toán')
insert into payment_history(email,id_service,date_end,_status) values('abc@gmail.com',2,GETDATE(),'đã thanh toán')
insert into payment_history(email,id_service,date_end,_status) values('duongtunglam@gmail.com',2,GETDATE(),'đã thanh toán')
insert into payment_history(email,id_service,date_end,_status) values('leanhtung@gmail.com',1,GETDATE(),'đã thanh toán')
insert into payment_history(email,id_service,date_end,_status) values('leducbinh@gmail.com',4,GETDATE(),'đã thanh toán')