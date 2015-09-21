-- ------------------------------------------------------------
-- Create table [Data.Common.Configuration]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_CONFIGURATION`;
CREATE TABLE `DT_COM_CONFIGURATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(200), 
   `LABEL`                         VARCHAR(200), 
   `DATA_TYPE_CD`                  VARCHAR(40), 
   `DATA_VALUE`                    VARCHAR(800), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_CONFIGURATION 
   ADD CONSTRAINT DT_COM_CNF_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Common.Country]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_COUNTRY`;
CREATE TABLE `DT_COM_COUNTRY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(8), 
   `NAME`                          VARCHAR(20), 
   `LABEL`                         VARCHAR(40), 
   `PHONE_CODE`                    VARCHAR(8), 
   `ICON_URL`                      VARCHAR(400), 
   `LOCATION_LONGITUDE`            double DEFAULT NULL,
   `LOCATION_LATITUDE`             double DEFAULT NULL,
   `DISPLAY_CODE`                  INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_COUNTRY 
   ADD CONSTRAINT DT_COM_CTY_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Common.Area]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_AREA`;
CREATE TABLE `DT_COM_AREA` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `COUNTRY_ID`                    BIGINT NOT NULL, 
   `CODE`                          VARCHAR(20), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `DISPLAY_ORDER`                 INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_AREA 
   ADD CONSTRAINT DT_COM_AREA_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_COM_AREA ADD CONSTRAINT DT_COM_AREA_FK_CTY 
      FOREIGN KEY (`COUNTRY_ID`) REFERENCES DT_COM_COUNTRY(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Common.Province]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_PROVINCE`;
CREATE TABLE `DT_COM_PROVINCE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `COUNTRY_ID`                    BIGINT NOT NULL, 
   `AREA_ID`                       BIGINT, 
   `CODE`                          VARCHAR(20), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `DISPLAY_ORDER`                 INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_PROVINCE 
   ADD CONSTRAINT DT_COM_PVN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_COM_PROVINCE ADD CONSTRAINT DT_COM_PVN_FK_CTY 
      FOREIGN KEY (`COUNTRY_ID`) REFERENCES DT_COM_COUNTRY(`OUID`); 

ALTER TABLE DT_COM_PROVINCE ADD CONSTRAINT DT_COM_PVN_FK_ARE 
      FOREIGN KEY (`AREA_ID`) REFERENCES DT_COM_AREA(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Common.City]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_CITY`;
CREATE TABLE `DT_COM_CITY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `COUNTRY_ID`                    BIGINT NOT NULL, 
   `AREA_ID`                       BIGINT, 
   `PROVINCE_ID`                   BIGINT, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `LEVEL`                         INTEGER, 
   `CITY_CODE`                     VARCHAR(10),  
   `LOCATION_LONGITUDE`            double, 
   `LOCATION_LATITUDE`             double, 
   `DISPLAY_ORDER`                 INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_CITY 
   ADD CONSTRAINT DT_COM_CTY_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_COM_CITY ADD CONSTRAINT DT_COM_CTY_FK_CTY 
      FOREIGN KEY (`COUNTRY_ID`) REFERENCES DT_COM_COUNTRY(`OUID`); 

ALTER TABLE DT_COM_CITY ADD CONSTRAINT DT_COM_CTY_FK_ARE 
      FOREIGN KEY (`AREA_ID`) REFERENCES DT_COM_AREA(`OUID`); 

ALTER TABLE DT_COM_CITY ADD CONSTRAINT DT_COM_CTY_FK_PVN 
      FOREIGN KEY (`PROVINCE_ID`) REFERENCES DT_COM_PROVINCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Common.City.CARD]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_CITY_CARD`;	  
