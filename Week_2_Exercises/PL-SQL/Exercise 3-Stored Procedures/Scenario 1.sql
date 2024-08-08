CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    -- Update the balance of all savings accounts by applying an interest rate of 1%
    UPDATE SavingsAccounts
    SET Balance = Balance + (Balance * 0.01);
    
    -- Commit the transaction
    COMMIT;
END ProcessMonthlyInterest;
/
