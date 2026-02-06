CREATE DATABASE timetravel_db;
USE timetravel_db;

CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    email VARCHAR(250) NOT NULL
);

CREATE TABLE time_machines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    capacity INT NOT NULL,
    status BOOLEAN NOT NULL
);

CREATE TABLE time_periods (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    description VARCHAR(500)
);

CREATE TABLE guides (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(200) NOT NULL,
    specialty VARCHAR(100)
);

CREATE TABLE bookings (
    id INT PRIMARY KEY AUTO_INCREMENT,
    customer_id INT NOT NULL,
    time_machine_id INT NOT NULL,
    time_period_id INT NOT NULL,
    guide_id INT NOT NULL,

    CONSTRAINT fk_customer FOREIGN KEY (customer_id) REFERENCES customers(id),
    CONSTRAINT fk_time_machine FOREIGN KEY (time_machine_id) REFERENCES time_machines(id),
    CONSTRAINT fk_time_period FOREIGN KEY (time_period_id) REFERENCES time_periods(id),
    CONSTRAINT fk_guide FOREIGN KEY (guide_id) REFERENCES guides(id);
);