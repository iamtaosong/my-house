package com.ywco

class Company {

    String companyName, premise, street, thoroughfare, county,town,postcode, country

    Date dateCreated
    Date lastUpdated

    static belongsTo = [ order:Order]

    static mapping = {

    }

    static constraints = {

    }
}
