-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, DATE_FORMAT(DATE_OF_BIRTH,'%Y-%m-%d')
FROM MEMBER_PROFILE
where GENDER = 'W' 
AND TLNO IS NOT NULL
AND DATE_FORMAT(DATE_OF_BIRTH,'%m')='03';