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
-- Create table [Data.Solution.Project]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_SOL_PROJECT`;
CREATE TABLE `DT_SOL_PROJECT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT NOT NULL, 
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

ALTER TABLE DT_SOL_PROJECT 
   ADD CONSTRAINT DT_SOL_PRJ_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_SOL_PROJECT ADD CONSTRAINT DT_SOL_PRJ_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

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
   `ICON_URL`                      VARCHAR(200), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_TYPE 
   ADD CONSTRAINT DT_RES_TYP_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Catalog]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_CATALOG`;
CREATE TABLE `DT_RES_CATALOG` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `PARENT_ID`                     BIGINT, 
   `FULL_CODE`                     VARCHAR(2000), 
   `CODE`                          VARCHAR(80), 
   `FULL_LABEL`                    VARCHAR(2000), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `ICON_URL`                      VARCHAR(200), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_CATALOG 
   ADD CONSTRAINT DT_RES_CTG_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_CATALOG ADD CONSTRAINT DT_RES_CTG_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_CATALOG ADD CONSTRAINT DT_RES_CTG_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Resource]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_RESOURCE`;
CREATE TABLE `DT_RES_RESOURCE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `TYPE_ID`                       BIGINT, 
   `CATALOG_ID`                    BIGINT, 
   `RESOURCE_CD`                   INTEGER, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `ICON_URL`                      VARCHAR(200), 
   `HAS_PREVIEW`                   TINYINT, 
   `DESCRIPTION`                   VARCHAR(2000), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_RESOURCE 
   ADD CONSTRAINT DT_RES_RES_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_RESOURCE ADD CONSTRAINT DT_RES_RES_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_RESOURCE ADD CONSTRAINT DT_RES_RES_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_RESOURCE ADD CONSTRAINT DT_RES_RES_FK_TYP 
      FOREIGN KEY (`TYPE_ID`) REFERENCES DT_RES_TYPE(`OUID`); 

ALTER TABLE DT_RES_RESOURCE ADD CONSTRAINT DT_RES_RES_FK_CTG 
      FOREIGN KEY (`CATALOG_ID`) REFERENCES DT_RES_CATALOG(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Bitmap]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_BITMAP`;
CREATE TABLE `DT_RES_BITMAP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `RESOURCE_ID`                   BIGINT, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `FORMAT_CODE`                   VARCHAR(80), 
   `SIZE_WIDTH`                    INTEGER, 
   `SIZE_HEIGHT`                   INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_BITMAP 
   ADD CONSTRAINT DT_RES_BMP_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_BITMAP ADD CONSTRAINT DT_RES_BMP_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_BITMAP ADD CONSTRAINT DT_RES_BMP_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_BITMAP ADD CONSTRAINT DT_RES_BMP_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Material]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MATERIAL`;
CREATE TABLE `DT_RES_MATERIAL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `RESOURCE_ID`                   BIGINT, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MATERIAL 
   ADD CONSTRAINT DT_RES_MTL_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MATERIAL ADD CONSTRAINT DT_RES_MTL_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MATERIAL ADD CONSTRAINT DT_RES_MTL_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MATERIAL ADD CONSTRAINT DT_RES_MTL_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Material.Bitmap]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MATERIAL_BITMAP`;
CREATE TABLE `DT_RES_MATERIAL_BITMAP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MATERIAL_ID`                   BIGINT NOT NULL, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `BITMAP_ID`                     BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MATERIAL_BITMAP 
   ADD CONSTRAINT DT_RES_MTL_BMP_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MATERIAL_BITMAP ADD CONSTRAINT DT_RES_MTL_BMP_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MATERIAL_BITMAP ADD CONSTRAINT DT_RES_MTL_BMP_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MATERIAL_BITMAP ADD CONSTRAINT DT_RES_MTL_BMP_FK_MTL 
      FOREIGN KEY (`MATERIAL_ID`) REFERENCES DT_RES_MATERIAL(`OUID`); 

