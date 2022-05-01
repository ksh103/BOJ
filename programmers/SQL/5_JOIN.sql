/* -------------------- SQL 고득점 Kit -------------------- */

# 1. 없어진 기록 찾기
SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_OUTS a LEFT OUTER JOIN ANIMAL_INS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL
ORDER BY a.ANIMAL_ID;


# 2. 있었는데요 없었습니다
SELECT a.ANIMAL_ID, a.NAME
FROM ANIMAL_INS a JOIN ANIMAL_OUTS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE (a.DATETIME >= b.DATETIME)
ORDER BY a.DATETIME;


# 3. 오랜 기간 보호한 동물(1)
SELECT a.NAME, a.DATETIME
FROM ANIMAL_INS a LEFT OUTER JOIN ANIMAL_OUTS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE b.ANIMAL_ID IS NULL
ORDER BY a.DATETIME
LIMIT 3;


# 4. 보호소에서 중성화한 동물
SELECT a.ANIMAL_ID, a.ANIMAL_TYPE, a.NAME
FROM ANIMAL_INS a JOIN ANIMAL_OUTS b
ON a.ANIMAL_ID = b.ANIMAL_ID
WHERE a.SEX_UPON_INTAKE LIKE 'Intact%'
AND (b.SEX_UPON_OUTCOME LIKE 'Spayed%' 
     OR b.SEX_UPON_OUTCOME LIKE 'Neutered%');