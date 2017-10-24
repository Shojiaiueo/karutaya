
drop database if exists mastercard;
create database mastercard;
use mastercard;

create table credit_card(
login_id varchar(10) not null primary key comment 'ログインID',
name_e varchar(50) not null comment '姓名(ローマ字)',
credit_number varchar(16) not null unique comment 'クレジット番号',
security_code varchar(4) not null comment 'セキュリティコード',
id_number varchar(4) not null comment '暗証番号',
credit_limit int not null comment '利用限度額',
register_day datetime not null comment '登録日',
update_day datetime not null comment '更新日',
delete_flg boolean default false comment '削除フラグ',
expiration_year int(11) not null comment '有効期限（年）',
expiration_month int(11) not null comment '有効期限（月）',
spend int(11) default 0 comment 'ご利用金額'
);

insert into credit_card(login_id,name_e,credit_number,security_code,id_number,credit_limit,register_day,update_day,delete_flg,expiration_year,expiration_month,spend)values
("hidekisama","KUDOHIDEKI","5555557891234567","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("kudo","IKEMENKUDO","5555555665877458","4567","4567","456430","2202-08-17 15:16:00","2016-06-17 12:25:00",false,"2019","6","20000"),
("1","test","5555550000000001","001","0001","100000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("2","test","5555550000000002","002","0002","200000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("3","test","5555550000000003","003","0003","300000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("4","test","5555550000000004","004","0004","400000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("5","test","5555550000000005","005","0005","500000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("6","test","5555550000000006","006","0006","600000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("7","test","5555550000000007","007","0007","700000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("8","test","5555550000000008","008","0008","800000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("9","test","5555550000000009","009","0009","900000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("10","test","5555550000000010","010","0010","100000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("11","test","5555550000000011","011","0011","110000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000"),
("12","test","5555550000000012","012","0012","120000","2202-08-27 15:16:00","2016-06-27 12:25:00",false,"2019","6","20000")
;


drop database if exists americanexpress;
create database americanexpress;
use americanexpress;

create table credit_card(
login_id varchar(10) not null primary key comment 'ログインID',
name_e varchar(50) not null comment '姓名(ローマ字)',
credit_number varchar(16) not null unique comment 'クレジット番号',
security_code varchar(4) not null comment 'セキュリティコード',
id_number varchar(4) not null comment '暗証番号',
credit_limit int not null comment '利用限度額',
register_day datetime not null comment '登録日',
update_day datetime not null comment '更新日',
delete_flg boolean default false comment '削除フラグ',
expiration_year int(11) not null comment '有効期限（年）',
expiration_month int(11) not null comment '有効期限（月）',
spend int(11) default 0 comment 'ご利用金額'
);

insert into credit_card(login_id,name_e,credit_number,security_code,id_number,credit_limit,register_day,update_day,delete_flg,expiration_year,expiration_month,spend)values
("hidekisama","KUDO HIDEKI","378282789023456","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("1","testuser","378282789011111","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("2","testuser","378282789022222","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("3","testuser","378282789033333","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("4","testuser","378282789044444","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("5","testuser","378282789055555","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("6","testuser","378282789066666","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("7","testuser","378282789077777","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("8","testuser","378282789088888","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10"),
("9","testuser","378282789099999","1234","1234","100000","2016-06-17 13:16:00","2018-06-17 13:25:00",false,"2019","6","10");





drop database if exists visa;
create database visa;
use visa;

create table credit_card(
login_id varchar(10) not null primary key comment 'ログインID',
name_e varchar(50) not null comment '姓名(ローマ字)',
credit_number varchar(16) not null unique comment 'クレジット番号',
security_code varchar(4) not null comment 'セキュリティコード',
id_number varchar(4) not null comment '暗証番号',
credit_limit int not null comment '利用限度額',
register_day datetime not null comment '登録日',
update_day datetime not null comment '更新日',
delete_flg boolean default false comment '削除フラグ',
expiration_year int(11) not null comment '有効期限（年）',
expiration_month int(11) not null comment '有効期限（月）',
spend int(11) default 0 comment 'ご利用金額'
);

insert into credit_card(login_id,name_e,credit_number,security_code,id_number,credit_limit,register_day,update_day,delete_flg,expiration_year,expiration_month,spend)values
("1","testuser","4123123441234123","123","1234","100000","2016-06-17 13:16:00","2016-07-17 13:25:00",false,2019,7,20000),
("2","testuser","4111111111111112","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("3","testuser","4111111111111113","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("4","testuser","4111111111111114","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("5","testuser","4111111111111115","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("6","testuser","4111111111111116","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("7","testuser","4111111111111117","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("8","testuser","4111111111111118","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("9","testuser","4111111111111119","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("10","testuser","412312344123456","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("11","testuser","411111111111122","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("12","testuser","411111111111121","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000),
("13","testuser","411111111111123","123","1234","100000","2016-06-17 13:16:00","2016-06-17 13:25:00",false,2019,7,20000);





