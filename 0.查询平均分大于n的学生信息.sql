# 表结构：
# Scores: studentID, studentName，class，score，`subject`
SELECT
  studentName,
  class,
  Round(SUM(score) / COUNT(`subject`), 2) as average_score
FROM Scores
GROUP BY studentID
;
