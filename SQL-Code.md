```
create database food;
use food;

create table users(
userId int not null,
userAge int not null,
userName varchar(255) not null,
userAddress varchar(255) not null,
userEmail varchar(255) not null,
userNumber int(10) not null,
userPassword varchar(255) not null,
primary key(userId)
);

create table resturants(
resId int not null,
resName varchar(255) not null,
resRegNo varchar(255) not null,
resStatus varchar(8) not null,
resAddress varchar(255) not null,
resEmail varchar(255) not null,
resPassword varchar(255) not null,
primary key(resId)
);

create table food(
foodId int not null,
foodName varchar(255) not null UNIQUE,
primary key(foodId)
);

create table menu(
menuId int not null,
resId int not null,
foodId int not null,
foodPrice int not null,
FOREIGN KEY (resId) REFERENCES resturants(resId),
FOREIGN KEY (foodId) REFERENCES food(foodId),
primary key(menuId)
);

create table orders(
orderId int not null,
userId int not null,
menuId int not null,
unitPrice int not null,
quantity int not null,
FOREIGN KEY (userId) REFERENCES users(userId),
FOREIGN KEY (menuId) REFERENCES menu(menuId),
primary key(orderId)
);

create table administrator(
adminId int not null,
userName varchar(255) not null,
pass varchar(255) not null,
adminName varchar(255) not null,
primary key(adminId)
);
```
