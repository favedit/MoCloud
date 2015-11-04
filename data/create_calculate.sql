-- ------------------------------------------------------------
-- Create table [Calculate.Financial.Product.Period]
-- 20151104 sunhr
-- ------------------------------------------------------------
DROP TABLE `CL_FIN_PRODUCT_PERIOD`
CREATE TABLE `CL_FIN_PRODUCT_PERIOD` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `PRODUCT_CODE`                  VARCHAR(3040), 
   `PRODUCT_ISSUE`                 INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MYISAM DEFAULT CHARSET=utf8; 

ALTER TABLE CL_FIN_PRODUCT_PERIOD 
   ADD CONSTRAINT CL_FIN_PDT_PRD_UK_GID UNIQUE ( GUID ); 