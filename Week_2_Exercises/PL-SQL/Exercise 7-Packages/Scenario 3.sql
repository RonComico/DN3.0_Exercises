
CREATE OR REPLACE PACKAGE AccountOperations AS
    PROCEDURE OpenNewAccount (
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    );

    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    );

    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER;
END AccountOperations;
/

CREATE OR REPLACE PACKAGE BODY AccountOperations AS

    PROCEDURE OpenNewAccount (
        p_account_id IN NUMBER,
        p_customer_id IN NUMBER,
        p_account_type IN VARCHAR2,
        p_balance IN NUMBER
    ) IS
    BEGIN
        INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
        VALUES (p_account_id, p_customer_id, p_account_type, p_balance, SYSDATE);
    EXCEPTION
        WHEN DUP_VAL_ON_INDEX THEN
            DBMS_OUTPUT.PUT_LINE('Account ID already exists.');
    END OpenNewAccount;

    PROCEDURE CloseAccount (
        p_account_id IN NUMBER
    ) IS
    BEGIN
        DELETE FROM Accounts
        WHERE AccountID = p_account_id;
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            DBMS_OUTPUT.PUT_LINE('Account ID not found.');
    END CloseAccount;

    FUNCTION GetTotalBalance (
        p_customer_id IN NUMBER
    ) RETURN NUMBER IS
        v_total_balance NUMBER := 0;
    BEGIN
        SELECT SUM(Balance) INTO v_total_balance
        FROM Accounts
        WHERE CustomerID = p_customer_id;
        RETURN NVL(v_total_balance, 0);
    EXCEPTION
        WHEN NO_DATA_FOUND THEN
            RETURN 0;
    END GetTotalBalance;

END AccountOperations;
/
