--------------------------------------------------------
--  DDL for Table USERS
--------------------------------------------------------

  CREATE TABLE "USERS" 
   (	"USERNAME" VARCHAR2(100 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"ID" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
--------------------------------------------------------
--  DDL for Sequence USERS_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "USERS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into USERS
SET DEFINE OFF;
Insert into USERS (USERNAME,PASSWORD,ID) values ('Zun','123',1);
Insert into USERS (USERNAME,PASSWORD,ID) values ('admin','000',2);
Insert into USERS (USERNAME,PASSWORD,ID) values ('Messi','goat',3);
--------------------------------------------------------
--  DDL for Index USERS_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERS_PK" ON "USERS" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
--------------------------------------------------------
--  DDL for Index USERS_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "USERS_UK1" ON "USERS" ("USERNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
--------------------------------------------------------
--  DDL for Trigger USERS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "USERS_TRG" 
BEFORE INSERT ON USERS 
FOR EACH ROW 
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.USERNAME IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.USERNAME FROM SYS.DUAL;
    END IF;
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USERS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "USERS_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table USERS
--------------------------------------------------------

  ALTER TABLE "USERS" MODIFY ("USERNAME" NOT NULL ENABLE);
  ALTER TABLE "USERS" MODIFY ("PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "USERS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "USERS" ADD CONSTRAINT "USERS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "USERS" ADD CONSTRAINT "USERS_UK1" UNIQUE ("USERNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)