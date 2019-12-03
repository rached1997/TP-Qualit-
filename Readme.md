NB : 
Lors d'éffectuation d'un achat pour la 1ère fois, il est demandé à l'utilisateur de renseigner des informations relatives à son adersse, une fois ces informations on été enregistré, l'utilisateur n'est plus demandé à remplir ces champs lors d'un deuxième achat, dans ce cas, il suffit de commenter la partie de renseignement d'adresse dans le code du TP2 puisque cette étape n'est plus efféctuée.


		
		// Filling the adress inputs
		
		WebElement cin = driver.findElement(By.id("input_cin"));
		cin.sendKeys("12345678");
		
		WebElement adress = driver.findElement(By.id("address1"));
		adress.sendKeys("Adress rue Adress 123");

		WebElement postcode = driver.findElement(By.id("postcode"));
		postcode.sendKeys("2097");

		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("BelleVue");

		WebElement phone = driver.findElement(By.id("phone_mobile"));
		phone.sendKeys("20121008");

		WebElement submitAdress = driver.findElement(By.name("submitAddress"));
		submitAdress.click();

		TimeUnit.SECONDS.sleep(3); 

		// Confirming the adress
		WebElement processAdress = driver.findElement(By.name("processAddress"));
		executor.executeScript("arguments[0].click()", processAdress);

		TimeUnit.SECONDS.sleep(3);
