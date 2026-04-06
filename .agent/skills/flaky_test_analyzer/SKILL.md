# Flaky Test Analyzer

Purpose: Identify and resolve unstable automation tests.

---

## Responsibilities

Detect flaky tests caused by:

- unstable locators
- timing issues
- incorrect waits
- environment dependency

---

## Analysis Workflow

1. Detect failing test
2. Inspect error logs
3. Identify root cause
4. Suggest or apply fix

---

## Common Flaky Causes

Unstable locator

Example:

//div[3]/button

Better alternative:

data-testid or id

---

Timing issues

Avoid:

Thread.sleep  
waitForTimeout

Prefer:

explicit waits  
Playwright auto-wait

---

## Stability Strategy

Ensure:

- locator uniqueness
- correct waiting strategy
- deterministic test data