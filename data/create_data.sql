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
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
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
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `BITMAP_ID`                     BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
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
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       TEXT, 
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
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `TEXTURE_ID`                    BIGINT NOT NULL, 
   `BITMAP_ID`                     BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `INDEX`                         INTEGER, 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CHANNELS`                      VARCHAR(40), 
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
-- Create table [Data.Resource3d.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_STREAM`;
CREATE TABLE `DT_RS3_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
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

ALTER TABLE DT_RS3_STREAM 
   ADD CONSTRAINT DT_RS3_STM_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Track]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TRACK`;
CREATE TABLE `DT_RS3_TRACK` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
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

ALTER TABLE DT_RS3_TRACK 
   ADD CONSTRAINT DT_RS3_TCK_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Animation]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_ANIMATION`;
CREATE TABLE `DT_RS3_ANIMATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
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

ALTER TABLE DT_RS3_ANIMATION 
   ADD CONSTRAINT DT_RS3_ANM_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Animation.Track]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_ANIMATION_TRACK`;
CREATE TABLE `DT_RS3_ANIMATION_TRACK` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `ANIMATION_ID`                  BIGINT NOT NULL, 
   `BONE_INDEX`                    INTEGER, 
   `TRACK_ID`                      BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_ANIMATION_TRACK 
   ADD CONSTRAINT DT_RS3_ANM_TCK_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_ANIMATION_TRACK ADD CONSTRAINT DT_RS3_ANM_TCK_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RS3_ANIMATION(`OUID`); 

ALTER TABLE DT_RS3_ANIMATION_TRACK ADD CONSTRAINT DT_RS3_ANM_TCK_FK_TCK 
      FOREIGN KEY (`TRACK_ID`) REFERENCES DT_RS3_TRACK(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Animation.Action]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_ANIMATION_ACTION`;
CREATE TABLE `DT_RS3_ANIMATION_ACTION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
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

ALTER TABLE DT_RS3_ANIMATION_ACTION 
   ADD CONSTRAINT DT_RS3_ANM_ACT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_ANIMATION_ACTION ADD CONSTRAINT DT_RS3_ANM_ACT_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RS3_ANIMATION(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Mesh.Skeleton]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SKELETON`;
CREATE TABLE `DT_RS3_SKELETON` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
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

ALTER TABLE DT_RS3_SKELETON 
   ADD CONSTRAINT DT_RS3_SKT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Skeleton.Skin]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SKELETON_SKIN`;
CREATE TABLE `DT_RS3_SKELETON_SKIN` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
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

ALTER TABLE DT_RS3_SKELETON_SKIN 
   ADD CONSTRAINT DT_RS3_SKT_SKN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_SKELETON_SKIN ADD CONSTRAINT DT_RS3_SKT_SKN_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RS3_SKELETON(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Skeleton.Skin.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SKELETON_SKIN_STREAM`;
CREATE TABLE `DT_RS3_SKELETON_SKIN_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
   `SKELETON_SKIN_ID`              BIGINT NOT NULL, 
   `STREAM_ID`                     BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_SKELETON_SKIN_STREAM 
   ADD CONSTRAINT DT_RS3_SKT_SKN_STM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RS3_SKT_SKN_STM_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RS3_SKELETON(`OUID`); 

ALTER TABLE DT_RS3_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RS3_SKT_SKN_STM_FK_SKN 
      FOREIGN KEY (`SKELETON_SKIN_ID`) REFERENCES DT_RS3_SKELETON_SKIN(`OUID`); 

ALTER TABLE DT_RS3_SKELETON_SKIN_STREAM ADD CONSTRAINT DT_RS3_SKT_SKN_STM_FK_STM 
      FOREIGN KEY (`STREAM_ID`) REFERENCES DT_RS3_STREAM(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Skeleton.Animation]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SKELETON_ANIMATION`;
CREATE TABLE `DT_RS3_SKELETON_ANIMATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
   `ANIMATION_ID`                  BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_SKELETON_ANIMATION 
   ADD CONSTRAINT DT_RS3_SKT_ANM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_SKELETON_ANIMATION ADD CONSTRAINT DT_RS3_SKT_ANM_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RS3_SKELETON(`OUID`); 

ALTER TABLE DT_RS3_SKELETON_ANIMATION ADD CONSTRAINT DT_RS3_SKT_ANM_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RS3_ANIMATION(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Mesh]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MESH`;
CREATE TABLE `DT_RS3_MESH` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
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

