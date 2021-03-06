

-----------

  CREATE TABLE "PRODUCTS"
   (	"ID" NUMBER,
	"NAME" VARCHAR2(255 BYTE),
	"BRAND" VARCHAR2(255 BYTE),
	"PRICE" NUMBER,
	"STOCK" NUMBER,
	"IMAGE" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT
  )

----------

  CREATE SEQUENCE  "PRODUCTS_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20
  NOORDER  NOCYCLE ;
REM INSERTING into PRODUCTS
SET DEFINE OFF;
Insert into PRODUCTS (ID,NAME,BRAND,PRICE,STOCK,IMAGE) values (1,'Paper','Staples',10,100,null);
Insert into PRODUCTS (ID,NAME,BRAND,PRICE,STOCK,IMAGE) values (2,'Water','Costco',20,200,null);
Insert into PRODUCTS (ID,NAME,BRAND,PRICE,STOCK,IMAGE) values (3,'Milk','Wholefoods',30,300,null);

---------------

CREATE UNIQUE INDEX "PRODUCTS_PK" ON "PRODUCTS" ("ID")
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
--------------------------------------------------------
--  DDL for Trigger PRODUCTS_TRG
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "PRODUCTS_TRG"
BEFORE INSERT ON PRODUCTS
FOR EACH ROW
BEGIN
  <<COLUMN_SEQUENCES>>
  BEGIN
    IF INSERTING AND :NEW.ID IS NULL THEN
      SELECT PRODUCTS_SEQ.NEXTVAL INTO :NEW.ID FROM SYS.DUAL;
    END IF;
  END COLUMN_SEQUENCES;
END;
/
ALTER TRIGGER "PRODUCTS_TRG" ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCTS
--------------------------------------------------------

  ALTER TABLE "PRODUCTS" MODIFY ("ID" NOT NULL ENABLE);
  ALTER TABLE "PRODUCTS" MODIFY ("NAME" NOT NULL ENABLE);
  ALTER TABLE "PRODUCTS" ADD CONSTRAINT "PRODUCTS_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
