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
-- sunhr  20151030 update
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_COUNTRY`;
CREATE TABLE `DT_COM_COUNTRY` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(8), 
   `NAME`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `PHONE_CODE`                    VARCHAR(8), 
   `ICON_URL`                      VARCHAR(400), 
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
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
   ADD CONSTRAINT DT_COM_ARA_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_COM_AREA ADD CONSTRAINT DT_COM_ARA_FK_CTY 
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
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
   `DISPLAY_ORDER`                 INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

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
   `COUNTRY_ID`                    BIGINT, 
   `AREA_ID`                       BIGINT, 
   `PROVINCE_ID`                   BIGINT, 
   `CITY_ID`                       BIGINT NOT NULL, 
   `CARD_CODE`                     INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_CITY_CARD 
   ADD CONSTRAINT DT_COM_CTY_CAD_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_COM_CITY_CARD ADD CONSTRAINT DT_COM_CTY_CAD_FK_CITY 
      FOREIGN KEY (`CITY_ID`) REFERENCES DT_COM_CITY(`OUID`); 
	  

-- ------------------------------------------------------------
-- Create table [Data.Common.City.Mobile]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_COM_CITY_MOBILE`;	
CREATE TABLE `DT_COM_CITY_MOBILE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `PHONE`                         VARCHAR(20), 
   `PROVINCE`                      VARCHAR(20), 
   `CITY`                          VARCHAR(20), 
   `OPERATORS`                     VARCHAR(20) NOT NULL, 
   `STOCK`                         INTEGER, 
   `AMOUNT`                        INTEGER, 
   `MAX_PRICE`                     DOUBLE, 
   `MIN_PRICE`                     DOUBLE, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_COM_CITY_MOBILE 
   ADD CONSTRAINT DT_COM_CTY_MBL_UK_GID UNIQUE ( GUID ); 

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
-- Create table [Data.System.Application]
-- ------------------------------------------------------------ 
DROP TABLE IF EXISTS `DT_SYS_APPLICATION`;
CREATE TABLE `DT_SYS_APPLICATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(200), 
   `NOTE`                          VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_SYS_APPLICATION 
   ADD CONSTRAINT DT_SYS_APP_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.System.Version]
-- sunhr 20151007
-- ------------------------------------------------------------  
DROP TABLE IF EXISTS `DT_SYS_VERSION`;
CREATE TABLE `DT_SYS_VERSION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `APPLICATION_ID`                BIGINT NOT NULL, 
   `STATUS_CD`                     INTEGER, 
   `FORCE_CD`                      INTEGER, 
   `NUMBER`                        FLOAT NOT NULL, 
   `CODE`                          VARCHAR(40) NOT NULL, 
   `LABEL`                         VARCHAR(80), 
   `BEGIN_DATE`                    DATETIME, 
   `END_DATE`                      DATETIME, 
   `DOWNLOAD_URL`                  VARCHAR(800), 
   `DOWNLOAD_SIZE`                 INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_SYS_VERSION 
   ADD CONSTRAINT DT_SYS_VER_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_SYS_VERSION 
   ADD CONSTRAINT DT_SYS_VER_UK_NUMBER UNIQUE ( NUMBER ); 

ALTER TABLE DT_SYS_VERSION ADD CONSTRAINT DT_SYS_VER_FK_APP 
      FOREIGN KEY (`APPLICATION_ID`) REFERENCES DT_SYS_APPLICATION(`OUID`); 
	  
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
-- Create table [Data.Person.User.Signing]
-- sunhr 20151009 
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_SIGNING`;
CREATE TABLE `DT_PSN_USER_SIGNING` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `SINGN_DATE`                    DATETIME, 
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_SIGNING 
   ADD CONSTRAINT DT_PSN_USR_SIG_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_SIGNING ADD CONSTRAINT DT_PSN_USR_SIG_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Person.User.News]
