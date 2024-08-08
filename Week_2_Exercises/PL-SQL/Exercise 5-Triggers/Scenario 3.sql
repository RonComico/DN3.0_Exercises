CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
    v_balance Accounts.Balance%TYPE;
BEGIN
    -- Check if the transaction is a withdrawal
    IF :NEW.Amount < 0 THEN
        -- Get the current balance of the account
        SELECT Balance INTO v_balance
        FROM Accounts
        WHERE AccountID = :NEW.AccountID
        FOR UPDATE;

        -- Ensure that the withdrawal does not exceed the balance
        IF v_balance + :NEW.Amount < 0 THEN
            RAISE_APPLICATION_ERROR(-20001, 'Insufficient balance for withdrawal');
        END IF;
    END IF;

    -- Check if the transaction is a deposit
    IF :NEW.Amount > 0 THEN
        -- Ensure that the deposit amount is positive
        IF :NEW.Amount <= 0 THEN
            RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive');
        END IF;
    END IF;
END CheckTransactionRules;
/
