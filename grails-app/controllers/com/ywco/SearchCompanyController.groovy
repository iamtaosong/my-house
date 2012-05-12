package com.ywco

class SearchCompanyController {

    def searchCompanyService

    def index() {
        log.error " search result " + searchCompanyService.searchCompany()
    }
}
