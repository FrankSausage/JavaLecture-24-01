# MySQL world database에 있는 테이블을 활용해서 다음 문항에 답하세요. #

#1) 국내 광역시도별 도시의 개수가 많은 5개 광역시도를 조회하는 SQL
SELECT district 광역시도, COUNT(*) 도시수 FROM city
    WHERE CountryCode='KOR'
    GROUP BY district
    ORDER BY COUNT(*) DESC LIMIT 5;

#2) 인구수가 800만 보다 큰 도시의 국가명, 도시명, 인구수를 조회하는 SQL
SELECT cty.name 국가명 , ct.name 도시명, ct.Population 인구수 FROM city ct
	JOIN country cty ON ct.CountryCode=cty.Code
	WHERE ct.Population >= 8000000
	ORDER BY ct.Population desc


#3) 아시아 대륙에서 인구수가 가장 많은 도시 Top 10을 조회하는 SQL (국가명, 도시명, 인구수)
SELECT cty.name 국가명 , ct.name 도시명, ct.Population 인구수 FROM city ct
	JOIN country cty ON ct.CountryCode=cty.Code
	WHERE continent='Asia'
	ORDER BY ct.Population DESC LIMIT 10

#4) 강원도(Kang-won)에 인구가 120000인 태백시를 삽입하는 SQL
INSERT into city VALUES(DEFAULT, '태백시','KOR',"Kang-won", 120000)

#5) Chunchon 시의 이름과 인구수를 춘천과 30만으로 변경하는 SQL
UPDATE city SET NAME='춘천', Population=300000 WHERE id=2365

