SET SERVEROUTPUT ON;
DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers;
    
    v_customer_id Customers.CustomerID%TYPE;
    v_balance Customers.Balance%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_customer_id, v_balance;
        EXIT WHEN c_customers%NOTFOUND;
        
        -- Check if the balance is greater than 10000
        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = v_customer_id;
        END IF;
    END LOOP;
    CLOSE c_customers;
    
    -- Commit the transaction to save changes
    COMMIT;
END;
/
