--> 'COM_LIST_DS' : table
SELECT
	OBJECT_NAME TABLE_NAME,
	SUBOBJECT_NAME,
	OBJECT_ID,
	DATA_OBJECT_ID,
	OBJECT_TYPE,
	TO_CHAR(CREATED, 'YYYYMMDDHH24MISS') CREATED,
	TO_CHAR(LAST_DDL_TIME, 'YYYYMMDDHH24MISS') LAST_DDL_TIME,
	TIMESTAMP,
	DECODE(STATUS, 'VALID', 'Y', 'N') STATUS,
	TEMPORARY,
	GENERATED,
	SECONDARY
FROM
	USER_OBJECTS
WHERE
	OBJECT_TYPE = 'TABLE'
	--> if(table != null){
	AND UPPER(OBJECT_NAME) = UPPER('COM_LIST_DS')
	--> }
ORDER BY OBJECT_NAME
