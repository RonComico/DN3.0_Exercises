SET SERVEROUTPUT ON;
DECLARE
    CURSOR c_loans IS
        SELECT c.CustomerID, c.Name, l.DueDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30;
    
    v_customer_id Loans.CustomerID%TYPE;
    v_name Customers.Name%TYPE;
    v_due_date Loans.DueDate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_customer_id, v_name, v_due_date;
        EXIT WHEN c_loans%NOTFOUND;
        
        -- Print the reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Dear ' || v_name || ', your loan is due on ' || TO_CHAR(v_due_date, 'YYYY-MM-DD') || '.');
    END LOOP;
    CLOSE c_loans;
END;
/
