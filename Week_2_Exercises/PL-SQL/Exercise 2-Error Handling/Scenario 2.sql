CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN Employees.EmployeeID%TYPE,
    p_percentage IN NUMBER
) IS
    e_employee_not_found EXCEPTION;
    PRAGMA EXCEPTION_INIT(e_employee_not_found, -01403); -- No data found
BEGIN
    -- Update the salary
    UPDATE Employees
    SET Salary = Salary + (Salary * p_percentage / 100)
    WHERE EmployeeID = p_employee_id;

    IF SQL%NOTFOUND THEN
        RAISE e_employee_not_found;
    END IF;

    -- Commit the transaction
    COMMIT;

EXCEPTION
    WHEN e_employee_not_found THEN
        -- Log the error message
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES ('Employee ID ' || p_employee_id || ' not found', SYSDATE);
        -- Rollback the transaction
        ROLLBACK;

    WHEN OTHERS THEN
        -- Log any other errors
        INSERT INTO ErrorLog (ErrorMessage, ErrorDate)
        VALUES (SQLERRM, SYSDATE);
        -- Rollback the transaction
        ROLLBACK;
END UpdateSalary;
/