CREATE TABLE `DT_COM_CITY_CARD` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CITY_ID`                       BIGINT NOT NULL, 
   `CARD_CODE`                     INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_CITY_CARD 
   ADD CONSTRAINT DT_COM_CITY_CARD_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_COM_CITY_CARD ADD CONSTRAINT DT_COM_CITY_CARD_FK_CITY 
      FOREIGN KEY (`CITY_ID`) REFERENCES DT_COM_CITY(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Info.Device]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_INF_DEVICE`;
CREATE TABLE `DT_INF_DEVICE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
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

ALTER TABLE DT_INF_DEVICE 
   ADD CONSTRAINT DT_INF_DEV_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Info.Device.Browser]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_INF_DEVICE_BROWSER`;
CREATE TABLE `DT_INF_DEVICE_BROWSER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEVICE_ID`                     BIGINT, 
   `AGENT_CODE`                    VARCHAR(1024), 
   `IDENTITY_CODE`                 VARCHAR(2000), 
   `LABEL`                         VARCHAR(80), 
   `CONTENT`                       TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_INF_DEVICE_BROWSER 
   ADD CONSTRAINT DT_INF_DEV_BRW_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_INF_DEVICE_BROWSER ADD CONSTRAINT DT_INF_DEV_BRW_FK_DEV 
      FOREIGN KEY (`DEVICE_ID`) REFERENCES DT_INF_DEVICE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.System.Access.Authority]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_SYS_ACCESS_AUTHORITY`;
CREATE TABLE `DT_SYS_ACCESS_AUTHORITY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LABEL`                         VARCHAR(200), 
   `HOST_ADDRESS`                  VARCHAR(40), 
   `HOST_PORT`                     INTEGER, 
   `ACCESS_CD`                     INTEGER, 
   `BEGIN_DATE`                    DATETIME, 
   `END_DATE`                      DATETIME, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_SYS_ACCESS_AUTHORITY 
   ADD CONSTRAINT DT_SYS_ACS_AUT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Person.User]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER`;
CREATE TABLE `DT_PSN_USER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `STATUS_CD`                     INTEGER, 
   `PASSPORT`                      VARCHAR(40) NOT NULL, 
   `PASSWORD`                      VARCHAR(40), 
   `CODE`                          VARCHAR(80), 
   `NAME`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `CONTACT_PHONE`                 VARCHAR(20), 
   `CONTACT_PHONE_VERIFY_CD`       INTEGER, 
   `CONTACT_MAIL`                  VARCHAR(40), 
   `CONTACT_MAIL_VERIFY_CD`        INTEGER, 
   `ID_CARD`                       VARCHAR(40), 
   `ID_CARD_VERIFY_CD`             INTEGER, 
   `ROLE_CD`                       INTEGER, 
   `ROLE_ID`                       BIGINT, 
   `RANK_LABEL`                    VARCHAR(80), 
   `DEPARTMENT_LABELS`             VARCHAR(800), 
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

ALTER TABLE DT_PSN_USER 
   ADD CONSTRAINT DT_PSN_USR_UK_PASSPORT UNIQUE ( PASSPORT ); 

-- ------------------------------------------------------------
-- Create table [Data.Person.User.Entry]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_ENTRY`;
CREATE TABLE `DT_PSN_USER_ENTRY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `STATUS_CD`                     INTEGER, 
   `FROM_CD`                       INTEGER, 
   `PASSPORT`                      VARCHAR(40), 
   `PASSWORD`                      VARCHAR(40), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_ENTRY 
   ADD CONSTRAINT DT_PSN_USR_ENT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_ENTRY ADD CONSTRAINT DT_PSN_USR_ENT_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Person.User.Access.Authority]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_ACCESS_AUTHORITY`;
