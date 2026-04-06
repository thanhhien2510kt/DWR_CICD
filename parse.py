from bs4 import BeautifulSoup

with open('deposit_form.html', 'r', encoding='utf-8') as f:
    soup = BeautifulSoup(f, 'html.parser')

with open('parsed_locators.txt', 'w', encoding='utf-8') as f:
    for label in soup.find_all('label'):
        text = label.get_text(strip=True)
        target_id = label.get('for')
        if not target_id:
            input_elem = label.find_next(['input', 'select', 'textarea'])
            if input_elem:
                target_id = input_elem.get('id') or input_elem.get('name')
        f.write(f"Label: {text} -> Element ID/Name: {target_id}\n")
    
    # Also find buttons
    for btn in soup.find_all('button'):
        f.write(f"Button: {btn.get_text(strip=True)} -> ID: {btn.get('id')} Class: {btn.get('class')}\n")
