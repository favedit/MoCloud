-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Dynamic]
-- ------------------------------------------------------------
-- DELETE FROM ST_FIN_DYNAMIC;
DROP TABLE IF EXISTS `ST_FIN_DYNAMIC`;
CREATE TABLE `ST_FIN_DYNAMIC` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `DEPARTMENT_IDS`                VARCHAR(200), 
   `DEPARTMENT_LABELS`             VARCHAR(400), 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `MARKETER_STATUS_CD`            INTEGER, 
   `MARKETER_RANK`                 VARCHAR(40), 
   `CUSTOMER_ID`                   BIGINT, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `CUSTOMER_PHONE`                VARCHAR(20), 
   `CUSTOMER_CARD`                 VARCHAR(20), 
   `CUSTOMER_ACTION_CD`            INTEGER, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_ACTION_AMOUNT`        DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DYNAMIC 
   ADD CONSTRAINT ST_FIN_DYN_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DYNAMIC ADD INDEX ST_FIN_DYN_IX_CST_ACT_DAT(CUSTOMER_ACTION_DATE);

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Customer.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_CUSTOMER_AMOUNT`;
CREATE TABLE `ST_FIN_CUSTOMER_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CUSTOMER_ID`                   BIGINT NOT NULL, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER_AMOUNT 
   ADD CONSTRAINT ST_FIN_CST_AMT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_CUSTOMER_AMOUNT 
   ADD CONSTRAINT ST_FIN_CST_AMT_UK_CUSTOMER_ID UNIQUE ( CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Customer.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_CUSTOMER_PHASE`;
CREATE TABLE `ST_FIN_CUSTOMER_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `CUSTOMER_ID`                   BIGINT, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `PERFORMANCE`                   DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER_PHASE 
   ADD CONSTRAINT ST_FIN_CST_PHS_UK_DAT UNIQUE ( RECORD_DATE, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_AMOUNT`;
CREATE TABLE `ST_FIN_MARKETER_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `INVESTMENT_TOTAL`              INTEGER, 
   `REDEMPTION_TOTAL`              INTEGER, 
   `NETINVESTMENT_TOTAL`           INTEGER, 
   `PERFORMANCE_TOTAL`             INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_AMOUNT 
   ADD CONSTRAINT ST_FIN_MKT_AMT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_PHASE`;
CREATE TABLE `ST_FIN_MARKETER_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `COMPANY_ID`                    BIGINT, 
   `COMPANY_LABEL`                 VARCHAR(40), 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `MARKETER_INVESTMENT`           INTEGER, 
   `MARKETER_INVESTMENT_TOTAL`     INTEGER, 
   `MARKETER_REDEMPTION`           INTEGER, 
   `MARKETER_REDEMPTION_TOTAL`     INTEGER, 
   `MARKETER_NETINVESTMENT`        INTEGER, 
   `MARKETER_NETINVESTMENT_TOTAL`  INTEGER, 
   `MARKETER_PERFORMANCE`          INTEGER, 
   `MARKETER_PERFORMANCE_TOTAL`    INTEGER, 
   `CUSTOMER_REGISTER`             INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_PHASE 
   ADD CONSTRAINT ST_FIN_MKT_PHS_UK_DATE UNIQUE ( RECORD_DATE ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Company.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_COMPANY_AMOUNT`;
CREATE TABLE `ST_FIN_COMPANY_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `COMPANY_ID`                    BIGINT, 
   `COMPANY_LABEL`                 VARCHAR(40), 
   `INVESTMENT_TOTAL`              INTEGER, 
   `REDEMPTION_TOTAL`              INTEGER, 
   `NETINVESTMENT_TOTAL`           INTEGER, 
   `PERFORMANCE_TOTAL`             INTEGER, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_COMPANY_AMOUNT 
   ADD CONSTRAINT ST_FIN_COMPANY_AMOUNT_UK_DATE UNIQUE ( RECORD_DATE ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Company.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_COMPANY_PHASE`;
CREATE TABLE `ST_FIN_COMPANY_PHASE` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40), 
   `RECORD_YEAR`                   DATETIME NOT NULL, 
   `RECORD_MONTH`                  DATETIME NOT NULL, 
   `RECORD_WEEK`                   DATETIME NOT NULL, 
   `RECORD_DAY`                    DATETIME NOT NULL, 
   `RECORD_HOUR`                   DATETIME NOT NULL, 
   `RECORD_DATE`                   DATETIME NOT NULL, 
   `COMPANY_ID`                    BIGINT, 
   `COMPANY_LABEL`                 VARCHAR(40), 
   `COMPANY_INVESTMENT`            INTEGER, 
   `COMPANY_INVESTMENT_TOTAL`      INTEGER, 
   `COMPANY_REDEMPTION`            INTEGER, 
   `COMPANY_REDEMPTION_TOTAL`      INTEGER, 
   `COMPANY_NETINVESTMENT`         INTEGER, 
   `COMPANY_NETINVESTMENT_TOTAL`   INTEGER, 
   `COMPANY_PERFORMANCE`           INTEGER, 
   `COMPANY_PERFORMANCE_TOTAL`     INTEGER, 
   `MARKETER_REGISTER`             INTEGER, 
   `MARKETER_TOTAL`                BIGINT, 
   `CUSTOMER_REGISTER`             INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_COMPANY_PHASE 
   ADD CONSTRAINT ST_FIN_COM_PHS_UK_DATE UNIQUE ( RECORD_DATE ); 
