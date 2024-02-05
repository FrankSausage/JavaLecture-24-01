#####################################################
#                                                   #
# 데이터 조작 언어(DML: Data Manipulation Language) #
#                                                   #
#####################################################

SHOW DATABASES;
USE world;
SHOW TABLES;
DESC city;

/*
    1. Select
*/
/*
SELECT 필드명
    FROM 테이블명
    JOIN 테이블명
    ON 조인 조건
    WHERE 조회 조건
    GROUP BY 필드명
    HAVING 그룹 조건
    ORDER BY 필드명 순서
    LIMIT 숫자 OFFSET 숫자;
*/

SELECT * FROM city;         # 모든 필드
SELECT NAME, population FROM city;
SELECT * FROM city LIMIT 10;
SELECT `name`, population FROM city LIMIT 10;       #필드명을 보존하고 싶을때 `back qurter` 사용

/*
    1.1 조회조건 WHERE
*/

SELECT * FROM city WHERE countrycode='KOR';
SELECT * FROM city WHERE population >= 9000000;
SELECT * FROM city WHERE countrycode='KOR' AND population >= 1000000;

SELECT DISTINCT district FROM city WHERE countrycode="KOR";         # 고유한 값 - DISTINCT

# 수도권 도시(서울, 인천, 경기)
SELECT * FROM city
    WHERE district='Seoul' or district='Inchon' or district='Kyonggi';
SELECT * FROM city WHERE district IN ('Seoul', 'Inchon', 'Kyonggi');

# 경기도에서 인구수가 홀수인 도시
SELECT * FROM city WHERE district='KYonggi' AND population % 2 = 1;

# 국내에서 인구수가 50만 ~ 100만 도시
SELECT * FROM city WHERE countrycode='KOR' AND
    population >= 500000 AND population <= 1000000;
SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000;

# 충청남북도의 도시
SELECT * FROM city
    WHERE district='Chungchongbuk' or district='Chungchongnam';
SELECT * FROM city WHERE district LIKE 'Chungchong%';        # % - 임의의 문자, 이때는 LIKE 사용

/*
    1.2 순서 (Order) - ASC(Ascending: 오름차순, default), DESC(Descending: 내림차순)
*/
# 인구수가 900만 이상인 도시를 인구수의 내림차순으로 조회조건
SELECT * FROM city WHERE population >= 9000000 
    ORDER BY population DESC;

# 국내에서 인구수가 50만 ~ 100만 도시를 지역 오름차순, 인구수 내림차순으로 조회
SELECT * FROM city WHERE countrycode='KOR' AND population between 500000 AND 1000000
    ORDER BY district ASC, population DESC;     # ASC 생략가능

/*
    1.3 갯수
*/
# 전 세계 인구수 Top 10 도시
SELECT * FROM city ORDER BY population DESC LIMIT 10;

# 국내 인구수 Top 5 도시
SELECT * FROM city WHERE countrycode='KOR' ORDER BY population DESC LIMIT 5;

# 국내 인구수 Top 11~20 도시
SELECT * FROM city WHERE countrycode='KOR' 
    ORDER BY population DESC LIMIT 10 OFFSET 10;   # 앞에서 1개를 건너뛰고, 10개를 보여줌

/*
    1.4 함수
*/
# 현재 날짜와 시각
SELECT now();       # 2024-02-01 13:44:48

# 국내 도시의 갯수 - 레코드의 갯수
SELECT count(*) FROM city WHERE countrycode='KOR';

# 최대, 최소 - 국내 도시중 인구수 최대, 최소 도시
SELECT MAX(population), MIN(population) FROM city WHERE countrycode='KOR';

# 국내 도시의 인구 평균 
SELECT ROUND(AVG(population)) FROM city WHERE countrycode='KOR';

# Aliasing
SELECT ROUND(AVG(population)) AS avgPop FROM city       # AS 생략가능
    WHERE countrycode='KOR';
SELECT count(*) numCity FROM city WHERE countrycode='KOR';

