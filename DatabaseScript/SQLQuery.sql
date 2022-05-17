CREATE DATABASE News
GO

USE News
GO

CREATE TABLE Rolee
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name NVARCHAR(100) NOT NULL,
	code VARCHAR(100) NOT NULL,
)

CREATE TABLE Userr
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	userName VARCHAR(100) NOT NULL,
	passWord VARCHAR(100) NOT NULL,
	fullName NVARCHAR(100) NULL,
	status INT NOT NULL,
	createdDate DATETIME NULL,
	modifiedDate DATETIME NULL,
	createdBy VARCHAR(100) NULL,
	modifiedBy VARCHAR(100) NULL,
	idRole INT NOT NULL,

	FOREIGN KEY(idRole) REFERENCES dbo.Rolee(id),
)

CREATE TABLE Category
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	name NVARCHAR(100) NOT NULL,
	code VARCHAR(100) NOT NULL,
	createdDate DATETIME NULL,
	modifiedDate DATETIME NULL,
	createdBy VARCHAR(100) NULL,
	modifiedBy VARCHAR(100) NULL,
)

CREATE TABLE News
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	title NVARCHAR(255) NULL,
	thumbnail VARCHAR(255) NULL,
	shortDescription NTEXT NULL,
	content NTEXT NULL,
	createdDate DATETIME NULL,
	modifiedDate DATETIME NULL,
	createdBy VARCHAR(100) NULL,
	modifiedBy VARCHAR(100) NULL,
	idCategory INT NOT NULL

	FOREIGN KEY(idCategory) REFERENCES dbo.Category(id),
)

CREATE TABLE Comment
(
	id INT PRIMARY KEY IDENTITY NOT NULL,
	content NTEXT NOT NULL,
	idUser INT NOT NULL,
	idNews INT NOT NULL,
	createdDate DATETIME NULL,
	modifiedDate DATETIME NULL,
	createdBy VARCHAR(100) NULL,
	modifiedBy VARCHAR(100) NULL,

	FOREIGN KEY(idUser) REFERENCES dbo.Userr(id),
	FOREIGN KEY(idNews) REFERENCES dbo.News(id),
)

SELECT * FROM dbo.News
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 29',N'Bai Viet 29',N'Noi dung bai viet 29',2)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 1',N'Bai Viet 1',N'Noi dung bai viet 1',1)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 2',N'Bai Viet 2',N'Noi dung bai viet 2',1)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 3',N'Bai Viet 3',N'Noi dung bai viet 3',1)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 10',N'Bai Viet 10',N'Noi dung bai viet 10',1)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 16',N'Bai Viet 16',N'Noi dung bai viet 16',2)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 12',N'Bai Viet 12',N'Noi dung bai viet 12',2)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 5',N'Bai Viet 5',N'Noi dung bai viet 5',2)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 25',N'Bai Viet 25',N'Noi dung bai viet 25',2)
INSERT INTO News (title, shortDescription, content, idCategory) VALUES (N'Bai Viet 20',N'Bai Viet 20',N'Noi dung bai viet 20',2)

DELETE FROM News WHERE News.id = 2 or News.id = 3
UPDATE News
SET title = ?, thumbnail = ?, shortDescription = ?, content = ?, idCategory = ?
WHERE id = ?;
SELECT * FROM Category

SELECT * FROM News
SELECT * FROM News ORDER BY id OFFSET 1 ROWS

SELECT * FROM News
SELECT * FROM News ORDER BY id OFFSET 0 ROWS FETCH NEXT 7 ROWS ONLY

SELECT * FROM News ORDER BY id 
SELECT * FROM News ORDER BY id
OFFSET 0 ROWS
FETCH NEXT 3 ROWS ONLY

SELECT COUNT(*) FROM News

SELECT * FROM Rolee
INSERT INTO Rolee(name, code) VALUES (N'Admin', 'admin')
INSERT INTO Rolee(name, code) VALUES (N'User', 'user')

SELECT * FROM Userr
INSERT INTO Userr(userName, passWord, fullName, status, idRole) VALUES ('username1','123456',N'Kim Hieu',1, 2)
INSERT INTO Userr(userName, passWord, fullName, status, idRole) VALUES ('username2','123456',N'Kuru',0, 2)
INSERT INTO Userr(userName, passWord, fullName, status, idRole) VALUES ('username3','123456',N'Tran Van',1, 2)
INSERT INTO Userr(userName, passWord, fullName, status, idRole) VALUES ('admin1','123456',N'Nguyen Kim',1, 1)
INSERT INTO Userr(userName, passWord, fullName, status, idRole) VALUES ('admin','123456',N'admin',1, 1)

SELECT * FROM Userr
JOIN Rolee ON Userr.idRole = Rolee.id
WHERE Userr.userName = 'username12' AND Userr.passWord = '12345622' OR 1=1 AND Userr.status = 1

SELECT * FROM News
