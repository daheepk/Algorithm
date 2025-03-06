# SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, B.TOTAL_PRICE AS TOTAL_SALES
# FROM (
#     SELECT B.AUTHOR_ID, B.CATEGORY, SUM(S.SALES*B.PRICE) AS TOTAL_PRICE
#     FROM BOOK_SALES S LEFT JOIN BOOK B ON S.BOOK_ID = B.BOOK_ID
#     WHERE MONTH(SALES_DATE) = 1 AND YEAR(SALES_DATE) = 2022
#     GROUP BY B.AUTHOR_ID, B.CATEGORY
# ) B LEFT JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
# ORDER BY A.AUTHOR_ID ASC, B.CATEGORY DESC;

SELECT B.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, B.TOTAL_SALES
FROM (
    SELECT B.AUTHOR_ID, B.CATEGORY, SUM(B.PRICE*SALES) AS TOTAL_SALES
    FROM BOOK_SALES S LEFT JOIN BOOK B ON S.BOOK_ID = B.BOOK_ID
    WHERE MONTH(S.SALES_DATE) = 1 AND YEAR(S.SALES_DATE) = 2022
    GROUP BY B.AUTHOR_ID, B.CATEGORY
    ) B LEFT JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
ORDER BY B.AUTHOR_ID ASC, B.CATEGORY DESC