/*
    1.5 그룹핑
*/
# 국내 광역시도별 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR' GROUP BY district ORDER BY avgPop DESC;


# 도시의 갯수가 많은 나라 Top 10
SELECT countrycode, count(*) numCity FROM city GROUP BY countrycode ORDER BY numCity DESC LIMIT 10;

# 경기도의 도시 이름
SELECT `name` FROM city WHERE district='Kyonggi'
SELECT GROUP_CONCAT(`name`) cities FROM city WHERE district='Chungchongnam';

# 국내 광역시도 이름
SELECT DISTINCT district FROM city WHERE countrycode='KOR';
SELECT GROUP_CONCAT(district) districts FROM city WHERE countrycode='KOR';

/*
    1.6 그룹핑 조건
*/
# 국내 도별(도시의 갯수가 2개 이상) 인구수의 평균을 내림차순으로 조회
SELECT district, ROUND(AVG(population)) avgPop FROM city 
    WHERE countrycode='KOR' GROUP BY district 
    HAVING count(*) >= 2 ORDER BY avgPop DESC;    # 그룹핑 조건 - 도시의 갯수가 2개 이상

# 국내 도시의 갯수가 5개 이상인 도
SELECT district, count(*) numCity FROM city WHERE countrycode='KOR' 
    GROUP BY district HAVING numCity >= 5;

# 국내 도시의 갯수가 5개 이상인 도의 평균 도시 인구수를 인구 평균 내림차순으로 정렬
SELECT district, ROUND(AVG(population)) avgPop FROM city
    WHERE countrycode='KOR' GROUP BY district HAVING count(*) >= 5
    ORDER BY avgPop DESC;

# 도시 갯수가 100개 이상인 국가의 도시인구 평균을 내림차순으로 정렬
SELECT countrycode, ROUND(AVG(population)) avgPop FROM city GROUP BY countrycode HAVING count(*) >= 100
    ORDER BY avgPop DESC;

/*
    1.7 Join
*/
# 인구수가 800만보다 큰 도시의 국가명, 도시명, 인구수
SELECT country.Name, city.Name, city.population FROM city
    INNER JOIN country ON city.countrycode=country.Code
    WHERE city.population > 8000000;

SELECT r.Name countryName, l.Name cityName, l.Population FROM city l
	JOIN country r          # INNER 생략 가능
	ON l.CountryCode=r.Code
	WHERE l.Population > 8000000;

# 양쪽 테이블에서 필드명이 고유한 필드는 테이블 이름을 생략할 수 있음(Continent)
SELECT Continent, r.Name countryName, l.Name cityName, l.Population FROM city l
	JOIN country r         
	ON l.CountryCode=r.Code
	WHERE l.Population > 8000000;

# 아시아 대륙에서 인구수가 많은 도시 Top 10
SELECT r.Continent, r.Name countryName, l.Name cityName, l.Population 
	FROM city l
	JOIN country r
	ON l.CountryCode=r.Code
	WHERE r.Continent='Asia'
	ORDER BY l.Population DESC
	LIMIT 10;

# 아시아 국가의 국가명과 공식언어
SELECT l.Name countryName, r.`Language` FROM country l
	JOIN countrylanguage r
	ON l.Code=r.CountryCode
	WHERE l.Continent='Asia' AND r.IsOfficial='T';

# 3개의 테이블 JOIN
# 아시아 대륙에서 인구수가 가장 많은 Top 10 도시에서 사용하는 공식언어
SELECT r.Name countryName, l.Name cityName, l.Population, o.`Language`  FROM city l
	JOIN country r ON l.CountryCode=r.Code
	JOIN countrylanguage o ON l.CountryCode=o.CountryCode
	WHERE r.Continent='Asia' AND o.IsOfficial='T'
	ORDER BY l.Population DESC
	LIMIT 10;

/*
    1.8 Sub Query
*/
# 국내 도시만으로 새로운 테이블을 만드는 경우
CREATE TABLE if NOT EXISTS kcity LIKE city;
INSERT INTO kcity
    SELECT * FROM city WHERE countrycode='KOR';