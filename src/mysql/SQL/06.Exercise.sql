# 1. 2009년도에 데뷔한 걸그룹의 히트송은?
# (걸그룹 이름, 데뷔일자, 히트송 제목)
SELECT l.name 그룹명, l.debut 데뷔일자, r.title 제목 FROM girl_group l
	JOIN song r
	ON r.sid=l.hit_song_id
    WHERE YEAR(debut)=2009;

# 2. 데뷔일자가 빠른 5개 그룹의 히트송은?
# (걸그룹 이름, 데뷔일자, 히트송 제목)
SELECT l.name 그룹명, l.debut 데뷔일자, r.title 제목 FROM girl_group l
	JOIN song r
	ON r.sid=l.hit_song_id
	ORDER BY l.debut ASC
	LIMIT 5

# 3. 대륙별로 국가 숫자, GNP의 합, 평균 국가별 GNP는?
SELECT continent 대륙명, COUNT(*) 국가수, SUM(GNP) GNP합, ROUND(AVG(GNP)) GNP평균 FROM country 
    GROUP BY continent;

# 4. 아시아 대륙에서 인구가 가장 많은 도시 10개를 내림차순으로 보여줄 것
# (대륙명, 국가명, 도시명, 인구수)
SELECT region 대륙명, l.Name 국가명, r.Name 도시명, r.Population 인구수 FROM country l
    JOIN city r
    ON l.Code=r.CountryCode
    WHERE continent='Asia'
    ORDER BY r.Population DESC
    LIMIT 10; 

# 5. 전 세계에서 GNP가 높은 10개 국가에서 사용하는 공식 언어는?
# (국가명, GNP, 언어명)
SELECT l.Name 국가명, l.GNP, r.`Language` 언어 FROM country l
JOIN countrylanguage r ON l.Code=r.CountryCode
WHERE r.IsOfficial='T'
ORDER BY l.GNP DESC
LIMIT 10;