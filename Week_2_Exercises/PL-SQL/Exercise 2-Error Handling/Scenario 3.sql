CREATE OR REPLACE PROCEDURE AddNewCustomer (
    p_customer_id IN Customers.CustomerID%TYPE,
    p_name IN Customers.Name%TYPE,
    p_dob IN Customers.DOB%TYPE
) IS
    e_duplicate_customer EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_duplicate_customer, -00001); -- Unique constraint violation
BEGIN
    -- Insert the new customer
    INSERT INTO Customers (CustomerID, Name, DOB)
    VALUES (p_customer_id, p_name, p_dob);

    -- Commit the transaction
    COMMIT;

EXCEPTION
    WHEN e_duplicate_customer THEN
        -- Log the error message
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES ('Customer ID ' || p_customer_id || ' already exists', SYSDATE);
        -- Rollback the transaction
        ROLLBACK;

    WHEN OTHERS THEN
        -- Log any other errors
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        -- Rollback the transaction
        ROLLBACK;
END AddNewCustomer;
/
