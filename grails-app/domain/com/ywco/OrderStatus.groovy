package com.ywco

class OrderStatus {

    String statusKey
    String statusWebName

    static hasMany = [orders:Order]

    static constraints = {

    }
}