-- AnjoyTian 20151103
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_NEWS`; 
CREATE TABLE `DT_PSN_USER_NEWS` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `NEWS_ID`                       BIGINT, 
   `ACTIVE_CD`                     INTEGER, 
   `ACTIVE_DATE`                   DATETIME, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_NEWS 
   ADD CONSTRAINT DT_PSN_USR_NWS_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_NEWS 
   ADD CONSTRAINT DT_PSN_USR_NWS_UK_NEWS UNIQUE ( USER_ID, NEWS_ID ); 

ALTER TABLE DT_PSN_USER_NEWS ADD CONSTRAINT DT_PSN_USR_NWS_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_PSN_USER_NEWS ADD CONSTRAINT DT_PSN_USR_NWS_FK_NEWS 
      FOREIGN KEY (`NEWS_ID`) REFERENCES DT_LGC_NEWS(`OUID`);  

-- ------------------------------------------------------------
-- Create table [Data.Person.User.SalesTools]
-- AnjoyTian 20151104
-- ------------------------------------------------------------ 
DROP TABLE IF EXISTS `DT_PSN_USER_SALESTOOLS`; 
CREATE TABLE `DT_PSN_USER_SALESTOOLS` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `SALESTOOLS_ID`                 BIGINT, 
   `ACTIVE_CD`                     INTEGER, 
   `ACTIVE_DATE`                   DATETIME, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MYISAM DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_SALESTOOLS 
   ADD CONSTRAINT DT_PSN_USR_SAT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_SALESTOOLS 
   ADD CONSTRAINT DT_PSN_USR_SAT_UK_SATS UNIQUE ( USER_ID, SALESTOOLS_ID ); 

ALTER TABLE DT_PSN_USER_SALESTOOLS ADD CONSTRAINT DT_PSN_USR_SAT_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_PSN_USER_SALESTOOLS ADD CONSTRAINT DT_PSN_USR_SAT_FK_SAL 
      FOREIGN KEY (`SALESTOOLS_ID`) REFERENCES DT_LGC_SALESTOOLS(`OUID`);

-- ------------------------------------------------------------
-- Create table [Data.Person.User.TrueTimeData]
-- AnjoyTian 20151104
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_TRUETIME`; 
CREATE TABLE `DT_PSN_USER_TRUETIME` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `TRUETIME_ID`                   BIGINT, 
   `ACTIVE_CD`                     INTEGER, 
   `ACTIVE_DATE`                   DATETIME, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MYISAM DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_TRUETIME 
   ADD CONSTRAINT DT_PSN_USR_TRT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_TRUETIME 
   ADD CONSTRAINT DT_PSN_USR_TRT_UK_TIME UNIQUE ( USER_ID, TRUETIME_ID ); 

ALTER TABLE DT_PSN_USER_TRUETIME ADD CONSTRAINT DT_PSN_USR_TRT_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_PSN_USER_TRUETIME ADD CONSTRAINT DT_PSN_USR_TRT_FK_TIME 
      FOREIGN KEY (`TRUETIME_ID`) REFERENCES DT_LGC_TRUETIME(`OUID`); 

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
-- Create table [Data.Control.Rule]
-- sunhr 151006
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_CTL_RULE`;
CREATE TABLE `DT_CTL_RULE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `RULE_CD`                       INTEGER, 
   `PERCENTAGE`                    INTEGER, 
   `SCORE_POINT`                   INTEGER, 
   `PARAMETERS1`                   VARCHAR(40), 
   `PARAMETERS2`                   VARCHAR(40), 
   `PARAMETERS3`                   VARCHAR(40), 
   `PARAMETERS4`                   VARCHAR(40), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_CTL_RULE 
   ADD CONSTRAINT DT_CTL_RUL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Logic.News]
