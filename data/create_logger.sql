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
