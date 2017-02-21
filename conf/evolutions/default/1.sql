# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table product (
  id                        integer auto_increment not null,
  title                     varchar(255),
  type                      varchar(255),
  category                  integer,
  description               varchar(255),
  time                      datetime,
  imgmin                    varchar(255),
  updated_date              datetime,
  deleted                   integer,
  imgnomal                  varchar(255),
  created_date              datetime,
  visible                   integer,
  imgmax                    varchar(255),
  country                   integer,
  linkvideo                 varchar(255),
  rate                      varchar(255),
  constraint pk_product primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table product;

SET FOREIGN_KEY_CHECKS=1;

