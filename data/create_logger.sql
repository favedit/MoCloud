-- ------------------------------------------------------------
-- Create table [Logger.System.Logger]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_SYS_LOGGER`;
CREATE TABLE `LG_SYS_LOGGER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `SERVER_CODE`                   VARCHAR(40) NOT NULL, 
   `SERVER_HOST`                   VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `LEVEL_CD`                      INTEGER NOT NULL, 
   `CODE`                          VARCHAR(200) NOT NULL, 
   `PARAMETERS`                    VARCHAR(800), 
   `DESCRIPTION`                   TEXT, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE LG_SYS_LOGGER 
   ADD CONSTRAINT LG_SYS_LOG_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Logger.System.Exception]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_SYS_EXCEPTION`;
CREATE TABLE `LG_SYS_EXCEPTION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `SERVER_CODE`                   VARCHAR(40) NOT NULL, 
   `SERVER_HOST`                   VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `CODE`                          VARCHAR(200) NOT NULL, 
   `PARAMETERS`                    VARCHAR(800), 
   `DESCRIPTION`                   TEXT, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 

ALTER TABLE LG_SYS_EXCEPTION 
   ADD CONSTRAINT LG_SYS_EXP_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Logger.Info.Browser.Access]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_INF_BROWSER_ACCESS`;
CREATE TABLE `LG_INF_BROWSER_ACCESS` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `BROWSER_ID`                    BIGINT, 
   `PAGE_URI`                      VARCHAR(800), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE LG_INF_BROWSER_ACCESS 
   ADD CONSTRAINT LG_INF_BRW_ACS_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Logger.Person.User.Access]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_PSN_USER_ACCESS`;
CREATE TABLE `LG_PSN_USER_ACCESS` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `LOGIC_CODE`                    VARCHAR(40), 
   `LOGIC_RESULT`                  VARCHAR(40), 
   `LOGIC_MESSAGE`                 VARCHAR(800), 
   `HOST_ADDRESS`                  VARCHAR(40), 
   `HOST_PORT`                     INTEGER, 
   `PASSPORT`                      VARCHAR(40), 
   `PASSWORD`                      VARCHAR(40), 
   `BROWSER_URI`                   VARCHAR(800), 
   `PAGE_INFO`                     VARCHAR(2000), 
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE LG_PSN_USER_ACCESS 
   ADD CONSTRAINT LG_PSN_USR_ACS_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Logger.Person.User.Module]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_PSN_USER_MODULE`;
CREATE TABLE `LG_PSN_USER_MODULE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `PASSPORT`                      VARCHAR(40), 
   `MODULE_CODE`                   VARCHAR(40), 
   `MODULE_ACTION`                 VARCHAR(40), 
   `MODULE_RESULT`                 VARCHAR(200), 
   `BROWSER_URI`                   VARCHAR(800), 
   `PAGE_INFO`                     VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE LG_PSN_USER_MODULE 
   ADD CONSTRAINT LG_PSN_USR_MOD_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Logger.Person.User.notice]
-- 20151021 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_PSN_USER_NOTICE`;
CREATE TABLE `LG_PSN_USER_NOTICE` 
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
) ENGINE=MYISAM DEFAULT CHARSET=utf8; 

ALTER TABLE LG_PSN_USER_NOTICE 
   ADD CONSTRAINT LG_PSN_USR_NTC_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Logger.Financial.Customer]
-- 20151019 sunhr
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_FIN_CUSTOMER_MESSAGE`;
CREATE TABLE `LG_FIN_CUSTOMER_MESSAGE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LID`                  BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `CUSTOMER_ID`                   INTEGER, 
   `CUSTOMER_LID`                  INTEGER, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `SEND_DATE`                     DATETIME, 
   `SEND_CONTENT`                  TEXT, 
   `NOTE`                          VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE LG_FIN_CUSTOMER_MESSAGE 
   ADD CONSTRAINT LG_INF_CST_MSG_UK_GID UNIQUE ( GUID ); 
   

