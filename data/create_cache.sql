-- ------------------------------------------------------------
-- Create table [Cache.System.Session]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `CC_SYS_SESSION`;
CREATE TABLE `CC_SYS_SESSION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LOGIC_CODE`                    VARCHAR(40) NOT NULL, 
   `FROM_CD`                       INTEGER, 
   `FROM_CODE`                     VARCHAR(40) NOT NULL, 
   `SESSION_CODE`                  VARCHAR(40) NOT NULL, 
   `USER_ID`                       BIGINT, 
   `USER_LABEL`                    VARCHAR(40), 
   `ROLE_ID`                       BIGINT, 
   `ROLE_CODE`                     VARCHAR(40), 
   `ROLE_MODULES`                  VARCHAR(2000), 
   `LOCATION_LONGITUDE`            DOUBLE, 
   `LOCATION_LATITUDE`             DOUBLE, 
   `PROJECT_ID`                    BIGINT, 
   `APPLICATION_ID`                BIGINT, 
   `PARAMETERS`                    VARCHAR(2000), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=HEAP DEFAULT CHARSET=utf8; 

ALTER TABLE CC_SYS_SESSION 
   ADD CONSTRAINT CC_SYS_SES_UK_GID UNIQUE ( GUID ); 

ALTER TABLE CC_SYS_SESSION 
   ADD CONSTRAINT CC_SYS_SES_UK_SCD UNIQUE ( LOGIC_CODE, FROM_CODE, SESSION_CODE );

-- ------------------------------------------------------------
-- Create table [Cache.System.Validation]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `CC_SYS_VALIDATION`;
CREATE TABLE `CC_SYS_VALIDATION` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `PASSPORT`                      VARCHAR(40), 
   `MOBILE_NUMBER`                 VARCHAR(40), 
   `VALIDATE_CD`                   INTEGER, 
   `CHECK_CODE`                    VARCHAR(40), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=HEAP DEFAULT CHARSET=utf8; 

ALTER TABLE CC_SYS_VALIDATION 
   ADD CONSTRAINT CC_SYS_VALID_UK_GID UNIQUE ( GUID ); 