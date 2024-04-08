// run using node automationMain.js
const { Builder, Browser, By, Key, until } = require('selenium-webdriver');

async function uploadPhotos() {
    let driver = await new Builder().forBrowser(Browser.CHROME).build()
    try {
      await driver.get('www.midjourney.com/imagine')
      await driver.findElement(By.name('q')).sendKeys('webdriver', Key.RETURN)
      await driver.wait(until.titleIs('webdriver - Google Search'), 1000)
    } finally {
      await driver.quit()
    }
  }

uploadPhotos();


console.log("Testing...");


/*
    let title = awat driver.getTitle();
  // Finding
    let textBox = await driver.findElement(By.name('my-text'));
    let submitButton = await driver.findElement(By.css('button'));

  // Action
    await textBox.sendKeys('Selenium');
    await submitButton.click();

  // Request element information
    let value = await message.getText();

  // End Session
    await driver.quit();

    run with: node automationMain.js
    Debug with: go to Debug tab and click JavaScript Debug Terminal.
*/