ALTER TABLE DT_RES_MATERIAL_BITMAP ADD CONSTRAINT DT_RES_MTL_BMP_FK_BMP 
      FOREIGN KEY (`BITMAP_ID`) REFERENCES DT_RES_BITMAP(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL`;
CREATE TABLE `DT_RES_MODEL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `RESOURCE_ID`                   BIGINT, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL 
   ADD CONSTRAINT DT_RES_MOD_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL ADD CONSTRAINT DT_RES_MOD_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL ADD CONSTRAINT DT_RES_MOD_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL ADD CONSTRAINT DT_RES_MOD_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Mesh]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_MESH`;
CREATE TABLE `DT_RES_MODEL_MESH` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `SORT_INDEX`                    INTEGER, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `OUTLINE_MIN`                   VARCHAR(80), 
   `OUTLINE_MAX`                   VARCHAR(80), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL_MESH 
   ADD CONSTRAINT DT_RES_MOD_MSH_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_MESH ADD CONSTRAINT DT_RES_MOD_MSH_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_MESH ADD CONSTRAINT DT_RES_MOD_MSH_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_MESH ADD CONSTRAINT DT_RES_MOD_MSH_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Mesh.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_MESH_STREAM`;
CREATE TABLE `DT_RES_MODEL_MESH_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `MESH_ID`                       BIGINT, 
   `SORT_INDEX`                    INTEGER, 
   `FULL_CODE`                     VARCHAR(200), 
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

ALTER TABLE DT_RES_MODEL_MESH_STREAM 
   ADD CONSTRAINT DT_RES_MOD_MSH_STM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_MESH_STREAM ADD CONSTRAINT DT_RES_MOD_MSH_STM_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_MESH_STREAM ADD CONSTRAINT DT_RES_MOD_MSH_STM_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_MESH_STREAM ADD CONSTRAINT DT_RES_MOD_MSH_STM_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

ALTER TABLE DT_RES_MODEL_MESH_STREAM ADD CONSTRAINT DT_RES_MOD_MSH_STM_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RES_MODEL_MESH(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Skeleton]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_SKELETON`;
CREATE TABLE `DT_RES_MODEL_SKELETON` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL_SKELETON 
   ADD CONSTRAINT DT_RES_MOD_SKT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_SKELETON ADD CONSTRAINT DT_RES_MOD_SKT_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON ADD CONSTRAINT DT_RES_MOD_SKT_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Skeleton.Skin]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_SKELETON_SKIN`;
CREATE TABLE `DT_RES_MODEL_SKELETON_SKIN` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
   `MESH_ID`                       BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN 
   ADD CONSTRAINT DT_RES_MOD_SKT_SKN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RES_MODEL_SKELETON(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RES_MODEL_MESH(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Skeleton.Skin.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_SKELETON_SKIN_STREAM`;
CREATE TABLE `DT_RES_MODEL_SKELETON_SKIN_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `MESH_ID`                       BIGINT, 
   `SKELETON_ID`                   BIGINT, 
   `SKIN_ID`                       BIGINT, 
   `SORT_INDEX`                    INTEGER, 
   `FULL_CODE`                     VARCHAR(200), 
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

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM 
   ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RES_MODEL_MESH(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RES_MODEL_SKELETON(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RES_MOD_SKT_SKN_STM_FK_SKN 
      FOREIGN KEY (`SKIN_ID`) REFERENCES DT_RES_MODEL_SKELETON_SKIN(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Animation]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_ANIMATION`;
