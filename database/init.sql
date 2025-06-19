-- Create the kyc_data table
CREATE TABLE IF NOT EXISTS kyc_data (
  id BIGSERIAL PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  gender VARCHAR(10),
  age INT CHECK (age >= 18),
  occupation VARCHAR(255),
  monthly_income NUMERIC(12,2),
  savings NUMERIC(12,2),
  investments NUMERIC(12,2),
  investment_goal VARCHAR(50),
  risk_tolerance VARCHAR(20),
  investment_timeline VARCHAR(50),
  short_term_goal VARCHAR(255),
  long_term_goal VARCHAR(255),
  investment_style VARCHAR(50),
  preferred_contact VARCHAR(50),
  profile_score INT,
  profile_rank VARCHAR(50),
  created_by_ip VARCHAR(45),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create indexes for better performance
CREATE INDEX IF NOT EXISTS idx_kyc_data_email ON kyc_data(email);
CREATE INDEX IF NOT EXISTS idx_kyc_data_created_at ON kyc_data(created_at);

-- Add comments for documentation
COMMENT ON TABLE kyc_data IS 'KYC (Know Your Customer) data for financial profiling';
COMMENT ON COLUMN kyc_data.id IS 'Primary key, auto-generated';
COMMENT ON COLUMN kyc_data.full_name IS 'Full name of the customer';
COMMENT ON COLUMN kyc_data.email IS 'Email address of the customer';
COMMENT ON COLUMN kyc_data.gender IS 'Gender of the customer';
COMMENT ON COLUMN kyc_data.age IS 'Age of the customer (must be 18 or older)';
COMMENT ON COLUMN kyc_data.occupation IS 'Occupation or job title';
COMMENT ON COLUMN kyc_data.monthly_income IS 'Monthly income amount';
COMMENT ON COLUMN kyc_data.savings IS 'Current savings amount';
COMMENT ON COLUMN kyc_data.investments IS 'Current investment amount';
COMMENT ON COLUMN kyc_data.investment_goal IS 'Primary investment goal';
COMMENT ON COLUMN kyc_data.risk_tolerance IS 'Risk tolerance level';
COMMENT ON COLUMN kyc_data.investment_timeline IS 'Investment timeline';
COMMENT ON COLUMN kyc_data.short_term_goal IS 'Short-term financial goal';
COMMENT ON COLUMN kyc_data.long_term_goal IS 'Long-term financial goal';
COMMENT ON COLUMN kyc_data.investment_style IS 'Preferred investment style';
COMMENT ON COLUMN kyc_data.preferred_contact IS 'Preferred contact method';
COMMENT ON COLUMN kyc_data.profile_score IS 'Calculated profile score (0-100)';
COMMENT ON COLUMN kyc_data.profile_rank IS 'Profile rank based on score';
COMMENT ON COLUMN kyc_data.created_by_ip IS 'IP address of the client who created the record';
COMMENT ON COLUMN kyc_data.created_at IS 'Timestamp when record was created';
COMMENT ON COLUMN kyc_data.updated_at IS 'Timestamp when record was last updated'; 