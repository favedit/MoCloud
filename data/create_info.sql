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
