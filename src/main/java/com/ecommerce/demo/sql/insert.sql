REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (USERNAME,PASSWORD,ID) values ('admin','$2a$11$aL.ou06hFDE1p23WLTf6..yeq879FxCWZEE8ATEzkU/lw/Utaut2m',1);
Insert into USERS (USERNAME,PASSWORD,ID) values ('user','$2a$11$D031sn4yBKa8m3KmUc.fGuvjCwwyadyrVgfU3SH23McMenLj9chF.',2);


REM INSERTING into USER_DETAIL
SET DEFINE OFF;


REM INSERTING into USERS_USER_PROFILE
SET DEFINE OFF;


Insert into USERS_USER_PROFILE (ID,USER_ID,USER_PROFILE_ID) values (2,2,2);
Insert into USERS_USER_PROFILE (ID,USER_ID,USER_PROFILE_ID) values (1,1,1);
REM INSERTING into USERS_USER_PROFILE
SET DEFINE OFF;
Insert into USER_PROFILE (ID,TYPE) values (1,'ROLE_ADMIN');
Insert into USER_PROFILE (ID,TYPE) values (2,'ROLE_USER');
