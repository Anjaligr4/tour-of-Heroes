url = "https://www.tascoappliance.ca/home/"
driver = webdriver.Chrome()  # Use the appropriate WebDriver for your browser
driver.get(url)


driver.find_element(By.LINK_TEXT, "Dishwasher").click()
driver.find_element(By.LINK_TEXT, "Front Control").click()


driver.find_element(By.ID, "SortBy").click()
driver.find_element(By.XPATH, "//option[text()='Price: Low to High']").click()

driver.find_element(By.XPATH, "//span[contains(text(), 'More colors available')]/ancestor::div[@class='product-details']").click()
driver.find_element(By.XPATH, "//span[text()='WHITE']").click()
driver.find_element(By.XPATH, "//button[text()='Add to Cart']").click()


driver.find_element(By.ID, "cart").click()


driver.find_element(By.ID, "billing:firstname").send_keys("John")
driver.find_element(By.ID, "billing:lastname").send_keys("Doe")

driver.find_element(By.XPATH, "//span[text()='Submit']").click()


error_message = driver.find_element(By.XPATH, "//span[text()='email field is required']").text
assert "email field is required" in error_message

driver.quit()
