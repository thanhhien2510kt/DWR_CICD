# Locator Healer Agent

Purpose: Automatically repair broken locators when automation tests fail.

---

## Responsibilities

When a locator fails:

1. Inspect current DOM or UI hierarchy
2. Identify updated attributes
3. Replace outdated locator
4. Re-run test

---

## Detection Strategy

Locator is considered broken when:

- element not found
- element detached
- selector matches zero elements

---

## Healing Strategy

Try the following steps:

1. Re-evaluate existing locator
2. Find similar attributes
3. Switch to better locator type
4. Validate uniqueness

---

## Healing Priority

1. accessibility attributes
2. data-testid
3. id
4. semantic locator
5. css selector
6. xpath

---

## Verification

After healing:

- locator must match exactly one element
- test must pass successfully