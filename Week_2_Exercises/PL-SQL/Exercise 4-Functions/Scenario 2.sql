CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
    p_loan_amount IN NUMBER,
    p_interest_rate IN NUMBER,
    p_loan_duration_years IN NUMBER
) RETURN NUMBER IS
    v_monthly_installment NUMBER;
    v_monthly_interest_rate NUMBER := p_interest_rate / 12 / 100;
    v_number_of_payments NUMBER := p_loan_duration_years * 12;
BEGIN
    v_monthly_installment := p_loan_amount * v_monthly_interest_rate / 
        (1 - POWER(1 + v_monthly_interest_rate, -v_number_of_payments));
    RETURN v_monthly_installment;
END CalculateMonthlyInstallment;
/
