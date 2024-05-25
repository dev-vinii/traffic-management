CREATE SEQUENCE SEQ_TRAFFIC_LIGHT
    START WITH 1
    INCREMENT BY 1
    NOCACHE
    NOCYCLE;

CREATE TABLE tbl_traffic_light (
    traffic_light_id NUMBER(19) PRIMARY KEY,
    time_to_open NUMBER(10) NOT NULL,
    pedestrian_traffic_light BOOLEAN NOT NULL,
    brand VARCHAR2(255) NOT NULL,
    street_id NUMBER(19),
    CONSTRAINT fk_street
        FOREIGN KEY (street_id)
        REFERENCES tbl_street(street_id)
);