DECLARE
    CURSOR c_loans IS
        SELECT LoanID, InterestRate
        FROM Loans;

    v_loan_id Loans.LoanID%TYPE;
    v_interest_rate Loans.InterestRate%TYPE;
    v_new_interest_rate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_loan_id, v_interest_rate;
        EXIT WHEN c_loans%NOTFOUND;

        -- Apply the new interest rate policy
        -- For example, let's assume the new policy is to increase the interest rate by 0.5%
        v_new_interest_rate := v_interest_rate + 0.5;

        -- Update the loan's interest rate
        UPDATE Loans
        SET InterestRate = v_new_interest_rate
        WHERE LoanID = v_loan_id;
    END LOOP;
    CLOSE c_loans;

    COMMIT;
END;
/
