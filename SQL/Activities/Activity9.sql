REM   Script: Activity9
REM   Activity9

create table customers ( 
    customer_id int primary key, customer_name varchar(32), 
    city varchar(20), grade int, salesman_id int);

insert all 
into customers values(3002, 'Nick Rimando', 'New York', 100, 5001) 
into customers values(3007, 'Brad Davis', 'New York', 200, 5001) 
into customers values(3005, 'Graham Zusi', 'California', 200, 5002) 
into customers values(3008, 'Julian Green', 'London', 300, 5002) 
into customers values(3004, 'Fabian Johnson', 'Paris', 300, 5006) 
into customers values(3009, 'Geoff Cameron', 'Berlin', 100, 5003) 
into customers values(3003, 'Jozy Altidor', 'Moscow', 200, 5007) 
into customers values(3001, 'Brad Guzan', 'London', 300, 5005) 
SELECT 1 FROM DUAL;

SELECT a.customer_name AS "Customer Name", a.city, b.salesman_name AS "Salesman", b.commission FROM customers a  
INNER JOIN salesman b ON a.salesman_id=b.salesman_id;

SELECT a.customer_name, a.city, a.grade, b.salesman_name AS "Salesman", b.salesman_city FROM customers a  
LEFT OUTER JOIN salesman b ON a.salesman_id=b.salesman_id WHERE a.grade<300  
ORDER BY a.customer_id;

