--------------------------------------------------------
--  DDL for Table MSI_USER_PROFILE
--------------------------------------------------------

  CREATE TABLE "USER_PROFILE"
   (	"ID" NUMBER,
	"TYPE" VARCHAR2(100 BYTE)
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;


--------------------------------------------------------
--  DDL for Sequence USER_PROFILE_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "USER_PROFILE_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
REM INSERTING into USER_PROFILE
SET DEFINE OFF;
Insert into USER_PROFILE (ID,TYPE) values (1,'ROLE_ADMIN');
Insert into USER_PROFILE (ID,TYPE) values (2,'ROLE_USER');


--------------------------------------------------------
--  DDL for Index USER_PROFILE_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER_PROFILE_PK" ON "USER_PROFILE" ("ID")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;


--------------------------------------------------------
--  DDL for Index USER_PROFILE_UK1
--------------------------------------------------------

  CREATE UNIQUE INDEX "USER_PROFILE_UK1" ON "USER_PROFILE" ("TYPE")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;


  --------------------------------------------------------
--  DDL for Trigger USER_PROFILE_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "USER_PROFILE_TRG"
BEFORE INSERT ON USER_PROFILE
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT USER_PROFILE_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;

/
ALTER TRIGGER "USER_PROFILE_TRG" ENABLE;

--------------------------------------------------------
--  Constraints for Table USER_PROFILE
--------------------------------------------------------

  ALTER TABLE "USER_PROFILE" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "USER_PROFILE" MODIFY ("TYPE" NOT NULL ENABLE);
  ALTER TABLE "USER_PROFILE" ADD CONSTRAINT "USER_PROFILE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "USER_PROFILE" ADD CONSTRAINT "USER_PROFILE_UK1" UNIQUE ("TYPE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;