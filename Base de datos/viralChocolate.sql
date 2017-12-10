/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     9/12/2017 19:52:08                           */
/*==============================================================*/


drop table if exists ALARMA;

drop table if exists CIUDAD;

drop table if exists COMENTARIO;

drop table if exists DETALLE_PUBLICACION;

drop table if exists HASHTAG;

drop table if exists LOCALIZACION;

drop table if exists PUBLICACION;

drop table if exists PUBLICACION_DESTACADA;

drop table if exists REPORTE;

drop table if exists TIPO_PUBLICACION;

drop table if exists USUARIO;

drop table if exists USUARIO_DESTACADO;

/*==============================================================*/
/* Table: ALARMA                                                */
/*==============================================================*/
create table ALARMA
(
   COD_ALARMA           int not null auto_increment,
   COD_PUBLICACION_DESTACADA int not null,
   DESCRIPCION          varchar(512) not null,
   primary key (COD_ALARMA, COD_PUBLICACION_DESTACADA)
);

/*==============================================================*/
/* Table: CIUDAD                                                */
/*==============================================================*/
create table CIUDAD
(
   COD_CIUDAD           varchar(10) not null,
   NOMBRE               varchar(512) not null,
   primary key (COD_CIUDAD)
);

/*==============================================================*/
/* Table: COMENTARIO                                            */
/*==============================================================*/
create table COMENTARIO
(
   COD_COMENTARIO       int not null auto_increment,
   COD_PUBLICACION      int,
   COD_USUARIO          int,
   COD_TIPO_PUBLICACION varchar(10),
   DESCRIPCION          varchar(512) not null,
   primary key (COD_COMENTARIO)
);

/*==============================================================*/
/* Table: DETALLE_PUBLICACION                                   */
/*==============================================================*/
create table DETALLE_PUBLICACION
(
   COD_DETALLE_PUBLICACION int not null auto_increment,
   COD_HASHTAG          int,
   COD_PUBLICACION      int,
   COD_USUARIO          int,
   COD_TIPO_PUBLICACION varchar(10),
   COD_LOCALIZACION     int,
   FECHA                date not null,
   DESCRIPCION          varchar(512),
   primary key (COD_DETALLE_PUBLICACION)
);

/*==============================================================*/
/* Table: HASHTAG                                               */
/*==============================================================*/
create table HASHTAG
(
   COD_HASHTAG          int not null auto_increment,
   DESCRIPCION          varchar(512) not null,
   primary key (COD_HASHTAG)
);

/*==============================================================*/
/* Table: LOCALIZACION                                          */
/*==============================================================*/
create table LOCALIZACION
(
   COD_LOCALIZACION     int not null auto_increment,
   COD_CIUDAD           varchar(10),
   LONGITUD             numeric(10,6) not null,
   LATITUD              numeric(10,6) not null,
   primary key (COD_LOCALIZACION)
);

/*==============================================================*/
/* Table: PUBLICACION                                           */
/*==============================================================*/
create table PUBLICACION
(
   COD_PUBLICACION      int not null auto_increment,
   COD_USUARIO          int not null,
   COD_TIPO_PUBLICACION varchar(10) not null,
   LIKES                numeric(10,0),
   primary key (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION)
);

/*==============================================================*/
/* Table: PUBLICACION_DESTACADA                                 */
/*==============================================================*/
create table PUBLICACION_DESTACADA
(
   COD_PUBLICACION_DESTACADA int not null auto_increment,
   COD_PUBLICACION      int,
   COD_USUARIO          int,
   COD_TIPO_PUBLICACION varchar(10),
   NUMERO_LIKES         numeric(15,0) not null,
   NUMERO_COMENTARIOS   numeric(15,0) not null,
   primary key (COD_PUBLICACION_DESTACADA)
);

/*==============================================================*/
/* Table: REPORTE                                               */
/*==============================================================*/
create table REPORTE
(
   COD_REPORTE          int not null auto_increment,
   COD_PUBLICACION_DESTACADA int not null,
   DESCRIPCION          varchar(512) not null,
   FECHA                date not null,
   primary key (COD_REPORTE, COD_PUBLICACION_DESTACADA)
);

/*==============================================================*/
/* Table: TIPO_PUBLICACION                                      */
/*==============================================================*/
create table TIPO_PUBLICACION
(
   COD_TIPO_PUBLICACION varchar(10) not null,
   DESCRIPCION          varchar(512) not null,
   primary key (COD_TIPO_PUBLICACION)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   COD_USUARIO          int not null auto_increment,
   NOMBRE               varchar(512) not null,
   primary key (COD_USUARIO)
);

/*==============================================================*/
/* Table: USUARIO_DESTACADO                                     */
/*==============================================================*/
create table USUARIO_DESTACADO
(
   COD_USUARIO_DESTACADO int not null auto_increment,
   COD_USUARIO          int not null,
   NUMERO_SEGUIDORES    numeric(10,0) not null,
   primary key (COD_USUARIO_DESTACADO, COD_USUARIO)
);

alter table ALARMA add constraint FK_REFERENCE_14 foreign key (COD_PUBLICACION_DESTACADA)
      references PUBLICACION_DESTACADA (COD_PUBLICACION_DESTACADA) on delete restrict on update restrict;

alter table COMENTARIO add constraint FK_REFERENCE_17 foreign key (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION)
      references PUBLICACION (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION) on delete restrict on update restrict;

alter table DETALLE_PUBLICACION add constraint FK_REFERENCE_18 foreign key (COD_HASHTAG)
      references HASHTAG (COD_HASHTAG) on delete restrict on update restrict;

alter table DETALLE_PUBLICACION add constraint FK_REFERENCE_19 foreign key (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION)
      references PUBLICACION (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION) on delete restrict on update restrict;

alter table DETALLE_PUBLICACION add constraint FK_REFERENCE_21 foreign key (COD_LOCALIZACION)
      references LOCALIZACION (COD_LOCALIZACION) on delete restrict on update restrict;

alter table LOCALIZACION add constraint FK_REFERENCE_11 foreign key (COD_CIUDAD)
      references CIUDAD (COD_CIUDAD) on delete restrict on update restrict;

alter table PUBLICACION add constraint FK_REFERENCE_15 foreign key (COD_USUARIO)
      references USUARIO (COD_USUARIO) on delete restrict on update restrict;

alter table PUBLICACION add constraint FK_REFERENCE_20 foreign key (COD_TIPO_PUBLICACION)
      references TIPO_PUBLICACION (COD_TIPO_PUBLICACION) on delete restrict on update restrict;

alter table PUBLICACION_DESTACADA add constraint FK_REFERENCE_13 foreign key (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION)
      references PUBLICACION (COD_PUBLICACION, COD_USUARIO, COD_TIPO_PUBLICACION) on delete restrict on update restrict;

alter table REPORTE add constraint FK_REFERENCE_12 foreign key (COD_PUBLICACION_DESTACADA)
      references PUBLICACION_DESTACADA (COD_PUBLICACION_DESTACADA) on delete restrict on update restrict;

alter table USUARIO_DESTACADO add constraint FK_REFERENCE_16 foreign key (COD_USUARIO)
      references USUARIO (COD_USUARIO) on delete restrict on update restrict;

