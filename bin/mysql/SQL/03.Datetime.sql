#####################################################
#                                                   #
#                  날짜 / 시간 조작                 #
#                                                   #
#####################################################

/*
*   1. 테이블 생성
*/
CREATE TABLE if NOT EXISTS dateTable (
    id INT primary key auto_increment,
    regDate DATE DEFAULT (current_date),
    modTime datetime DEFAULT CURRENT_TIMESTAMP
);

/*
    2. 데이터 입력
*/
INSERT INTO dateTable VALUES (default, default, DEFAULT);
INSERT INTO dateTable(id) VALUES (DEFAULT);
INSERT INTO dateTable(regDate, modTime) VALUES
    ('2024-01-01', '2024-01-31 10:25:00'),
    ('2024-02-01', '2024-02-02 10:45:00');

/*
    3. 데이터 조회
*/
# 2024-02-02 형식
SELECT regDate, DATE_FORMAT(modTime, '%Y-%m-%d') FROM dateTable;

# 10:45:00 형식
SELECT DATE_FORMAT(modTime, '%h:%i:%s %p') FROM dateTable;

# 24-02-02 16:45 형식
SELECT DATE_FORMAT(modTime, '%Y-%m-%d %h:%i %p') FROM dateTable;

# 날짜 조회 함수
SELECT NOW(), CURDATE(),CURTIME();

/*
    4. 데이터 수정
*/
UPDATE dateTable SET regDate=CURDATE(), modTime=NOW() WHERE id=3;

/*
    5. 날짜 계산
*/
# 날짜 더하기 / 뺴기
SELECT DATE_ADD(NOW(), INTERVAL 40 DAY);
SELECT DATE_SUB(CURDATE(), INTERVAL 3 MONTH);

# D-day 계산
SELECT TO_DAYS('2024-11-14') - TO_DAYS(CURDATE());

# 요일: 1- 일요일
SELECT DAYOFWEEK(regDate) FROM dateTable;