-- sunhr  20151010
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_LGC_NEWS`;
CREATE TABLE `DT_LGC_NEWS` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LABEL`                         VARCHAR(200), 
   `ICON_URL`                      VARCHAR(400), 
   `STATUS_CD`                     INTEGER, 
   `DISPLAY_CD`                    INTEGER, 
   `LINK_CD`                       INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `RECORD_DATE`                   DATETIME, 
   `KEYWORDS`                      VARCHAR(800), 
   `LINK_URL`                      VARCHAR(800), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `VIEW_COUNT`                    INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_LGC_NEWS 
   ADD CONSTRAINT DT_LGC_NEW_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Logic.Message]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_LGC_MESSAGE`;
CREATE TABLE `DT_LGC_MESSAGE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(200), 
   `DISPLAY_CD`                    INTEGER, 
   `STATUS_CD`                     INTEGER, 
   `DESCRIPTION`                   VARCHAR(2000), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_LGC_MESSAGE 
   ADD CONSTRAINT DT_LGC_MSG_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Logic.Salestools]
-- sunhr 20151010
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_LGC_SALESTOOLS`;
CREATE TABLE `DT_LGC_SALESTOOLS` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LABEL`                         VARCHAR(200), 
   `ICON_URL`                      VARCHAR(400), 
   `STATUS_CD`                     INTEGER, 
   `DISPLAY_CD`                    INTEGER, 
   `LINK_CD`                       INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `RECORD_DATE`                   DATETIME, 
   `KEYWORDS`                      VARCHAR(800), 
   `LINK_URL`                      VARCHAR(800), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `VIEW_COUNT`                    INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_LGC_SALESTOOLS 
   ADD CONSTRAINT DT_LGC_SAL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Data.Logic.Truetime]
-- sunhr 20151016
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_LGC_TRUETIME`;
CREATE TABLE `DT_LGC_TRUETIME` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LABEL`                         VARCHAR(200), 
   `ICON_URL`                      VARCHAR(400), 
   `STATUS_CD`                     INTEGER, 
   `DISPLAY_CD`                    INTEGER, 
   `LINK_CD`                       INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `RECORD_DATE`                   DATETIME, 
   `KEYWORDS`                      VARCHAR(800), 
   `LINK_URL`                      VARCHAR(800), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `VIEW_COUNT`                    INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_LGC_TRUETIME 
   ADD CONSTRAINT DT_LGC_TRM_UK_GID UNIQUE ( GUID );   

-- ------------------------------------------------------------
-- Create table [Data.Logic.Notice]
-- 20151021 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_LGC_NOTICE`; 
CREATE TABLE `DT_LGC_NOTICE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       INTEGER, 
   `LABEL`                         VARCHAR(200), 
   `STATUS_CD`                     INTEGER, 
   `DISPLAY_CD`                    INTEGER, 
   `DISPLAY_ORDER`                 INTEGER, 
   `LINK_CD`                       INTEGER, 
   `LINK_URL`                      VARCHAR(800), 
   `DESCRIPTION`                   VARCHAR(2000), 
   `CONTENT`                       TEXT, 
   `VIEW_COUNT`                    INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_LGC_NOTICE 
   ADD CONSTRAINT DT_LGC_NTC_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_LGC_NOTICE ADD CONSTRAINT DT_LGC_NTC_FK_USER 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Person.User.Notice]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_NOTICE`;
CREATE TABLE `DT_PSN_USER_NOTICE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `NOTICE_ID`                     BIGINT, 
   `ACTIVE_CD`                     INTEGER, 
   `ACTIVE_DATE`                   DATETIME, 
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_NOTICE 
   ADD CONSTRAINT DT_PSN_USR_NTC_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_PSN_USER_NOTICE 
   ADD CONSTRAINT DT_PSN_USR_NTC_UK_NTC UNIQUE ( USER_ID, NOTICE_ID ); 

ALTER TABLE DT_PSN_USER_NOTICE ADD CONSTRAINT DT_PSN_USR_NTC_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_PSN_USER_NOTICE ADD CONSTRAINT DT_PSN_USR_NTC_FK_NTC 
      FOREIGN KEY (`NOTICE_ID`) REFERENCES DT_LGC_NOTICE(`OUID`); 

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
   `CODE`                          VARCHAR(40), 
   `LABEL`                         VARCHAR(40), 
   `ICON_URL`                      VARCHAR(400), 
   `RATE`                          DOUBLE, 
   `HORIZON_COUNT`                 INTEGER, 
   `HORIZON_UNIT`                  VARCHAR(40), 
   `HORIZON_CLOSED`                INTEGER, 
   `HORIZON_WAIT`                  INTEGER, 
   `FACTOR`                        DOUBLE, 
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
   `ICON_URL`                      VARCHAR(400), 
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MEMBER 
   ADD CONSTRAINT DT_FIN_MBR_UK_GID UNIQUE ( GUID ); 
