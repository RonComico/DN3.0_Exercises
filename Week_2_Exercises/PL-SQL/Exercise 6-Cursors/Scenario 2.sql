DECLARE
    CURSOR c_accounts IS
        SELECT AccountID, Balance
        FROM Accounts;

    v_account_id Accounts.AccountID%TYPE;
    v_balance Accounts.Balance%TYPE;
    v_annual_fee CONSTANT NUMBER := 100; -- Assume the annual fee is 100
BEGIN
    OPEN c_accounts;
    LOOP
        FETCH c_accounts INTO v_account_id, v_balance;
        EXIT WHEN c_accounts%NOTFOUND;

        -- Deduct the annual fee from the account balance
        UPDATE Accounts
        SET Balance = Balance - v_annual_fee
        WHERE AccountID = v_account_id;
    END LOOP;
    CLOSE c_accounts;

    COMMIT;
END;
/
