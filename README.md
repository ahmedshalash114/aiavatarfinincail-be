# Financial Twin KYC Data API

This Spring Boot application provides a RESTful API for managing KYC (Know Your Customer) data with PostgreSQL database integration.

## Features

- ✅ Complete CRUD operations for KYC data
- ✅ Data validation with comprehensive error handling
- ✅ PostgreSQL database integration
- ✅ Automatic IP address tracking
- ✅ RESTful API design
- ✅ Cross-origin resource sharing (CORS) enabled

## Database Schema

The application uses the following PostgreSQL table structure:

```sql
CREATE TABLE kyc_data (
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
```

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- PostgreSQL 12 or higher

## Setup Instructions

### 1. Database Setup

1. Create a PostgreSQL database:
```sql
CREATE DATABASE financial_twin_db;
```

2. Update the database configuration in `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/financial_twin_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 2. Build and Run

```bash
# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Endpoints

### Base URL
```
http://localhost:8080/api/v1/kyc-data
```

### 1. Create KYC Data
**POST** `/api/v1/kyc-data`

Creates a new KYC data record.

**Request Body:**
```json
{
  "fullName": "John Doe",
  "email": "john.doe@example.com",
  "gender": "Male",
  "age": 30,
  "occupation": "Software Engineer",
  "monthlyIncome": 5000.00,
  "savings": 25000.00,
  "investments": 15000.00,
  "investmentGoal": "Retirement",
  "riskTolerance": "Moderate",
  "investmentTimeline": "10-15 years",
  "shortTermGoal": "Emergency fund",
  "longTermGoal": "Financial independence",
  "investmentStyle": "Diversified",
  "preferredContact": "Email",
  "profileScore": 75,
  "profileRank": "Gold"
}
```

**Response:**
```json
{
  "id": 1,
  "fullName": "John Doe",
  "email": "john.doe@example.com",
  "gender": "Male",
  "age": 30,
  "occupation": "Software Engineer",
  "monthlyIncome": 5000.00,
  "savings": 25000.00,
  "investments": 15000.00,
  "investmentGoal": "Retirement",
  "riskTolerance": "Moderate",
  "investmentTimeline": "10-15 years",
  "shortTermGoal": "Emergency fund",
  "longTermGoal": "Financial independence",
  "investmentStyle": "Diversified",
  "preferredContact": "Email",
  "profileScore": 75,
  "profileRank": "Gold",
  "createdByIp": "192.168.1.100",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### 2. Get KYC Data by ID
**GET** `/api/v1/kyc-data/{id}`

Retrieves a specific KYC data record by ID.

### 3. Get All KYC Data
**GET** `/api/v1/kyc-data`

Retrieves all KYC data records.

### 4. Update KYC Data
**PUT** `/api/v1/kyc-data/{id}`

Updates an existing KYC data record.

### 5. Delete KYC Data
**DELETE** `/api/v1/kyc-data/{id}`

Deletes a KYC data record.

## Validation Rules

- **fullName**: Required, max 255 characters
- **email**: Required, valid email format, max 255 characters
- **gender**: Optional, max 10 characters
- **age**: Optional, minimum 18, maximum 120
- **occupation**: Optional, max 255 characters
- **monthlyIncome**: Optional, greater than 0, max 10 digits before decimal, 2 after
- **savings**: Optional, non-negative, max 10 digits before decimal, 2 after
- **investments**: Optional, non-negative, max 10 digits before decimal, 2 after
- **investmentGoal**: Optional, max 50 characters
- **riskTolerance**: Optional, max 20 characters
- **investmentTimeline**: Optional, max 50 characters
- **shortTermGoal**: Optional, max 255 characters
- **longTermGoal**: Optional, max 255 characters
- **investmentStyle**: Optional, max 50 characters
- **preferredContact**: Optional, max 50 characters
- **profileScore**: Optional, 0-100 range
- **profileRank**: Optional, max 50 characters

## Error Handling

The API provides structured error responses:

```json
{
  "timestamp": "2024-01-15T10:30:00",
  "status": 400,
  "error": "Validation Error",
  "message": "Invalid input data",
  "details": {
    "email": "Email must be a valid email address",
    "age": "Age must be at least 18"
  }
}
```

## Testing the API

### Using cURL

```bash
# Create KYC data
curl -X POST http://localhost:8080/api/v1/kyc-data \
  -H "Content-Type: application/json" \
  -d '{
    "fullName": "Jane Smith",
    "email": "jane.smith@example.com",
    "gender": "Female",
    "age": 28,
    "occupation": "Financial Analyst",
    "monthlyIncome": 6000.00,
    "savings": 30000.00,
    "investments": 20000.00,
    "investmentGoal": "Wealth Building",
    "riskTolerance": "Aggressive",
    "investmentTimeline": "5-10 years",
    "shortTermGoal": "Down payment for house",
    "longTermGoal": "Early retirement",
    "investmentStyle": "Growth-focused",
    "preferredContact": "Phone",
    "profileScore": 85,
    "profileRank": "Platinum"
  }'

# Get all KYC data
curl -X GET http://localhost:8080/api/v1/kyc-data

# Get specific KYC data
curl -X GET http://localhost:8080/api/v1/kyc-data/1
```

### Using Postman

1. Import the collection or create new requests
2. Set the base URL to `http://localhost:8080/api/v1/kyc-data`
3. Use the JSON examples above for request bodies

## Security Features

- Input validation and sanitization
- SQL injection prevention through JPA
- XSS protection through proper content types
- IP address tracking for audit trails

## Monitoring and Logging

The application includes comprehensive logging:
- SQL queries (DEBUG level)
- Application events
- Error tracking
- Performance metrics

## Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Add tests
5. Submit a pull request

## License

This project is licensed under the MIT License. 