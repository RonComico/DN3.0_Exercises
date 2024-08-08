CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN Employees.DepartmentID%TYPE,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    -- Update the salary of employees in the given department by adding the bonus percentage
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonus_percentage / 100)
    WHERE DepartmentID = p_department_id;
    
    -- Commit the transaction
    COMMIT;
END UpdateEmployeeBonus;
/
