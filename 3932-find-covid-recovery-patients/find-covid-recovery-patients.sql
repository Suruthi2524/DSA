# Write your MySQL query statement below
SELECT 
    p.patient_id,
    p.patient_name,
    p.age,
    DATEDIFF(
        (
            SELECT MIN(ct2.test_date)
            FROM covid_tests ct2
            WHERE ct2.patient_id = p.patient_id
              AND ct2.result = 'Negative'
              AND ct2.test_date > (
                  SELECT MIN(ct3.test_date)
                  FROM covid_tests ct3
                  WHERE ct3.patient_id = p.patient_id
                    AND ct3.result = 'Positive'
              )
        ),
        (
            SELECT MIN(ct4.test_date)
            FROM covid_tests ct4
            WHERE ct4.patient_id = p.patient_id
              AND ct4.result = 'Positive'
        )
    ) AS recovery_time
FROM patients p
WHERE EXISTS (
    SELECT 1
    FROM covid_tests ct5
    WHERE ct5.patient_id = p.patient_id
      AND ct5.result = 'Positive'
)
AND EXISTS (
    SELECT 1
    FROM covid_tests ct6
    WHERE ct6.patient_id = p.patient_id
      AND ct6.result = 'Negative'
      AND ct6.test_date > (
          SELECT MIN(ct7.test_date)
          FROM covid_tests ct7
          WHERE ct7.patient_id = p.patient_id
            AND ct7.result = 'Positive'
      )
)
ORDER BY recovery_time ASC, patient_name ASC;