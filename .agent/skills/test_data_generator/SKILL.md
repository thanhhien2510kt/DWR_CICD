# Test Data Generator

Purpose: Generate reliable test data for automation tests.

---

## Responsibilities

Generate test data for:

- registration
- login
- form submission
- API payloads

---

## Data Rules

Data must be:

- unique
- deterministic
- traceable

---

## Unique Data Pattern

Recommended format:

<testName>_<timestamp>

Example:

register_user_20260311

---

## Common Data Types

Email

user_<timestamp>@test.com

Username

user_<timestamp>

Phone

random 10-digit number

---

## Constraints

Test data must:

- respect field validation
- match input format
- avoid duplication