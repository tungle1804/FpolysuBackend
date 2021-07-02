CREATE DATABASE polytu	
USE polytu

--Tao bang user
 CREATE TABLE users(
 email NVARCHAR(50) NOT NULL PRIMARY KEY,
 name NVARCHAR(50) NOT NULL ,
 business_name NVARCHAR(200) NOT NULL,
 phone NVARCHAR(15) NOT NULL,
 _password VARCHAR(30),
 _role BIT DEFAULT 0
 )

---tạo bảng menu
/*create table menu(
maMN nvarchar(10) not null primary key,
tenMN nvarchar(30),
_status bit
)*/

---tạo bảng button
/*create table button(
maBT int identity(1,1) not null primary key,
maMN nvarchar(10) foreign key references menu(maMN),
tenBT nvarchar(100),
color nvarchar(30),
link nvarchar(300)
)*/
DROP TABLE dbo.menu 
DELETE dbo.users
DROP TABLE button
CREATE TABLE menu(
id_menu INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
email NVARCHAR(50) FOREIGN KEY REFERENCES dbo.users(email),
name_menu NVARCHAR(30) NOT NULL,
color_menu NVARCHAR(50) NOT NULL,
_status BIT NOT NULL
)



CREATE TABLE button (
id_button INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
id_menu INT FOREIGN KEY REFERENCES dbo.menu(id_menu),
name_button NVARCHAR(100) NOT NULL,
color_text NVARCHAR(300) NOT NULL,
link NVARCHAR(300) NOT NULL,
icon NVARCHAR(300) NOT NULL,
color_background NVARCHAR(300) NOT NULL,
color_icon NVARCHAR(300) NOT NULL
) 

CREATE TABLE button_fake (
id_button INT  NOT NULL PRIMARY KEY,
name_button NVARCHAR(100) NOT NULL,
color_text NVARCHAR(300) NOT NULL,
link NVARCHAR(300) NOT NULL,
icon NVARCHAR(300) NOT NULL,
color_background NVARCHAR(300) NOT NULL,
color_icon NVARCHAR(300) NOT NULL
) 

SELECT * FROM dbo.button_fake
INSERT INTO dbo.users 
        ( email ,
          name ,
          business_name ,
          phone ,
          [_password],
           [_role]
        )
VALUES ('ngoc@gmail.com','Le hong ngoc','student','0876554323','ngoc123',0),
 ( 'tung@gmail.com','Le anh tung','student','0865413983','tung123',1),
( 'nhan@gmail.com','Tran thanh nhan','student','0343503701','nhan123',0),
 DELETE dbo.users
		
				  INSERT INTO dbo.button
				          ( 
				            id_menu ,
				            name_button ,
				            color ,
				            link,icon
				          )
				  VALUES  ( 1 ,'Goi ngay','red','facebook.com','facebook.png'
				            
				          )
						
						  SELECT * FROM dbo.menu
						 
						  SELECT * FROM dbo.users
						  SELECT * FROM dbo.button
						  UPDATE dbo.users SET [_role]='0' WHERE email='trang@gmail.com'
						  UPDATE dbo.menu SET email='nhan@gmail.com' WHERE id_menu='5'
						  DELETE dbo.menu WHERE id_menu='6'
						  SELECT * FROM dbo.button WHERE id_menu ='2'

						  SELECT * FROM dbo.button
						  SELECT * FROM dbo.button_fake
						DELETE dbo.button_fake

					INSERT INTO dbo.button_fake
					        ( 
					          name_button ,
					          color_text ,
					          link ,
					          icon ,
					          color_background ,
					          color_icon
					        )
					VALUES  ( 
					          N'call' , -- name_button - nvarchar(100)
					          N'red' , -- color_text - nvarchar(300)
					          N'fb.com' , -- link - nvarchar(300)
					          N'zalo.png' , -- icon - nvarchar(300)
					          N'blak' , -- color_background - nvarchar(300)
					          N'white'  -- color_icon - nvarchar(300)
					        )

   SET IDENTITY_INSERT dbo.menu OFF
    