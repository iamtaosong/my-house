package com.ywco

class Order {

    String companyName

    static belongsTo = [ orderStatus:OrderStatus]                     //siteUser:SiteUser,

    Date dateCreated
    Date lastUpdated

    static constraints = {

    }
}
