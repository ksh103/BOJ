/* -------------------- SQL 고득점 Kit -------------------- */

# 1. 고양이와 개는 몇 마리 있을까
SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) `count` 
FROM ANIMAL_INS
GROUP BY ANIMAL_TYPE
ORDER BY ANIMAL_TYPE;


# 2. 동명 동물 수 찾기
SELECT NAME, COUNT(NAME) `count` 
FROM ANIMAL_INS
GROUP BY NAME
HAVING (COUNT(NAME) >= 2)
ORDER BY NAME;


# 3. 입양 시각 구하기(1)
SELECT HOUR(DATETIME), COUNT(DATETIME) 
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) >= 9
AND HOUR(DATETIME) <= 19
GROUP BY HOUR(DATETIME)
ORDER BY HOUR(DATETIME);


# 4. 입양 시각 구하기(2)
-- 실패 코드
-- SELECT HOUR(DATETIME), COUNT(DATETIME)
-- FROM ANIMAL_OUTS
-- WHERE HOUR(DATETIME) >= 0
-- AND HOUR(DATETIME) <= 23
-- GROUP BY HOUR(DATETIME)
-- ORDER BY HOUR(DATETIME);

-- 통과 코드
SET @HOUR = -1;
SELECT (@HOUR := @HOUR +1) AS HOUR,
    (SELECT COUNT(HOUR(DATETIME)) 
    FROM ANIMAL_OUTS 
    WHERE @HOUR = HOUR(DATETIME)) `count`
    FROM ANIMAL_OUTS
WHERE @HOUR < 23;