-- ------------------------------------------------------------
-- Create table [Data.Financial.Member.Score]
-- sunhr 151006
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_MEMBER_SCORE`;
CREATE TABLE `DT_FIN_MEMBER_SCORE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `PASSPORT`                      VARCHAR(60), 
   `LABEL`                         VARCHAR(40), 
   `MARKETER_ID`                   BIGINT, 
   `CITY_ID`                       BIGINT, 
   `BIRTHDAY`                      DATETIME, 
   `REGISTER_DATE`                 DATETIME, 
   `LAST_LOGIN_DATE`               DATETIME, 
   `RECOMMEND_SCORE`               INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MEMBER_SCORE 
   ADD CONSTRAINT DT_FIN_MBR_SCR_UK_GID UNIQUE ( GUID ); 
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
-- Create table [Data.Financial.Tender]
-- 20151104 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_TENDER`;
CREATE TABLE `DT_FIN_TENDER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `PRODUCT_ID`                    INTEGER, 
   `LABEL`                         VARCHAR(800), 
   `BORROW_MONEY`                  DOUBLE, 
   `INVESTMENT_BEGIN_DATE`         DATETIME, 
   `INVESTMENT_END_DATE`           DATETIME, 
   `INVESTMENT_COUNT`              INTEGER, 
   `INVESTMENT_USER_COUNT`         INTEGER, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_BEGIN_DATE`         DATETIME, 
   `REDEMPTION_END_DATE`           DATETIME, 
   `REDEMPTION_COUNT`              INTEGER, 
   `REDEMPTION_USER_COUNT`         INTEGER, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `NETINVESTMENT`                 FLOAT, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_TENDER 
   ADD CONSTRAINT DT_FIN_TDR_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_FIN_TENDER ADD CONSTRAINT DT_FIN_TDR_FK_PRODUCT 
      FOREIGN KEY (`PRODUCT_ID`) REFERENCES DT_FIN_PRODUCT(`OUID`); 
	  
-- ------------------------------------------------------------
-- Create table [Data.Financial.Customer.Tender]
-- 20151104 sunhr 客户产品投资表
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_CUSTOMER_TENDER`;
CREATE TABLE `DT_FIN_CUSTOMER_TENDER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CUSTOMER_ID`                   BIGINT, 
   `TENDER_ID`                     BIGINT, 
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

ALTER TABLE DT_FIN_CUSTOMER_TENDER 
   ADD CONSTRAINT DT_FIN_CST_TDR_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_FIN_CUSTOMER_TENDER ADD CONSTRAINT DT_FIN_CST_TDR_FK_CUSTOMER 
      FOREIGN KEY (`CUSTOMER_ID`) REFERENCES DT_FIN_CUSTOMER(`OUID`); 

ALTER TABLE DT_FIN_CUSTOMER_TENDER ADD CONSTRAINT DT_FIN_CST_TDR_FK_TENDER 
      FOREIGN KEY (`TENDER_ID`) REFERENCES DT_FIN_TENDER(`OUID`); 
