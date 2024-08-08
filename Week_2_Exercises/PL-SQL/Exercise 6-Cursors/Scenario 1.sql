DECLARE
    CURSOR c_transactions IS
        SELECT t.CustomerID, t.TransactionDate, t.Amount
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
        AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE)
        ORDER BY t.CustomerID;

    v_customer_id Transactions.CustomerID%TYPE;
    v_transaction_date Transactions.TransactionDate%TYPE;
    v_amount Transactions.Amount%TYPE;
BEGIN
    OPEN c_transactions;
    LOOP
        FETCH c_transactions INTO v_customer_id, v_transaction_date, v_amount;
        EXIT WHEN c_transactions%NOTFOUND;

        DBMS_OUTPUT.PUT_LINE('Customer ID: ' || v_customer_id);
        DBMS_OUTPUT.PUT_LINE('Transaction Date: ' || v_transaction_date);
        DBMS_OUTPUT.PUT_LINE('Amount: ' || v_amount);
        DBMS_OUTPUT.PUT_LINE('--------------------------');
    END LOOP;
    CLOSE c_transactions;
END;
/
