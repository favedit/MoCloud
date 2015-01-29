-- ------------------------------------------------------------
-- Create table [Data.Person.User]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER`;
CREATE TABLE `DT_PSN_USER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `PASSPORT`                      VARCHAR(40), 
   `PASSWORD`                      VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER 
   ADD CONSTRAINT DT_PSN_USR_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Type]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_TYPE`;
CREATE TABLE `DT_RES_TYPE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `ICON_URL`                      VARCHAR(400), 
   `DISPLAY_CD`                    INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_TYPE 
   ADD CONSTRAINT DT_RES_TYP_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Resource]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_RESOURCE`;
CREATE TABLE `DT_RES_RESOURCE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `TYPE_ID`                       BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(200), 
   `DISPLAY_CD`                    INTEGER, 
   `DISPLAY_ORDER`                 INTEGER DEFAULT 0, 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_RESOURCE 
   ADD CONSTRAINT DT_RES_RES_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_RESOURCE ADD CONSTRAINT DT_RES_RES_FK_TYP 
      FOREIGN KEY (`TYPE_ID`) REFERENCES DT_RES_TYPE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Bitmap]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_BITMAP`;
CREATE TABLE `DT_RES_BITMAP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_BITMAP 
   ADD CONSTRAINT DT_RES_BMP_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Bitmap.Image]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_BITMAP_IMAGE`;
CREATE TABLE `DT_RES_BITMAP_IMAGE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `BITMAP_ID`                     BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `FORMAT_CODE`                   VARCHAR(40), 
   `SIZE_WIDTH`                    INTEGER, 
   `SIZE_HEIGHT`                   INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_BITMAP_IMAGE 
   ADD CONSTRAINT DT_RES_BMP_IMG_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_BITMAP_IMAGE ADD CONSTRAINT DT_RES_BMP_IMG_FK_BMP 
      FOREIGN KEY (`BITMAP_ID`) REFERENCES DT_RES_BITMAP(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Texture]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEXTURE`;
CREATE TABLE `DT_RS3_TEXTURE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEXTURE 
   ADD CONSTRAINT DT_RS3_TXT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Texture.Bitmap]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEXTURE_BITMAP`;
CREATE TABLE `DT_RS3_TEXTURE_BITMAP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `TEXTURE_ID`                    BIGINT NOT NULL, 
   `BITMAP_ID`                     BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEXTURE_BITMAP 
   ADD CONSTRAINT DT_RS3_TXT_BMP_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_TEXTURE_BITMAP ADD CONSTRAINT DT_RS3_TXT_BMP_FK_TXT 
      FOREIGN KEY (`TEXTURE_ID`) REFERENCES DT_RS3_TEXTURE(`OUID`); 

ALTER TABLE DT_RS3_TEXTURE_BITMAP ADD CONSTRAINT DT_RS3_TXT_BMP_FK_BMP 
      FOREIGN KEY (`BITMAP_ID`) REFERENCES DT_RES_BITMAP(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Model]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MODEL`;
CREATE TABLE `DT_RS3_MODEL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MODEL 
   ADD CONSTRAINT DT_RS3_MOD_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Model.Mesh]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MODEL_MESH`;
CREATE TABLE `DT_RS3_MODEL_MESH` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `MODEL_ID`                      BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MODEL_MESH 
   ADD CONSTRAINT DT_RS3_MOD_MSH_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MODEL_MESH ADD CONSTRAINT DT_RS3_MOD_MSH_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RS3_MODEL(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Model.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MODEL_STREAM`;
CREATE TABLE `DT_RS3_MODEL_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `MODEL_ID`                      BIGINT, 
   `MESH_ID`                       BIGINT, 
   `CODE`                          VARCHAR(80), 
   `ELEMENT_DATA_CD`               INTEGER, 
   `ELEMENT_COUNT`                 INTEGER, 
   `DATA_STRIDE`                   INTEGER, 
   `DATA_COUNT`                    INTEGER, 
   `DATA_LENGTH`                   INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MODEL_STREAM 
   ADD CONSTRAINT DT_RS3_MOD_STM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MODEL_STREAM ADD CONSTRAINT DT_RS3_MOD_STM_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RS3_MODEL(`OUID`); 

ALTER TABLE DT_RS3_MODEL_STREAM ADD CONSTRAINT DT_RS3_MOD_STM_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RS3_MODEL_MESH(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Material]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MATERIAL`;
CREATE TABLE `DT_RS3_MATERIAL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MATERIAL 
   ADD CONSTRAINT DT_RS3_MTL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Material.Texture]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MATERIAL_TEXTURE`;
CREATE TABLE `DT_RS3_MATERIAL_TEXTURE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MATERIAL_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `TEXTURE_ID`                    BIGINT, 
   `TEXTURE_BITMAP_ID`             BIGINT, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MATERIAL_TEXTURE 
   ADD CONSTRAINT DT_RS3_MTL_TXT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MATERIAL_TEXTURE ADD CONSTRAINT DT_RS3_MTL_TXT_FK_MTL 
      FOREIGN KEY (`MATERIAL_ID`) REFERENCES DT_RS3_MATERIAL(`OUID`); 

ALTER TABLE DT_RS3_MATERIAL_TEXTURE ADD CONSTRAINT DT_RS3_MTL_TXT_FK_TXT 
      FOREIGN KEY (`TEXTURE_ID`) REFERENCES DT_RS3_TEXTURE(`OUID`); 

ALTER TABLE DT_RS3_MATERIAL_TEXTURE ADD CONSTRAINT DT_RS3_MTL_TXT_FK_TXT_BMP 
      FOREIGN KEY (`TEXTURE_BITMAP_ID`) REFERENCES DT_RS3_TEXTURE_BITMAP(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Template]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEMPLATE`;
CREATE TABLE `DT_RS3_TEMPLATE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEMPLATE 
   ADD CONSTRAINT DT_RS3_TPL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Scene]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SCENE`;
CREATE TABLE `DT_RS3_SCENE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GVID`                          VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_SCENE 
   ADD CONSTRAINT DT_RS3_SCN_UK_GID UNIQUE ( GUID ); 
