-- ------------------------------------------------------------
-- Create table [Logger.Person.User.Operation]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_PSN_USER_OPERATION`;
CREATE TABLE `LG_PSN_USER_OPERATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `USER_ID`                       BIGINT NOT NULL, 
   `OPERATION_CD`                  INTEGER, 
   `CREATE_USER_ID`                INTEGER, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                INTEGER, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

-- ------------------------------------------------------------
-- Create table [Logger.Resource.Application.Download]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `LG_RES_APPLICATION_DOWNLOAD`;
CREATE TABLE `LG_RES_APPLICATION_DOWNLOAD` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `APPLICATION_ID`                BIGINT, 
   `USER_ID`                       BIGINT, 
   `CREATE_USER_ID`                INTEGER, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                INTEGER, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

