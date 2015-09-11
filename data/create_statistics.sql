-- ------------------------------------------------------------
-- Create table [Statistics.Controller]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_CONTROLLER`;
CREATE TABLE `ST_CONTROLLER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `CODE`                          VARCHAR(40), 
   `IS_VALID`                      TINYINT, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `PROCESS_CLASS`                 VARCHAR(200), 
   `PROCESS_PARAMETERS`            VARCHAR(400), 
   `PROCESS_COUNT`                 INTEGER, 
   `PROCESS_UNIT_TOTAL`            INTEGER, 
   `PROCESS_UNIT_COUNT`            INTEGER, 
   `PROCESS_RESULT`                VARCHAR(200), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_CONTROLLER 
   ADD CONSTRAINT ST_CTL_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Tender]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_TENDER`;
CREATE TABLE `ST_FIN_TENDER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `GROUP_NUMBER`                  INTEGER, 
   `LABEL`                         VARCHAR(800), 
   `BORROW_MODEL`                  VARCHAR(20), 
   `BORROW_DURATION`               INTEGER, 
   `BORROW_MONEY`                  DOUBLE, 
   `BORROW_INEREST`                DOUBLE, 
   `BORROW_INEREST_RATE`           FLOAT, 
   `BORROW_INFO`                   VARCHAR(2000), 
   `PROJECT_INFO`                  TEXT, 
   `COMPANY_INFO`                  TEXT, 
   `SAFEGUARD_INFO`                TEXT, 
   `MORTGAGE_INFO`                 TEXT, 
   `INVESTMENT_BEGIN_DATE`         DATETIME, 
   `INVESTMENT_END_DATE`           DATETIME, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_TENDER 
   ADD CONSTRAINT ST_FIN_TDR_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_TENDER 
   ADD CONSTRAINT ST_FIN_TDR_UK_LINK_ID UNIQUE ( LINK_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Dynamic]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DYNAMIC`;
CREATE TABLE `ST_FIN_DYNAMIC` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `LINK_BORROW_ID`                BIGINT, 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LINK_ID`            BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `DEPARTMENT_LABEL_PATH`         VARCHAR(400), 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LINK_ID`              BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `MARKETER_STATUS_CD`            INTEGER, 
   `MARKETER_RANK_LABEL`           VARCHAR(40), 
   `CUSTOMER_ID`                   BIGINT, 
   `CUSTOMER_LINK_ID`              BIGINT, 
   `CUSTOMER_LABEL`                VARCHAR(40), 
   `CUSTOMER_CARD`                 VARCHAR(20), 
   `CUSTOMER_AREA`                 VARCHAR(6), 
   `CUSTOMER_BIRTH`                VARCHAR(8), 
   `CUSTOMER_GENDER`               INTEGER, 
   `CUSTOMER_PHONE`                VARCHAR(20), 
   `CUSTOMER_ACTION_CD`            INTEGER, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_ACTION_AMOUNT`        DOUBLE, 
   `CUSTOMER_ACTION_INTEREST`      DOUBLE, 
   `TENDER_ID`                     BIGINT, 
   `TENDER_LINK_ID`                BIGINT, 
   `TENDER_MODEL`                  VARCHAR(20), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DYNAMIC 
   ADD CONSTRAINT ST_FIN_DYN_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Member]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MEMBER`;
CREATE TABLE `ST_FIN_MEMBER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `DATA_ID`                       BIGINT, 
   `PASSPORT`                      VARCHAR(40), 
   `LABEL`                         VARCHAR(40), 
   `CARD`                          VARCHAR(20), 
   `PHONE`                         VARCHAR(20), 
   `EMAIL`                         VARCHAR(80), 
   `GENDER_CD`                     INTEGER, 
   `GENDER_CODE`                   VARCHAR(8), 
   `MARRY_CD`                      INTEGER, 
   `MARRY_CODE`                    VARCHAR(8), 
   `EDUCATION_CD`                  INTEGER, 
   `EDUCATION_CODE`                VARCHAR(40), 
   `BUSINESS_CD`                   INTEGER, 
   `BUSINESS_CODE`                 VARCHAR(80), 
   `INCOME_CD`                     INTEGER, 
   `INCOME_CODE`                   VARCHAR(20), 
   `PROVINCE_AREA_ID`              BIGINT, 
   `PROVINCE_ID`                   BIGINT, 
   `PROVINCE_CODE`                 INTEGER, 
   `CITY_ID`                       BIGINT, 
   `CITY_CODE`                     INTEGER, 
   `AREA_ID`                       BIGINT, 
   `AREA_CODE`                     INTEGER, 
   `ADDRESS`                       VARCHAR(200), 
   `INFO`                          VARCHAR(800), 
   `REGISTER_DATE`                 DATETIME, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MEMBER 
   ADD CONSTRAINT ST_FIN_MEM_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MEMBER 
   ADD CONSTRAINT ST_FIN_MEM_UK_LINK_ID UNIQUE ( LINK_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_CUSTOMER`;
CREATE TABLE `ST_FIN_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `DATA_ID`                       BIGINT, 
   `LABEL`                         VARCHAR(40), 
   `PHONE`                         VARCHAR(20), 
   `CARD`                          VARCHAR(20), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER 
   ADD CONSTRAINT ST_FIN_CUS_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_CUSTOMER 
   ADD CONSTRAINT ST_FIN_CUS_UK_LINK_ID UNIQUE ( LINK_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER`;
CREATE TABLE `ST_FIN_MARKETER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `LINK_DEPARTMENT_ID`            BIGINT, 
   `DATA_ID`                       BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(80), 
   `CODE`                          VARCHAR(40), 
   `LABEL`                         VARCHAR(40), 
   `STATUS_CD`                     INTEGER, 
   `PHONE`                         VARCHAR(20), 
   `CARD`                          VARCHAR(20), 
   `RANK_LABEL`                    VARCHAR(80), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `ENTER_DATE`                    DATETIME, 
   `LEAVE_DATE`                    DATETIME, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER 
   ADD CONSTRAINT ST_FIN_MKT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MARKETER 
   ADD CONSTRAINT ST_FIN_MKT_UK_LINK_ID UNIQUE ( LINK_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT`;
CREATE TABLE `ST_FIN_DEPARTMENT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_TOP_ID`                   BIGINT, 
   `LINK_PARENT_ID`                BIGINT, 
   `LINK_ID`                       BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `LINK_ID_PATH`                  VARCHAR(400), 
   `DATA_ID`                       BIGINT, 
   `PARENT_ID`                     BIGINT, 
   `CODE`                          VARCHAR(40), 
   `TOP_LABEL`                     VARCHAR(40), 
   `LABEL`                         VARCHAR(40), 
   `LABEL_PATH`                    VARCHAR(800), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT 
   ADD CONSTRAINT ST_FIN_DEP_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT 
   ADD CONSTRAINT ST_FIN_DEP_UK_LINK_ID UNIQUE ( LINK_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_AMOUNT`;
CREATE TABLE `ST_FIN_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_TOTAL`              INTEGER, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `INVESTMENT_NUMBER_TOTAL`       INTEGER, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `REDEMPTION_NUMBER_TOTAL`       INTEGER, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_AMOUNT 
   ADD CONSTRAINT ST_FIN_AMT_UK_GID UNIQUE ( GUID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_PHASE`;
CREATE TABLE `ST_FIN_PHASE` 
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
   `ACTION_DATE`                   DATETIME, 
   `DEPARTMENT_COUNT`              INTEGER, 
   `DEPARTMENT_TOTAL`              INTEGER, 
   `MARKETER_COUNT`                INTEGER, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_COUNT`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `MEMBER_COUNT`                  INTEGER, 
   `MEMBER_TOTAL`                  INTEGER, 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `INVESTMENT_NUMBER`             INTEGER, 
   `INVESTMENT_NUMBER_TOTAL`       INTEGER, 
   `INVESTMENT_USER`               INTEGER, 
   `INVESTMENT_USER_TOTAL`         INTEGER, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `REDEMPTION_NUMBER`             INTEGER, 
   `REDEMPTION_NUMBER_TOTAL`       INTEGER, 
   `REDEMPTION_USER`               INTEGER, 
   `REDEMPTION_USER_TOTAL`         INTEGER, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST`                      DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE`                   DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_PHASE 
   ADD CONSTRAINT ST_FIN_PHS_UK_DAT UNIQUE ( RECORD_DATE ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Tender.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_TENDER_CUSTOMER`;
CREATE TABLE `ST_FIN_TENDER_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `TENDER_ID`                     BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_TENDER_CUSTOMER 
   ADD CONSTRAINT ST_FIN_TND_CST_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_TENDER_CUSTOMER 
   ADD CONSTRAINT ST_FIN_TND_CST_UK_CST UNIQUE ( TENDER_ID, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Tender.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_TENDER_AMOUNT`;
CREATE TABLE `ST_FIN_TENDER_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `TENDER_ID`                     BIGINT NOT NULL, 
   `TENDER_LABEL`                  VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_TENDER_AMOUNT 
   ADD CONSTRAINT ST_FIN_TDR_AMT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_TENDER_AMOUNT 
   ADD CONSTRAINT ST_FIN_TDR_AMT_UK_TENDER_ID UNIQUE ( TENDER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Tender.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_TENDER_PHASE`;
CREATE TABLE `ST_FIN_TENDER_PHASE` 
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
   `TENDER_ID`                     BIGINT, 
   `TENDER_LABEL`                  VARCHAR(40), 
   `TENDER_MODEL`                  VARCHAR(20), 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST`                      DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `CUSTOMER_COUNT`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_TENDER_PHASE 
   ADD CONSTRAINT ST_FIN_TND_PHS_UK_DAT UNIQUE ( RECORD_DATE, TENDER_ID ); 

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
   `CUSTOMER_CARD`                 VARCHAR(20), 
   `CUSTOMER_AREA`                 VARCHAR(6), 
   `CUSTOMER_BIRTH`                VARCHAR(8), 
   `CUSTOMER_GENDER`               INTEGER, 
   `CUSTOMER_PHONE`                VARCHAR(20), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `TENDER_ID`                     BIGINT, 
   `TENDER_MODEL`                  VARCHAR(20), 
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
   `CUSTOMER_CARD`                 VARCHAR(20), 
   `CUSTOMER_AREA`                 VARCHAR(6), 
   `CUSTOMER_BIRTH`                VARCHAR(8), 
   `CUSTOMER_GENDER`               INTEGER, 
   `CUSTOMER_PHONE`                VARCHAR(20), 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST`                      DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE`                   DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `TENDER_CHANGED`                INTEGER, 
   `TENDER_PRIOR_ID`               BIGINT, 
   `TENDER_PRIOR_MODEL`            VARCHAR(20), 
   `TENDER_ID`                     BIGINT, 
   `TENDER_MODEL`                  VARCHAR(20), 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_CUSTOMER_PHASE 
   ADD CONSTRAINT ST_FIN_CST_PHS_UK_DAT UNIQUE ( RECORD_DATE, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_CUSTOMER`;
CREATE TABLE `ST_FIN_MARKETER_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `MARKETER_ID`                   BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_CUSTOMER 
   ADD CONSTRAINT ST_FIN_MKT_CST_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MARKETER_CUSTOMER 
   ADD CONSTRAINT ST_FIN_MKT_CST_UK_CUS UNIQUE ( MARKETER_ID, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Marketer.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_MARKETER_AMOUNT`;
CREATE TABLE `ST_FIN_MARKETER_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 INTEGER, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `MARKETER_ID`                   BIGINT NOT NULL, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_AMOUNT 
   ADD CONSTRAINT ST_FIN_MKT_AMT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_MARKETER_AMOUNT 
   ADD CONSTRAINT ST_FIN_MKT_AMT_UK_MARKETER_ID UNIQUE ( MARKETER_ID ); 

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
   `LINK_ID`                       BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `MARKETER_ID`                   BIGINT, 
   `MARKETER_LABEL`                VARCHAR(40), 
   `MARKETER_INVESTMENT`           DOUBLE, 
   `MARKETER_INVESTMENT_TOTAL`     DOUBLE, 
   `MARKETER_REDEMPTION`           DOUBLE, 
   `MARKETER_REDEMPTION_TOTAL`     DOUBLE, 
   `MARKETER_NETINVESTMENT`        DOUBLE, 
   `MARKETER_NETINVESTMENT_TOTAL`  DOUBLE, 
   `MARKETER_INTEREST`             DOUBLE, 
   `MARKETER_INTEREST_TOTAL`       DOUBLE, 
   `MARKETER_PERFORMANCE`          DOUBLE, 
   `MARKETER_PERFORMANCE_TOTAL`    DOUBLE, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_COUNT`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_MARKETER_PHASE 
   ADD CONSTRAINT ST_FIN_MKT_PHS_UK_DAT UNIQUE ( RECORD_DATE, MARKETER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Customer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_CUSTOMER`;
CREATE TABLE `ST_FIN_DEPARTMENT_CUSTOMER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 BIGINT, 
   `MARKETER_ID`                   BIGINT, 
   `CUSTOMER_ID`                   BIGINT, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_CUSTOMER 
   ADD CONSTRAINT ST_FIN_DEP_CST_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT_CUSTOMER 
   ADD CONSTRAINT ST_FIN_DEP_CST_UK_CST UNIQUE ( DEPARTMENT_ID, CUSTOMER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Marketer]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_MARKETER`;
CREATE TABLE `ST_FIN_DEPARTMENT_MARKETER` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 BIGINT NOT NULL, 
   `DEPARTMENT_LEVEL`              INTEGER, 
   `MARKETER_ID`                   BIGINT NOT NULL, 
   `LINK_DATE`                     DATETIME, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_MARKETER 
   ADD CONSTRAINT ST_FIN_DEP_MKT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT_MARKETER 
   ADD CONSTRAINT ST_FIN_DEP_MKT_UK_MKT UNIQUE ( DEPARTMENT_ID, MARKETER_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Amount]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_AMOUNT`;
CREATE TABLE `ST_FIN_DEPARTMENT_AMOUNT` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `DEPARTMENT_ID`                 BIGINT NOT NULL, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `MARKETER_TOTAL`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_AMOUNT 
   ADD CONSTRAINT ST_FIN_DEP_AMOUNT_UK_GID UNIQUE ( GUID ); 

ALTER TABLE ST_FIN_DEPARTMENT_AMOUNT 
   ADD CONSTRAINT ST_FIN_DEP_AMOUNT_UK_DEPARTMENT_ID UNIQUE ( DEPARTMENT_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Department.Phase]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_DEPARTMENT_PHASE`;
CREATE TABLE `ST_FIN_DEPARTMENT_PHASE` 
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
   `DEPARTMENT_ID`                 BIGINT, 
   `DEPARTMENT_LABEL`              VARCHAR(40), 
   `DEPARTMENT_INVESTMENT`         DOUBLE, 
   `DEPARTMENT_INVESTMENT_TOTAL`   DOUBLE, 
   `DEPARTMENT_REDEMPTION`         DOUBLE, 
   `DEPARTMENT_REDEMPTION_TOTAL`   DOUBLE, 
   `DEPARTMENT_NETINVESTMENT`      DOUBLE, 
   `DEPARTMENT_NETINVESTMENT_TOTAL` DOUBLE, 
   `DEPARTMENT_INTEREST`           DOUBLE, 
   `DEPARTMENT_INTEREST_TOTAL`     DOUBLE, 
   `DEPARTMENT_PERFORMANCE`        DOUBLE, 
   `DEPARTMENT_PERFORMANCE_TOTAL`  DOUBLE, 
   `MARKETER_COUNT`                INTEGER, 
   `MARKETER_TOTAL`                BIGINT, 
   `CUSTOMER_ACTION_DATE`          DATETIME, 
   `CUSTOMER_COUNT`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_DEPARTMENT_PHASE 
   ADD CONSTRAINT ST_FIN_DEP_PHS_UK_DAT UNIQUE ( RECORD_DATE, DEPARTMENT_ID ); 

-- ------------------------------------------------------------
-- Create table [Statistics.Financial.Forecast]
-- ------------------------------------------------------------
DROP TABLE IF EXISTS `ST_FIN_FORECAST`;
CREATE TABLE `ST_FIN_FORECAST` 
( 
   `OUID`                          BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
   `OVLD`                          TINYINT NOT NULL DEFAULT TRUE, 
   `GUID`                          VARCHAR(40) NOT NULL, 
   `ACTION_DATE`                   DATETIME, 
   `INVESTMENT`                    DOUBLE, 
   `INVESTMENT_TOTAL`              DOUBLE, 
   `REDEMPTION`                    DOUBLE, 
   `REDEMPTION_TOTAL`              DOUBLE, 
   `NETINVESTMENT`                 DOUBLE, 
   `NETINVESTMENT_TOTAL`           DOUBLE, 
   `INTEREST`                      DOUBLE, 
   `INTEREST_TOTAL`                DOUBLE, 
   `PERFORMANCE`                   DOUBLE, 
   `PERFORMANCE_TOTAL`             DOUBLE, 
   `CUSTOMER_COUNT`                INTEGER, 
   `CUSTOMER_TOTAL`                INTEGER, 
   `CREATE_USER_ID`                BIGINT, 
   `CREATE_DATE`                   DATETIME, 
   `UPDATE_USER_ID`                BIGINT, 
   `UPDATE_DATE`                   DATETIME 
) ENGINE=MyISAM DEFAULT CHARSET=utf8; 

ALTER TABLE ST_FIN_FORECAST 
   ADD CONSTRAINT ST_FIN_FCT_UK_GID UNIQUE ( GUID ); 


