SELECT u.name, SUM(Transactions.amount) AS balance
FROM Users u
JOIN Transactions
ON u.account = Transactions.account
GROUP BY u.account, u.name
HAVING SUM(Transactions.amount) > 10000;