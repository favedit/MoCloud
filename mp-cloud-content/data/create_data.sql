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
-- Create table [Data.Resource3d.Texture]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEXTURE`;
CREATE TABLE `DT_RS3_TEXTURE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `RESOURCE_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEXTURE 
   ADD CONSTRAINT DT_RS3_TXT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_TEXTURE ADD CONSTRAINT DT_RS3_TXT_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Texture.Bitmap]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEXTURE_BITMAP`;
CREATE TABLE `DT_RS3_TEXTURE_BITMAP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `TEXTURE_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `VERSION_NUMBER`                INTEGER, 
   `SIZE_WIDTH`                    INTEGER, 
   `SIZE_HEIGHT`                   INTEGER, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEXTURE_BITMAP 
   ADD CONSTRAINT DT_RS3_TXT_BMP_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_TEXTURE_BITMAP ADD CONSTRAINT DT_RS3_TXT_BMP_FK_TXT 
      FOREIGN KEY (`TEXTURE_ID`) REFERENCES DT_RS3_TEXTURE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Material]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MATERIAL`;
CREATE TABLE `DT_RS3_MATERIAL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `RESOURCE_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `DIFFUSE_COLOR`                 VARCHAR(64), 
   `SPECULAR_COLOR`                VARCHAR(64), 
   `EMISSIVE_COLOR`                VARCHAR(64), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MATERIAL 
   ADD CONSTRAINT DT_RS3_MTL_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MATERIAL ADD CONSTRAINT DT_RS3_MTL_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

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
-- Create table [Data.Resource3d.Geometry]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_GEOMETRY`;
CREATE TABLE `DT_RS3_GEOMETRY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `RESOURCE_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `VERTEX_COUNT`                  INTEGER, 
   `INDEX_COUNT`                   INTEGER DEFAULT 0, 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_GEOMETRY 
   ADD CONSTRAINT DT_RS3_GTY_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_GEOMETRY ADD CONSTRAINT DT_RS3_GTY_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Geometry.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_GEOMETRY_STREAM`;
CREATE TABLE `DT_RS3_GEOMETRY_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `GEOMETRY_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FORMAT_CD`                     INTEGER, 
   `DATA_STRIDE`                   INTEGER, 
   `DATA_COUNT`                    INTEGER, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_GEOMETRY_STREAM 
   ADD CONSTRAINT DT_RS3_GTY_STM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_GEOMETRY_STREAM ADD CONSTRAINT DT_RS3_GTY_STM_FK_GTY 
      FOREIGN KEY (`GEOMETRY_ID`) REFERENCES DT_RS3_GEOMETRY(`OUID`); 
