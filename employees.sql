use d1;
drop table if exists employees;

create external table employees
(
emp_no INT,
birth_date TIMESTAMP,
first_name VARCHAR,
last_name VARCHAR,
gender VARCHAR,
hire_date TIMESTAMP
)
ROW FORMAT DELIMITED FIELDS TERMINATED BY ','
LOCATION '/user/cloudera/e1';