ALTER TABLE DT_RS3_MESH 
   ADD CONSTRAINT DT_RS3_MSH_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Mesh.Stream]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MESH_STREAM`;
CREATE TABLE `DT_RS3_MESH_STREAM` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MESH_ID`                       BIGINT NOT NULL, 
   `STREAM_ID`                     BIGINT NOT NULL, 
   `INDEX`                         INTEGER, 
   `CODE`                          VARCHAR(40), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MESH_STREAM 
   ADD CONSTRAINT DT_RS3_MSH_STM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MESH_STREAM ADD CONSTRAINT DT_RS3_MSH_STM_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RS3_MESH(`OUID`); 

ALTER TABLE DT_RS3_MESH_STREAM ADD CONSTRAINT DT_RS3_MSH_STM_FK_STM 
      FOREIGN KEY (`STREAM_ID`) REFERENCES DT_RS3_STREAM(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Mesh.Skin]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MESH_SKIN`;
CREATE TABLE `DT_RS3_MESH_SKIN` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MESH_ID`                       BIGINT NOT NULL, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
   `SKELETON_SKIN_ID`              BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MESH_SKIN 
   ADD CONSTRAINT DT_RS3_MSH_SKN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MESH_SKIN ADD CONSTRAINT DT_RS3_MSH_SKN_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RS3_MESH(`OUID`); 

ALTER TABLE DT_RS3_MESH_SKIN ADD CONSTRAINT DT_RS3_MSH_SKN_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RS3_SKELETON(`OUID`); 

ALTER TABLE DT_RS3_MESH_SKIN ADD CONSTRAINT DT_RS3_MSH_SKN_FK_SKN 
      FOREIGN KEY (`SKELETON_SKIN_ID`) REFERENCES DT_RS3_SKELETON_SKIN(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Mesh.Track]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MESH_TRACK`;
CREATE TABLE `DT_RS3_MESH_TRACK` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MESH_ID`                       BIGINT NOT NULL, 
   `TRACK_ID`                      BIGINT NOT NULL, 
   `CODE`                          VARCHAR(40), 
   `LABEL`                         VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MESH_TRACK 
   ADD CONSTRAINT DT_RS3_MSH_TCK_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MESH_TRACK ADD CONSTRAINT DT_RS3_MSH_TCK_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RS3_MESH(`OUID`); 

ALTER TABLE DT_RS3_MESH_TRACK ADD CONSTRAINT DT_RS3_MSH_TCK_FK_TCK 
      FOREIGN KEY (`TRACK_ID`) REFERENCES DT_RS3_TRACK(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Model]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MODEL`;
CREATE TABLE `DT_RS3_MODEL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       TEXT, 
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
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT NOT NULL, 
   `MESH_ID`                       BIGINT NOT NULL, 
   `INDEX`                         INTEGER, 
   `CODE`                          VARCHAR(40), 
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

ALTER TABLE DT_RS3_MODEL_MESH ADD CONSTRAINT DT_RS3_MOD_MSH_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RS3_MESH(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Model.Skeleton]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MODEL_SKELETON`;
CREATE TABLE `DT_RS3_MODEL_SKELETON` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT NOT NULL, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MODEL_SKELETON 
   ADD CONSTRAINT DT_RS3_MOD_SKT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MODEL_SKELETON ADD CONSTRAINT DT_RS3_MOD_SKT_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RS3_MODEL(`OUID`); 

ALTER TABLE DT_RS3_MODEL_SKELETON ADD CONSTRAINT DT_RS3_MOD_SKT_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RS3_SKELETON(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Model.Animation]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MODEL_ANIMATION`;
CREATE TABLE `DT_RS3_MODEL_ANIMATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MODEL_ID`                      BIGINT NOT NULL, 
   `ANIMATION_ID`                  BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MODEL_ANIMATION 
   ADD CONSTRAINT DT_RS3_MOD_ANM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MODEL_ANIMATION ADD CONSTRAINT DT_RS3_MOD_ANM_FK_MOD 
      FOREIGN KEY (`MODEL_ID`) REFERENCES DT_RS3_MODEL(`OUID`); 

ALTER TABLE DT_RS3_MODEL_ANIMATION ADD CONSTRAINT DT_RS3_MOD_ANM_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RS3_ANIMATION(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Theme]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_THEME`;
CREATE TABLE `DT_RS3_THEME` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_THEME 
   ADD CONSTRAINT DT_RS3_THM_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Material.Group]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MATERIAL_GROUP`;
