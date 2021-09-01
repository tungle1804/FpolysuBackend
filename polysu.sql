drop database polysu
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
gender NVARCHAR(15),
_address NVARCHAR(100),
date_of_birth date,
_status bit,
created_date date,
created_by NVARCHAR(50)
)

-- menu
CREATE TABLE menu(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
name_menu NVARCHAR(30),
color_menu NVARCHAR(50),
_status BIT,
menu_type nvarchar(10),
date_start date,
display_time int,
menu_location nvarchar(20)
)
select * from menu

--button

CREATE TABLE button (
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_menu INT FOREIGN KEY REFERENCES menu(id),
type_button nvarchar(100),
name_button NVARCHAR(100),
color_text NVARCHAR(300),
link NVARCHAR(300),
icon NVARCHAR(300),
color_background NVARCHAR(300),
color_icon NVARCHAR(300)
)


create table activityButton(
id int identity not null primary key,
id_button int foreign key references dbo.button(id) not null,
created_at datetime default getdate() null,
from_url nvarchar(300),
Equipment  bit
)

create table activityMenu(
id int identity not null primary key,
id_menu int foreign key references dbo.menu(id) not null,
created_at datetime default getdate() null
)

-- modal
CREATE TABLE modal
(
    id          INT IDENTITY (1,1) NOT NULL PRIMARY KEY,
    id_button   INT FOREIGN KEY REFERENCES dbo.button (id),
    input_name  NVARCHAR(50)       NOT NULL,
    input_value NVARCHAR(50)       NOT NULL
)
-- dataofcustom
create table dataofcustomer(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
id_modal INT FOREIGN KEY REFERENCES modal(id),
fullname NVARCHAR(100),
phone varchar(15),
email_customer NVARCHAR(100),
_address NVARCHAR(200),
content NVARCHAR(MAX),
notes NVARCHAR(MAX),
create_date Datetime,
)

-----------------------
-- servicefee
create table servicefee(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
name_service NVARCHAR(200),
price float,
)

-- payment_history
create table payment_history(
id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
id_service INT FOREIGN KEY REFERENCES servicefee(id),
date_start date,
date_end date,
_status bit,
)

-- insert user
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('admin@gmail.com', '12345678', 'Admin', 'CD FPT', '0972222111', 'admin', 1)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('leanhtung@gmail.com', 'duy123', 'Lê Anh Tùng', 'CD FPT', '0972222111', 'admin', 1)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('leducbinh@gmail.com', '12345678', 'Lê Đức Bình', 'CD FPT', '0972222111', 'customer', 1)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('duongtunglam@gmail.com', 'duy123', 'Dương Tùng Lâm', 'CD FPT', '0972222111', 'employee', 0)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('nguyenbavinh@gmail.com', 'duy123', 'Nguyễn Bá Vinh', 'CD FPT', '0972222111', 'customer', 1)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('vuthanhnam@gmail.com', 'duy123', 'Vũ Thành Nam', 'CD FPT', '0972222111', 'customer', 0)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('nhanvien01@gmail.com', 'duy123', 'Nguyễn Nhân Viên', 'CD FPT', '0972222111', 'employee', 1)
insert into users (email, _password, name, business_name, phone, _role, _status) 
values ('tung@gmail.com', 'duy123', 'Trần Thanh Tùng', 'CD FPT', '0972222111', 'customer', 0)

-- insert menu
insert into menu (email, name_menu, color_menu, _status)
values ('nguyenbavinh@gmail.com', 'alo', 'red', 1)
insert into menu (email, name_menu, color_menu, _status)
values ('duongtunglam@gmail.com', 'call', 'red', 0)
insert into menu (email, name_menu, color_menu, _status)
values ('nguyenbavinh@gmail.com', 'email', 'red', 1)
insert into menu (email, name_menu, color_menu, _status)
values ('vuthanhnam@gmail.com', 'call', 'blue', 0)
insert into menu (email, name_menu, color_menu, _status)
values ('vuthanhnam@gmail.com', 'email', 'black', 1)
insert into menu (email, name_menu, color_menu, _status)
values ('leducbinh@gmail.com', 'email', 'black', 1)
insert into menu (email, name_menu, color_menu, _status)
values ('leducbinh@gmail.com', 'zalo', 'black', 0)
insert into menu (email, name_menu, color_menu, _status)
values ('leducbinh@gmail.com', 'email', 'black', 0)


