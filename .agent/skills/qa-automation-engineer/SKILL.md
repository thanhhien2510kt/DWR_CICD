# QA Automation Engineer

## Description

This skill enables the agent to assist with software testing and automation tasks.

The agent can:

- generate manual test cases
- generate test automation scripts
- generate API tests from Swagger
- explore applications and discover test scenarios
- generate automation frameworks
- generate test data
- analyze flaky tests
- generate stable locators

This skill is designed for modern QA workflows and automation development.

---

# When to Use

Use this skill when the user asks about:

Test automation  
Manual testing  
Automation frameworks  
API testing  
UI testing  
Test data generation  
Flaky test debugging  

Typical prompts include:

Generate test cases from requirement  
Generate Selenium automation from test case  
Generate automation from UI steps  
Generate API tests from Swagger  
Generate regression suite  
Generate test data  
Analyze flaky test  

---

# Workflow Routing

When the user request matches a specific task, select the appropriate workflow.

### Generate test cases

Use workflow:

generate_test_cases

Triggers when user asks:

generate test cases  
write manual test cases  
test scenarios from requirement  

---

### Generate automation from manual test case

Use workflow:

generate_automation_from_testcase

Triggers when user asks:

convert test case to automation  
generate Selenium automation  

---

### Generate automation from UI steps

Use workflow:

generate_ui_flow_automation

Triggers when user asks:

automate this UI flow  
generate automation from steps  
run UI steps and generate Selenium script  

---

### Generate API tests

Use workflow:

generate_api_tests_from_swagger

Triggers when user provides:

Swagger URL  
OpenAPI specification  

---

### Generate test data

Use workflow:

generate_test_data

Triggers when user asks:

generate test data  
generate boundary test data  

---

### Generate regression suite

Use workflow:

generate_regression_suite

Triggers when user asks:

create regression test suite  
generate regression scenarios  

---

### Generate automation framework

Use workflow:

generate_automation_framework

Triggers when user asks:

create automation framework  
design Selenium framework  

---

### Explore application

Use workflow:

generate_application_test_plan

Triggers when user asks:

explore application  
discover test scenarios  

---

### Analyze flaky tests

Use workflow:

analyze_flaky_tests

Triggers when user asks:

why is this test flaky  
analyze unstable automation  

---

### Generate full automation suite

Use workflow:

generate_full_automation_suite

Triggers when user asks:

generate full automation suite  
bootstrap automation for project  

---

# Automation Framework

Default automation stack:

Language: Java

UI automation: Selenium WebDriver

Test framework: TestNG

API automation: REST Assured

Mobile automation: Appium

Design pattern: Page Object Model

---

# Locator Strategy

## Locator Strategy (Selenium)

Prefer stable locators.

Priority:

1. id  
2. data-testid  
3. name  
4. css selector  
5. xpath  

Avoid fragile locators.

## Locator Strategy (Playwright)

When generating Playwright automation code, prefer built-in semantic locators.

Priority order:

1. get_by_role()
2. get_by_label()
3. get_by_placeholder()
4. get_by_text()
5. get_by_test_id()
6. css selector
7. xpath (last option)

Avoid fragile selectors such as dynamic class names.

---

# References

The agent may consult additional documentation in:

references/

PROJECT_CONTEXT.md  
TEST_STRATEGY.md  
REPOSITORY_MAP.md  
SELF_CHECK.md  
PROMPT_TEMPLATES.md  

These files provide context about:

project domain  
test strategy  
automation framework  
test generation guidelines  

---

# Output

Depending on the request, the agent may return:

Manual test cases  
Automation scripts  
API tests  
Locator recommendations  
Test data  
Automation framework design  

Automation outputs should include:

Page Object classes  
Test classes  
Assertions validating expected behavior