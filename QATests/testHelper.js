const expect = require("chai").expect;
const special_var = 'special.var_identifier';
const unique_search_fieldset = '${special_var} > div > span';

module.exports = {

    get SubmitButton () {
        return $('button[type="submit"]')
    },
    
    get MenuButton () {
        return $("button[data-testid='menu-button']")
    },

    get SpecialButton () {
        return $("form[id*='special-form'] *> input[type='checkbox']:not([role='changed'])")
    },

    get Inputs () {
        return {
            get InputOne () {
                return $("button[data-testid='menu-button']")
            }
        };
    },


    async ensureFeatureIsOff () {
        for (let i = 0; i < 5 && (await (await this.Input).isExisting()); i++) {
            await (await this.Toggle).click();
            await browser.pause(5000);
        }
    },

    get TestData () {
        return {
            get FirstName () {
                return "Bobby"
            },
            get LastName () {
                return "De La Paz"
            }
        }
    }
}