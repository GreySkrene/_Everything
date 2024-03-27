const testHelper = require('../testHelper.js')
const pauseHelper = require('../pauseHelper.js')
const webPageComponentObject = require('../notherFileName/webPageComponentObject')
const { expect } = require('chai')


// Start the function
describe('First Test Name', function() {
    let FirstString = "let's Gooo!"
    let SecondString = "Common"
    let ThirdString = "Peppito de la France"

    instanceof('run automated test', async () => {
        testHelper.runFunction(this.title);
        await testHelper.login();
        // or await browser.url(process.testEnv.rootUrl+"/search/example");
        await browser.url(process.testEnv.rootUrl + "/home/simple/");
        await pauseHelper.pause();

        await (await webPageComponentObject.expandOptionsButton).waitForDisplayed(10000);
        await (await webPageComponentObject.expandOptionsButton).scrollIntoView({block: "center"});
        await (await webPageComponentObject.expandOptionsButton).click();

        await (await webPageComponentObject.nameInput).waitForDisplayed(10000);
        await (await webPageComponentObject.nameInput).setValue(FirstString);

        expect(await (await webPageComponentObject.FirstInputs.Specific.Exact).isDisplayed()).to.be.true;

        await browser.pause(2000);
        await browser.switchWindow("/home/simple/idea", false)

        expect(await browser.getUrl()).to.include("/home/simple/idea");

        expect(await (await webPageComponentObject.nameInput).getValue()).to.equal(FirstString);
        expect(await (await webPageComponentObject.webPageComponentObject.FirstInputs.Specific.Exact).isDisplayed()).to.be.true;

        await testHelper.checkForJSErrors();
    })
})