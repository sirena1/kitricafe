drop table member_detail;

drop table member;

drop table postcode;

create table member
(
	id varchar2(16),
	name varchar2(20) not null,
	pass varchar2(16) not null,
	emailid varchar2(20),
	emaildomain varchar2(30),
	joindate date default sysdate,
	constraint member_id_pk primary key(id) 
);

create table member_detail
(
	id varchar2(16),
	tel1 varchar2(3),
	tel2 varchar2(4),
	tel3 varchar2(4),
	zipcode varchar2(5),
	address varchar2(100),
	address_detail varchar2(100),
	constraint member_detail_id_fk foreign key(id) references member(id)
);


create table POSTCODE
(
  NEW_POST_CODE          	NUMBER(30),
  SIDO_KOR               	VARCHAR2(200),
  SIDO_ENG               	VARCHAR2(30),
  GUGUN_KOR            		VARCHAR2(30),
  GUGUN_ENG            		VARCHAR2(30),
  UPMYON_KOR             	VARCHAR2(30),
  UPMYON_ENG             	VARCHAR2(200),
  DORO_NUMBER            	NUMBER(30),
  DORO_KOR               	VARCHAR2(100),
  DORO_ENG               	VARCHAR2(200),
  UNDOR_FLAG             	NUMBER(30),
  BUILDING_ORIGIN_NUMBER 	NUMBER(30),
  BUILDING_REFER_NUMBER  	NUMBER(30),
  BUILDING_MANAGE_NUMBER 	NUMBER(30),
  MULTI_DELIVER_NAME     	VARCHAR2(30),
  SIGUGUN_BUILDING_NAME   	VARCHAR2(200),
  LAW_DONG_NUMBER        	NUMBER(30),
  LAW_DONG_NAME          	VARCHAR2(30),
  RI_NAME                	VARCHAR2(30),
  ADMIN_DONG_NAME        	VARCHAR2(30),
  SAN_FLAG               	NUMBER(30),
  JIBEON_BONBEON         	NUMBER(30),
  UPMYONDONG_SEQ         	NUMBER(30),
  JIBEON_BUBEON          	NUMBER(30),
  OLD_POST_CODE          	VARCHAR2(30),
  POST_CODE_SEQ          	VARCHAR2(30)
);