-- ------------------------------------------------------------
-- Create table [Data.Financial.Customer.Action]
-- 20151108 AnjoyTian 客户行为日志
-- ------------------------------------------------------------	  
DROP TABLE IF EXISTS `DT_FIN_CUSTOMER_ACTION`;
CREATE TABLE `DT_FIN_CUSTOMER_ACTION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CUSTOMER_ID`                   BIGINT, 
   `CUSTOMER_LINK_ID`              BIGINT, 
   `ACTION_CD`                     INTEGER, 
   `RECORD_DATE`                   DATETIME, 
   `CONTENT`                       VARCHAR(2000), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=INNODB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_CUSTOMER_ACTION 
   ADD CONSTRAINT DT_FIN_CST_ACT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_FIN_CUSTOMER_ACTION ADD CONSTRAINT DT_FIN_CST_ACT_FK_CUSTOMER 
      FOREIGN KEY (`CUSTOMER_ID`) REFERENCES DT_FIN_CUSTOMER(`OUID`); 
	  
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
   `MEMBER_ID`                     BIGINT, 
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MARKETER_MEMBER 
   ADD CONSTRAINT DT_FIN_MKT_MEM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_FIN_MARKETER_MEMBER ADD CONSTRAINT DT_FIN_MKT_MEM_FK_MKT 
      FOREIGN KEY (`MARKETER_ID`) REFERENCES DT_FIN_MARKETER(`OUID`); 

ALTER TABLE DT_FIN_MARKETER_MEMBER ADD CONSTRAINT DT_FIN_MKT_MEM_FK_MER 
      FOREIGN KEY (`MEMBER_ID`) REFERENCES DT_FIN_MEMBER(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Financial.Marketer.Customer]
-- 20151019 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_FIN_MARKETER_CUSTOMER`;
CREATE TABLE `DT_FIN_MARKETER_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `SMS_CONTACT_CD`                INTEGER, 
   `ACTIVE_CD`                     INTEGER, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_FIN_MARKETER_CUSTOMER 
   ADD CONSTRAINT DT_FIN_MKT_CST_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_FIN_MARKETER_CUSTOMER ADD CONSTRAINT DT_FIN_MKT_CST_FK_MKT 
      FOREIGN KEY (`MARKETER_ID`) REFERENCES DT_FIN_MARKETER(`OUID`); 

ALTER TABLE DT_FIN_MARKETER_CUSTOMER ADD CONSTRAINT DT_FIN_MKT_CST_FK_CST 
      FOREIGN KEY (`CUSTOMER_ID`) REFERENCES DT_FIN_CUSTOMER(`OUID`); 

-- ------------------------------------------------------------
-- Create table [Data.Organization.Department]
-- 20151108 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_ORG_DEPARTMENT`;
CREATE TABLE `DT_ORG_DEPARTMENT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(8), 
   `NAME`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `ICON_URL`                      VARCHAR(400), 
   `VALID_CD`                      INTEGER, 
   `PARENT_ID`                     BIGINT, 
   `PATH_IDS`                      VARCHAR(1000), 
   `PATH_LABELS`                   VARCHAR(2000), 
   `USER_COUNT`                    INTEGER, 
   `BUILD_DATE`                    DATETIME, 
   `DESCRIPTION`                   VARCHAR(800), 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_ORG_DEPARTMENT 
   ADD CONSTRAINT DT_COM_DEP_UK_GID UNIQUE ( GUID ); 
-- ------------------------------------------------------------
-- Create table [Data.Organization.Department.User]
-- 20151108 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_ORG_DEPARTMENT_USER`;
CREATE TABLE `DT_ORG_DEPARTMENT_USER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(8), 
   `NAME`                          VARCHAR(80), 
   `LABEL`                         VARCHAR(80), 
   `DEPARTMENT_ID`                 INTEGER, 
   `USER_ID`                       INTEGER, 
   `STATUS_CD`                     BIGINT, 
   `RELATION_CD`                   INTEGER, 
   `ENTRY_DATE`                    DATETIME, 
   `LEAVE_DATE`                    DATETIME, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE DT_ORG_DEPARTMENT_USER 
   ADD CONSTRAINT DT_ORG_DEP_USR_UK_GID UNIQUE ( GUID ); 

ALTER TABLE DT_ORG_DEPARTMENT_USER ADD CONSTRAINT DT_ORG_DEP_USR_FK_DEPARTMENT 
      FOREIGN KEY (`DEPARTMENT_ID`) REFERENCES DT_ORG_DEPARTMENT(`OUID`); 

ALTER TABLE DT_ORG_DEPARTMENT_USER ADD CONSTRAINT DT_ORG_DEP_USR_FK_USER 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 