-- insert button
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (6, 'call', 'call', 'red', '24h.com.vn', ':))', 'red', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (1, 'call', 'call', 'black', 'https://www.24h.com.vn/', ':))', 'red', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (1, 'call', 'call', 'blue', 'https://www.google.com/', ':))', 'black', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (2, 'facebook', 'facebook', 'yellow', 'https://www.24h.com.vn/', ':))', 'yellow', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (6, 'massage', 'massage', 'red', 'https://www.24h.com.vn/', ':))', 'black', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (2, 'massage', 'massage', 'red', 'https://www.24h.com.vn/', ':))', 'black', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (1, 'facebook', 'facebook', 'red', 'https://www.24h.com.vn/', ':))', 'black', 'blue')
insert into button(id_menu, type_button, name_button, color_text, link, icon, color_background, color_icon)
values (3, 'facebook', 'facebook', 'red', 'https://www.24h.com.vn/', ':))', 'black', 'blue')

--insert activity
insert into activityButton(id_button)
values (3)
insert into activityMenu(id_menu)
values (3)

--insert modal
SELECT * FROM dbo.modal
INSERT INTO dbo.modal(id_button, input_name, input_value)
VALUES (2, N'GioiTinh', 'Nam')
INSERT INTO dbo.modal(id_button, input_name, input_value)
VALUES (2, N'DoTuoi', 'TrungBinh')
INSERT INTO dbo.modal(id_button, input_name, input_value)
VALUES (2, N'CMTND', '1232454356')


-- insert dataofcustomer
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('leducbinh@gmail.com', N'Lê Đức bình', '044445566', 'ducbinh@gmail.com', N'Nghệ An',
        N'tôi được nhận vào công ty savis', N'abc')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('duongtunglam@gmail.com', N'lê anh tùng', '0343445566', 'leanhtung@gmail.com', N'phú thọ', N'thu nhập 1000$',
        N'chị 97')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('leanhtung@gmail.com', N'Vũ thành Nan', '033445566', 'thanhnam93@gmail.com', N'Nam định',
        N'tôi mới có người yêu', N'thuu')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('leducbinh@gmail.com', N'Lê khương duy', '044445566', 'lekhuongduy@gmail.com', N'ha noi', N'THPT lý tử tấn',
        N'cyz')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('leducbinh@gmail.com', N'duong tung lam', '0343445566', 'tunglam@gmail.com', N'Hà Nội',
        N'thu nhập 10000$', N'chưa có người yêu')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('vuthanhnam@gmail.com', N'vu thanh nam', '0343445566', 'thanhnam93@gmail.com', N'Hà Nội', N'thu nhập 10000$',
        N'chưa có người yêu')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('vuthanhnam@gmail.com', N'vu thanh nam', '123456789', 'thanhnam93@gmail.com', N'Hà Nội', N'thu nhập cao',
        N'chưa có người yêu')
insert into dataofcustomer(email, fullname, phone, email_customer, _address, content, notes)
values ('tung@gmail.com', N'test', '123456789', 'test1@gmail.com', N'Hà Nội', N'thu nhập cao', N'chưa có người yêu')

-- insert servicefee
select * from servicefee
insert into servicefee(name_service, price)
values ('1 tháng', 59000)
insert into servicefee(name_service, price)
values ('3 tháng', 130000)
insert into servicefee(name_service, price)
values ('6 tháng', 200000)
insert into servicefee(name_service, price)
values ('12 tháng', 350000)

-- insert payment_history
insert into payment_history(email, id_service, date_end, _status)
values ('leducbinh@gmail.com', 1, GETDATE(), 0)
insert into payment_history(email, id_service, date_end, _status)
values ('nguyenbavinh@gmail.com', 2, GETDATE(), 1)
insert into payment_history(email, id_service, date_end, _status)
values ('duongtunglam@gmail.com', 2, GETDATE(), 1)
insert into payment_history(email, id_service, date_end, _status)
values ('leanhtung@gmail.com', 1, GETDATE(), 0)
insert into payment_history(email, id_service, date_end, _status)
values ('leducbinh@gmail.com', 4, GETDATE(), 1)

select *
from users
delete
from users
where users.email = 'thanhnam.humg93@gmail.com'
select *
from menu
where email = 'vuthanhnam@gmail.com'
select *
from button
where button.id_menu = 6

select *
from activity_menu
select menu.id, activity_button.created_at
from activity_button
         join button on button.id = activity_button.id_button
         join menu on
    menu.id = button.id_menu
         join users on users.email = menu.email and users.email = 'vuthanhnam@gmail.com'
--Note: Button had Click----------> Menu had Action but Menu had Action ----------not sure Button had Click
-------------------------------------------------------------------------Char 1--------------------------------------------------------
select count(*) as TotalClickOnMenuEnable
from activity_button
         join button on button.id = activity_button.id_button
         join menu on menu.id = button.id_menu
         join users on users.email = menu.email
where users.email = 'vuthanhnam@gmail.com'
  and menu._status = 1
  and DATEPART(HOUR, activity_button.created_at) = 17
  and DAY(activity_button.created_at) = 19
  and MONTH(activity_button.created_at) = 8
  and YEAR(activity_button.created_at) = 2021


select count(*) as TotalClickOnMenuEnable
from activity_button
         join button on button.id = activity_button.id_button
         join menu on menu.id = button.id_menu
         join users on users.email = menu.email
where users.email = 'vuthanhnam@gmail.com'
  and menu.id = 6
  and activity_button.created_at like '2021-08-19'

-------------------------------------------------------------------------Table 1--------------------------------------------------------
-- get Total number Click on one Menu group by MenuID of username: countNumberClickMenu = Total Click all Button of this
select distinct menu.name_menu, count(*) as countNumberClickMenu
from activity_button
         join button on button.id = activity_button.id_button
         join menu on menu.id = button.id_menu
         join users on users.email = menu.email and users.email = 'vuthanhnam@gmail.com'
group by menu.name_menu

-- get Total number Click on one Menu group by MenuID of username: countNumberClickMenu = Total Click all Button of this by Time range selectn use DatetimePicker
select count(*) as countNumberClickMenu
from activity_button
         join button on button.id = activity_button.id_button
         join menu on menu.id = button.id_menu
         join users on users.email = menu.email and users.email = 'vuthanhnam@gmail.com' and activity_button.created_at
    between '2021-08-17' AND '2021-08-22' and menu.id = 6


--get Total number Action on one Menu group by MenuId of username 
select distinct menu.name_menu, count(*) as countNumberActionMenu
from activity_menu
         join menu on menu.id = activity_menu.id_menu
         join users
              on users.email = menu.email
where users.email = 'vuthanhnam@gmail.com'
group by menu.name_menu

--two query on up certain have problem because action of menu
--independence with action of button (have action menu but can't action button  but have action button must action of menu  --FUCK--)
-------------------------------------------------------------------------Table 2--------------------------------------------------------
-- get Total number display of button by TypeButton
select button.type_button, count(*) as countNumberActionButtonByType
from button
         join menu on menu.id = button.id_menu
         join activity_menu
              on menu.id = activity_menu.id_menu
         join users on users.email = menu.email
where users.email = 'vuthanhnam@gmail.com'
group by button.type_button

-- get Total number Click of button by TypeButton
select button.type_button, count(*) as countNumberActionButtonByType
from activity_button
         join button on button.id = activity_button.id_button
         join menu on menu.id = button.id_menu
         join users on users.email = menu.email
where users.email = 'vuthanhnam@gmail.com'
  and button.id_menu in (select distinct activity_menu.id_menu from activity_menu)
group by button.type_button
-------------------------------------------------------------------------Table 3--------------------------------------------------------
select activity_button.created_at as ClickTime,
       menu.name_menu,
       button.name_button,
       button.link,
       activity_button.from_url
from activity_button
         join button on button.id = activity_button.id_button
         join menu on menu.id = button.id_menu
         join users on users.email = menu.email
where users.email = 'vuthanhnam@gmail.com' and activity_button.created_at between '2021-08-17' and '2021-08-22'
SET LANGUAGE us_english;  