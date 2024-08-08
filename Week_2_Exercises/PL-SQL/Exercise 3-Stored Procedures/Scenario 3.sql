CREATE OR REPLACE PROCEDURE TransferFunds (
    p_from_account_id IN Accounts.AccountID%TYPE,
    p_to_account_id IN Accounts.AccountID%TYPE,
    p_amount IN NUMBER
) IS
    e_insufficient_funds EXCEPTION;
    v_balance Accounts.Balance%TYPE;
BEGIN
    -- Check if the from account has sufficient funds
    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_from_account_id
    FOR UPDATE;

    IF v_balance < p_amount THEN
        RAISE e_insufficient_funds;
    END IF;

    -- Perform the transfer
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_from_account_id;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_to_account_id;

    -- Commit the transaction
    COMMIT;

EXCEPTION
    WHEN e_insufficient_funds THEN
        -- Log the error message
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES ('Insufficient funds in account ' || p_from_account_id, SYSDATE);
        -- Rollback the transaction
        ROLLBACK;

    WHEN OTHERS THEN
        -- Log any other errors
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        -- Rollback the transaction
        ROLLBACK;
END TransferFunds;
/
