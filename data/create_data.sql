-- ------------------------------------------------------------
-- Create table [Data.Person.User]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER`;
CREATE TABLE `DT_PSN_USER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `PASSPORT`                      VARCHAR(40), 
   `PASSWORD`                      VARCHAR(40), 
   `LABEL`                         VARCHAR(40), 
   `BIRTHDAY`                      DATE, 
   `CONTACT_PHONE`                 VARCHAR(16), 
   `CONTACT_EMAIL`                 VARCHAR(40), 
   `CONTACT_QQ`                    VARCHAR(16), 
   `CONTACT_MSN`                   VARCHAR(40), 
   `CREATE_USER_ID`                INTEGER, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                INTEGER, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

-- ------------------------------------------------------------
-- Create table [Data.Resource.Application]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_RES_APPLICATION`;
CREATE TABLE `DT_RES_APPLICATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `CORE`                          VARCHAR(40), 
   `LABEL`                         VARCHAR(80), 
   `DOWNLOAD_COUNT`                INTEGER, 
   `CREATE_USER_ID`                INTEGER, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                INTEGER, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

-- ------------------------------------------------------------
-- Create table [Data.Person.User.Application]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `DT_PSN_USER_APPLICATION`;
CREATE TABLE `DT_PSN_USER_APPLICATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `USER_ID`                       BIGINT NOT NULL, 
   `APPLICATION_ID`                BIGINT NOT NULL, 
   `ESTIMATE_CD`                   INTEGER, 
   `CREATE_USER_ID`                INTEGER, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                INTEGER, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE DT_PSN_USER_APPLICATION ADD CONSTRAINT DT_PSN_USR_APP_FK_USR 
      FOREIGN KEY (`USER_ID`) REFERENCES DT_PSN_USER(`OUID`); 

ALTER TABLE DT_PSN_USER_APPLICATION ADD CONSTRAINT DT_PSN_USR_APP_FK_APP 
      FOREIGN KEY (`APPLICATION_ID`) REFERENCES DT_RES_APPLICATION(`OUID`); 

