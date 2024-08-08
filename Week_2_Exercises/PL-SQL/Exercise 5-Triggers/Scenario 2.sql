CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (TransactionID, AccountID, Amount, TransactionDate, LogDate)
    VALUES (:NEW.TransactionID, :NEW.AccountID, :NEW.Amount, :NEW.TransactionDate, SYSDATE);
END LogTransaction;
/
