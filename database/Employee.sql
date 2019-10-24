create database sqlpractice;

use sqlpractice;

create table employee(
	empno int primary key not null,
    empname varchar(20),
    dept varchar(20),
    desig varchar(20),
    basic int
    );
    
insert into employee values
(1,"sai","java","training",10000),
(2,"yaswanth","python","training",20000),
(3,"uttam","C","master",30000),
(4,"venkat","C++","master",40000),
(5,"vinod","java","master",50000),
(6,"prem","oracle","training",60000),
(7,"raghu","dotnet","master",70000),
(8,"amit","java","training",80000),
(9,"yash","python","master",90000),
(10,"tushar","dotnet","training",90000);

select * from employee;