CREATE TABLE `DT_RES_MODEL_ANIMATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `SKELETON_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `FRAME_COUNT`                   INTEGER, 
   `FRAME_TICK`                    INTEGER, 
   `FRAME_SPAN`                    INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL_ANIMATION 
   ADD CONSTRAINT DT_RES_MOD_ANM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_ANIMATION ADD CONSTRAINT DT_RES_MOD_ANM_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION ADD CONSTRAINT DT_RES_MOD_ANM_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION ADD CONSTRAINT DT_RES_MOD_ANM_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION ADD CONSTRAINT DT_RES_MOD_ANM_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RES_MODEL_SKELETON(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Animation.Track]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_ANIMATION_TRACK`;
CREATE TABLE `DT_RES_MODEL_ANIMATION_TRACK` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `SKELETON_ID`                   BIGINT, 
   `ANIMATION_ID`                  BIGINT NOT NULL, 
   `MESH_ID`                       BIGINT, 
   `BONE_INDEX`                    INTEGER, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `FRAME_TICK`                    INTEGER, 
   `FRAME_COUNT`                   INTEGER, 
   `FRAME_TOTAL`                   INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK 
   ADD CONSTRAINT DT_RES_MOD_ANM_TCK_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RES_MODEL_SKELETON(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RES_MODEL_ANIMATION(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RES_MODEL_MESH(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Model.Animation.Action]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_MODEL_ANIMATION_ACTION`;
CREATE TABLE `DT_RES_MODEL_ANIMATION_ACTION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT, 
   `ANIMATION_ID`                  BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `FRAME_BEGIN`                   INTEGER, 
   `FRAME_END`                     INTEGER, 
   `FRAME_RATE`                    FLOAT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_MODEL_ANIMATION_ACTION 
   ADD CONSTRAINT DT_RES_MOD_ANM_ACT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_MODEL_ANIMATION_ACTION ADD CONSTRAINT DT_RES_MOD_ANM_ACT_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_ACTION ADD CONSTRAINT DT_RES_MOD_ANM_ACT_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_ACTION ADD CONSTRAINT DT_RES_MOD_ANM_ACT_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RES_MODEL(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_ACTION ADD CONSTRAINT DT_RES_MOD_ANM_ACT_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RES_MODEL_ANIMATION(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Template]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_TEMPLATE`;
CREATE TABLE `DT_RES_TEMPLATE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `RESOURCE_ID`                   BIGINT, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       MEDIUMTEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_TEMPLATE 
   ADD CONSTRAINT DT_RES_TPL_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_TEMPLATE ADD CONSTRAINT DT_RES_TPL_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_TEMPLATE ADD CONSTRAINT DT_RES_TPL_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_TEMPLATE ADD CONSTRAINT DT_RES_TPL_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Template.Material]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_TEMPLATE_MATERIAL`;
CREATE TABLE `DT_RES_TEMPLATE_MATERIAL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `TEMPLATE_ID`                   BIGINT NOT NULL, 
   `MATERIAL_ID`                   BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_TEMPLATE_MATERIAL 
   ADD CONSTRAINT DT_RES_TPL_MTL_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_TEMPLATE_MATERIAL ADD CONSTRAINT DT_RES_TPL_MTL_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_TEMPLATE_MATERIAL ADD CONSTRAINT DT_RES_TPL_MTL_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_TEMPLATE_MATERIAL ADD CONSTRAINT DT_RES_TPL_MTL_FK_TPL 
      FOREIGN KEY (`TEMPLATE_ID`) REFERENCES DT_RES_TEMPLATE(`OUID`); 

ALTER TABLE DT_RES_TEMPLATE_MATERIAL ADD CONSTRAINT DT_RES_TPL_MTL_FK_MTL 
      FOREIGN KEY (`MATERIAL_ID`) REFERENCES DT_RES_MATERIAL(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Scene]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_SCENE`;
CREATE TABLE `DT_RES_SCENE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `RESOURCE_ID`                   BIGINT, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       MEDIUMTEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RES_SCENE 
   ADD CONSTRAINT DT_RES_SCN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RES_SCENE ADD CONSTRAINT DT_RES_SCN_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_RES_SCENE ADD CONSTRAINT DT_RES_SCN_FK_PRJ 
      FOREIGN KEY (`PROJECT_ID`) REFERENCES DT_SOL_PROJECT(`OUID`); 

ALTER TABLE DT_RES_SCENE ADD CONSTRAINT DT_RES_SCN_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 
