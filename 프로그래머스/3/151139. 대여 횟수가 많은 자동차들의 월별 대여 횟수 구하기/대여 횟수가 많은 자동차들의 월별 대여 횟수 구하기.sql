SELECT MONTH(START_DATE) AS MONTH, CAR_ID, COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE CAR_ID IN (
    SELECT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= '2022-08-01' AND '2022-10-31' >= START_DATE
    GROUP BY CAR_ID 
    HAVING COUNT(*) >= 5
)
AND START_DATE BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY MONTH(START_DATE), CAR_ID
HAVING COUNT(*) > 0
ORDER BY MONTH ASC, CAR_ID DESC

# select * 
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where car_id = 28