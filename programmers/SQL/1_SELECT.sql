/* -------------------- SQL 고득점 Kit -------------------- */

# 1. 모든 레코드 조회하기
SELECT * FROM ANIMAL_INS 
ORDER BY ANIMAL_ID;


# 2. 역순 정렬하기
SELECT NAME, DATETIME FROM ANIMAL_INS 
ORDER BY ANIMAL_ID DESC;


# 3. 아픈 동물 찾기
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
WHERE INTAKE_CONDITION = 'Sick';


# 4. 어린 동물 찾기
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
WHERE INTAKE_CONDITION NOT IN (
    SELECT INTAKE_CONDITION
    FROM ANIMAL_INS
    WHERE INTAKE_CONDITION = 'Aged'
);


# 5. 동물의 아이디와 이름
SELECT ANIMAL_ID, NAME FROM ANIMAL_INS
ORDER BY ANIMAL_ID;


# 6. 여러 기준으로 정렬하기
SELECT ANIMAL_ID, NAME, DATETIME 
FROM ANIMAL_INS
ORDER BY NAME ASC, DATETIME DESC;


# 7. 상위 n개 레코드
SELECT NAME FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;