USE Practical_Data;
SELECT ename,
year(hiredate)
AS jyear
FROM Emply_data
WHERE jyear<1981 ;