CREATE TABLE `DT_PSN_USER_ACCESS_AUTHORITY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `LABEL`                         VARCHAR(200), 
   `TYPE_CD`                       INTEGER, 
   `HOST_ADDRESS`                  VARCHAR(40), 
   `HOST_PORT`                     INTEGER, 
   `PASSPORT`                      VARCHAR(80), 
   `PASSWORD`                      VARCHAR(80), 
   `ACCESS_CD`                     INTEGER, 
   `BEGIN_DATE`                    DATETIME, 
   `END_DATE`                      DATETIME, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_ACCESS_AUTHORITY 
   ADD CONSTRAINT DT_PSN_USR_ACS_AUT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_ACCESS_AUTHORITY ADD CONSTRAINT DT_PSN_USR_ACS_AUT_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Control.Module]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_CTL_MODULE`;
CREATE TABLE `DT_CTL_MODULE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(200), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_CTL_MODULE 
   ADD CONSTRAINT DT_CTL_MOD_UK_GID UNIQUE ( GUID ); 
ALTER TABLE DT_CTL_MODULE 
   ADD CONSTRAINT DT_CTL_MOD_UK_CODE UNIQUE (CODE); 

-- ------------------------------------------------------------
-- Create table [Data.Control.Role]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_CTL_ROLE`;
CREATE TABLE `DT_CTL_ROLE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_CTL_ROLE 
   ADD CONSTRAINT DT_CTL_ROL_UK_GID UNIQUE ( GUID ); 
ALTER TABLE DT_CTL_ROLE 
   ADD CONSTRAINT DT_CTL_ROL_UK_CODE UNIQUE (CODE);

-- ------------------------------------------------------------
-- Create table [Data.Control.Role.Module]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_CTL_ROLE_MODULE`;
CREATE TABLE `DT_CTL_ROLE_MODULE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `ROLE_ID`                       BIGINT NOT NULL, 
   `MODULE_ID`                     BIGINT NOT NULL, 
   `VIEW_VALID_CD`                 INTEGER, 
   `INSERT_VALID_CD`               INTEGER, 
   `UPDATE_VALID_CD`               INTEGER, 
   `DELETE_VALID_CD`               INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_CTL_ROLE_MODULE 
   ADD CONSTRAINT DT_CTL_ROL_MOD_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_CTL_ROLE_MODULE ADD CONSTRAINT DT_CTL_ROL_MOD_FK_ROL 
      FOREIGN KEY (`ROLE_ID`) REFERENCES DT_CTL_ROLE(`OUID`); 

ALTER TABLE DT_CTL_ROLE_MODULE ADD CONSTRAINT DT_CTL_ROL_MOD_FK_MOD 
      FOREIGN KEY (`MODULE_ID`) REFERENCES DT_CTL_MODULE(`OUID`); 

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
   `SHARE_CD`                      INTEGER, 
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
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
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
   `MESH_ID`                       BIGINT, 
   `SKELETON_ID`                   BIGINT NOT NULL, 
   `FULL_CODE`                     VARCHAR(200), 
   `CODE`                          VARCHAR(80), 
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

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RES_MODEL_MESH(`OUID`); 

ALTER TABLE DT_RES_MODEL_SKELETON_SKIN ADD CONSTRAINT DT_RES_MOD_SKT_SKN_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RES_MODEL_SKELETON(`OUID`); 

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
   `FULL_CODE`                     VARCHAR(200), 
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
   `MESH_ID`                       BIGINT, 
   `SKELETON_ID`                   BIGINT, 
   `ANIMATION_ID`                  BIGINT NOT NULL, 
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

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_MSH 
      FOREIGN KEY (`MESH_ID`) REFERENCES DT_RES_MODEL_MESH(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_SKT 
      FOREIGN KEY (`SKELETON_ID`) REFERENCES DT_RES_MODEL_SKELETON(`OUID`); 

ALTER TABLE DT_RES_MODEL_ANIMATION_TRACK ADD CONSTRAINT DT_RES_MOD_ANM_TCK_FK_ANM 
      FOREIGN KEY (`ANIMATION_ID`) REFERENCES DT_RES_MODEL_ANIMATION(`OUID`); 

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
   `CODE`                          VARCHAR(80), 
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

-- ------------------------------------------------------------
-- Create table [Data.Resource.User.Resource]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_RESOURCE`;
CREATE TABLE `DT_PSN_USER_RESOURCE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `RESOURCE_ID`                   BIGINT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_RESOURCE 
   ADD CONSTRAINT DT_PSN_USR_RES_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_RESOURCE ADD CONSTRAINT DT_PSN_USR_RES_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_PSN_USER_RESOURCE ADD CONSTRAINT DT_PSN_USR_RES_FK_RES 
      FOREIGN KEY (`RESOURCE_ID`) REFERENCES DT_RES_RESOURCE(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Product]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_PRODUCT`;
