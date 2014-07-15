-- ------------------------------------------------------------
-- Create table [Cache.System.Session]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `CC_SYS_SESSION`;
CREATE TABLE `CC_SYS_SESSION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `CODE`                          VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT NOT NULL, 
   `CREATE_USER_ID`                INTEGER, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                INTEGER, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=HEAP DEFAULT CHARSET=utf8; 