CREATE TABLE `DT_RS3_MATERIAL_GROUP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       INTEGER, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MATERIAL_GROUP 
   ADD CONSTRAINT DT_RS3_MTL_GRP_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Material]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MATERIAL`;
CREATE TABLE `DT_RS3_MATERIAL` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `THEME_ID`                      BIGINT NOT NULL, 
   `MATERIAL_GROUP_ID`             BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_MATERIAL 
   ADD CONSTRAINT DT_RS3_MTL_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_MATERIAL ADD CONSTRAINT DT_RS3_MTL_FK_THM 
      FOREIGN KEY (`THEME_ID`) REFERENCES DT_RS3_THEME(`OUID`); 

ALTER TABLE DT_RS3_MATERIAL ADD CONSTRAINT DT_RS3_MTL_FK_GRP 
      FOREIGN KEY (`MATERIAL_GROUP_ID`) REFERENCES DT_RS3_MATERIAL_GROUP(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Material.Texture]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_MATERIAL_TEXTURE`;
CREATE TABLE `DT_RS3_MATERIAL_TEXTURE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `MATERIAL_ID`                   BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `TEXTURE_ID`                    BIGINT NOT NULL, 
   `TEXTURE_BITMAP_ID`             BIGINT NOT NULL, 
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
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       MEDIUMTEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEMPLATE 
   ADD CONSTRAINT DT_RS3_TPL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Template.Theme]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEMPLATE_THEME`;
CREATE TABLE `DT_RS3_TEMPLATE_THEME` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `TEMPLATE_ID`                   BIGINT NOT NULL, 
   `THEME_ID`                      BIGINT NOT NULL, 
   `ACTIVE_CD`                     INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEMPLATE_THEME 
   ADD CONSTRAINT DT_RS3_TPL_THM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_TEMPLATE_THEME ADD CONSTRAINT DT_RS3_TPL_THM_FK_TPL 
      FOREIGN KEY (`TEMPLATE_ID`) REFERENCES DT_RS3_TEMPLATE(`OUID`); 

ALTER TABLE DT_RS3_TEMPLATE_THEME ADD CONSTRAINT DT_RS3_TPL_THM_FK_THM 
      FOREIGN KEY (`THEME_ID`) REFERENCES DT_RS3_THEME(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Template.Material.Group]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_TEMPLATE_MATERIAL_GROUP`;
CREATE TABLE `DT_RS3_TEMPLATE_MATERIAL_GROUP` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `TEMPLATE_ID`                   BIGINT NOT NULL, 
   `MATERIAL_GROUP_ID`             BIGINT NOT NULL, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_TEMPLATE_MATERIAL_GROUP 
   ADD CONSTRAINT DT_RS3_TPL_MTL_GRP_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_TEMPLATE_MATERIAL_GROUP ADD CONSTRAINT DT_RS3_TPL_MTL_GRP_FK_TPL 
      FOREIGN KEY (`TEMPLATE_ID`) REFERENCES DT_RS3_TEMPLATE(`OUID`); 

ALTER TABLE DT_RS3_TEMPLATE_MATERIAL_GROUP ADD CONSTRAINT DT_RS3_TPL_MTL_GRP_FK_MTL_GRP 
      FOREIGN KEY (`MATERIAL_GROUP_ID`) REFERENCES DT_RS3_MATERIAL_GROUP(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Scene]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SCENE`;
CREATE TABLE `DT_RS3_SCENE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       MEDIUMTEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_SCENE 
   ADD CONSTRAINT DT_RS3_SCN_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Resource3d.Scene.Theme]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RS3_SCENE_THEME`;
CREATE TABLE `DT_RS3_SCENE_THEME` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PROJECT_ID`                    BIGINT, 
   `SCENE_ID`                      BIGINT NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `FULL_CODE`                     VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `KEYWORDS`                      VARCHAR(2000), 
   `CONTENT`                       MEDIUMTEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_RS3_SCENE_THEME 
   ADD CONSTRAINT DT_RS3_SCN_THM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_RS3_SCENE_THEME ADD CONSTRAINT DT_RS3_SCN_THM_FK_SCN 
      FOREIGN KEY (`SCENE_ID`) REFERENCES DT_RS3_SCENE(`OUID`); 