CREATE TABLE `DT_FIN_PRODUCT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `NAME`                          VARCHAR(40), 
   `LABEL`                         VARCHAR(40), 
   `RENT_PERSON`                   VARCHAR(200), 
   `TENANT_PERSON`                 VARCHAR(200), 
   `ANNUAL_RATE_OF_RETURN`         FLOAT, 
   `TIME_LIMIT`                    INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_PRODUCT 
   ADD CONSTRAINT DT_FIN_PCT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Department]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_DEPARTMENT`;
CREATE TABLE `DT_FIN_DEPARTMENT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_PARENT_ID`                BIGINT, 
   `LINK_ID`                       BIGINT, 
   `CODE`                          VARCHAR(40), 
   `NAME`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `DEPARTMENT_ID`                 INTEGER, 
   `DEPARTMENT_LABEL`              VARCHAR(400), 
   `REGION_ID`                     INTEGER, 
   `REGION_LABEL`                  VARCHAR(200), 
   `LEVEL`                         INTEGER, 
   `LEADER_ID`                     BIGINT, 
   `LEADER_LABEL`                  VARCHAR(80), 
   `LEADER_PHONE`                  VARCHAR(80), 
   `PROVINCE_ID`                   INTEGER, 
   `PROVINCE_LABEL`                VARCHAR(80), 
   `CITY_ID`                       INTEGER, 
   `CITY_LABEL`                    VARCHAR(80), 
   `DETAIL_ADDRESS`                VARCHAR(400), 
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
   `DEPARTMENT_PHONE`              VARCHAR(80), 
   `BUILD_DATE`                    DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `INVESTMENT_COUNT`              INTEGER, 
   `INVESTMENT_DATE`               DATETIME, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `REDEMPTION_COUNT`              INTEGER, 
   `REDEMPTION_DATE`               DATETIME, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_DEPARTMENT 
   ADD CONSTRAINT DT_FIN_DPT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Member]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_MEMBER`;
CREATE TABLE `DT_FIN_MEMBER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `LINK_ID`                       BIGINT, 
   `STATISTICS_ID`                 BIGINT, 
   `PASSPORT`                      VARCHAR(60), 
   `LABEL`                         VARCHAR(40), 
   `CARD`                          VARCHAR(20), 
   `BIRTHDAY`                      DATETIME, 
   `PHONE`                         VARCHAR(20), 
   `EMAIL`                         VARCHAR(80), 
   `GENDER_CD`                     INTEGER, 
   `MARRY_CD`                      INTEGER, 
   `EDUCATION_CD`                  INTEGER, 
   `BUSINESS_CD`                   INTEGER, 
   `INCOME_CD`                     INTEGER, 
   `PROVINCE_AREA_ID`              BIGINT, 
   `PROVINCE_ID`                   BIGINT, 
   `CITY_ID`                       BIGINT, 
   `AREA_ID`                       BIGINT, 
   `ADDRESS`                       VARCHAR(200), 
   `REGISTER_DATE`                 DATETIME, 
   `LAST_LOGIN_DATE`               DATETIME, 
   `RECOMMEND_MARKETER_ID`         BIGINT, 
   `RECOMMEND_MARKETER_USER_ID`    BIGINT, 
   `RECOMMEND_BEGIN_DATE`          DATETIME, 
   `RECOMMEND_END_DATE`            DATETIME, 
   `RECOMMEND_SCORE`               INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MEMBER 
   ADD CONSTRAINT DT_FIN_MBR_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_CUSTOMER`;
CREATE TABLE `DT_FIN_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `STATISTICS_ID`                 INTEGER, 
   `MARRY_CD`                      INTEGER, 
   `EDUCATION_CD`                  INTEGER, 
   `INCOME_CD`                     INTEGER, 
   `BUSINESS_CD`                   INTEGER, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `INVESTMENT_COUNT`              INTEGER, 
   `REDEMPTION_TOTAL`              FLOAT, 
   `REDEMPTION_COUNT`              INTEGER, 
   `NETINVESTMENT`                 FLOAT, 
   `INTEREST_TOTAL`                FLOAT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_CUSTOMER 
   ADD CONSTRAINT DT_FIN_CST_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Tender]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_TENDER`;
CREATE TABLE `DT_FIN_TENDER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CUSTOMER_ID`                   BIGINT, 
   `PRODUCT_ID`                    BIGINT, 
   `INVESTMENT`                    FLOAT, 
   `INVESTMENT_DATE`               DATETIME, 
   `REDEMPTION`                    FLOAT, 
   `REDEMPTION_DATE`               DATETIME, 
   `NETINVESTMENT`                 FLOAT, 
   `INTEREST`                      FLOAT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_TENDER 
   ADD CONSTRAINT DT_FIN_TDR_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Marketer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_MARKETER`;
 CREATE TABLE `DT_FIN_MARKETER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `LINK_ID`                       BIGINT, 
   `STATISTICS_ID`                 BIGINT, 
   `NAME`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(40), 
   `PASSPORT`                      VARCHAR(60), 
   `STATUS_CD`                     INTEGER, 
   `PHONE`                         VARCHAR(20), 
   `CARD`                          VARCHAR(20), 
   `RANK_LABEL`                    VARCHAR(40), 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(200), 
   `DEPARTMENT_LABELS`             VARCHAR(200), 
   `CUSTOMER_INVESTMENT_TOTAL`     DOUBLE, 
   `CUSTOMER_INVESTMENT_COUNT`     INTEGER, 
   `CUSTOMER_INVESTMENT_DATE`      DATETIME, 
   `CUSTOMER_REDEMPTION_TOTAL`     DOUBLE, 
   `CUSTOMER_REDEMPTION_COUNT`     INTEGER, 
   `CUSTOMER_REDEMPTION_DATE`      DATETIME, 
   `CUSTOMER_NETINVESTMENT_TOTAL`  DOUBLE, 
   `CUSTOMER_INTEREST_TOTAL`       DOUBLE, 
   `CUSTOMER_PERFORMANCE_TOTAL`    DOUBLE, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MARKETER 
   ADD CONSTRAINT DT_FIN_MKT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Marketer.Member]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_MARKETER_MEMBER`;
CREATE TABLE `DT_FIN_MARKETER_MEMBER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `RELATION_CD`                   INTEGER, 
   `SMS_CONTACT_CD`                INTEGER, 
   `RECOMMEND_BEGIN_DATE`          DATETIME, 
   `RECOMMEND_END_DATE`            DATETIME, 
   `FEEDBACK_CD`                   INTEGER, 
   `FEEDBACK_NOTE`                 VARCHAR(2000), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MARKETER_MEMBER 
   ADD CONSTRAINT DT_FIN_MKT_MEM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_FIN_MARKETER_MEMBER ADD CONSTRAINT DT_FIN_MKT_MEM_FK_MKT 
      FOREIGN KEY (`MARKETER_ID`) REFERENCES DT_FIN_MARKETER(`OUID`); 

ALTER TABLE DT_FIN_MARKETER_MEMBER ADD CONSTRAINT DT_FIN_MKT_MEM_FK_CUS 
      FOREIGN KEY (`CUSTOMER_ID`) REFERENCES DT_FIN_CUSTOMER(`OUID`); 
