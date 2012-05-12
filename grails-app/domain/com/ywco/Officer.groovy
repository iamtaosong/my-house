package com.ywco

class Officer {

    //nationality_country_id, occupation, country_id,           //resident_country_id,      //String service_country_id,
    String title
    String forename
    String surname
    String middlename
    String dob
    String occupation
    String servicePremise
    String service_street
    String serviceThoroughfare
    String servicePostTown
    String serviceCounty
    String servicePostcode
    String residenPremise
    String residentStreet
    String residentThoroughfare
    String residentPostTown
    String residentCounty
    String residentPostcode
    String birthTown
    String lastThreeTel
    String eye

    static constraints = {
        title (blank:false,maxSize:255)
        forename (blank:false,maxSize:255)
        surname (blank:false,maxSize:255)
        dob (blank:false,maxSize:255)
        occupation (blank:false,maxSize:255)
        servicePremise (blank:false,maxSize:255)
        service_street (blank:false,maxSize:255)
        servicePostTown (blank:false,maxSize:255)
        serviceCounty (blank:false,maxSize:255)
        servicePostcode (blank:false,maxSize:255)
        residenPremise (blank:false,maxSize:255)
        residentStreet (blank:false,maxSize:255)
        residentPostTown (blank:false,maxSize:255)
        residentCounty (blank:false,maxSize:255)
        residentPostcode (blank:false,maxSize:255)
        birthTown  (blank:false,maxSize:255)
        lastThreeTel  (blank:false,maxSize:255)
        eye (blank:false,maxSize:255)

        serviceCounty ( nullable: true )
        residentCounty ( nullable: true )
        middlename ( nullable: true )
        serviceThoroughfare ( nullable: true )
        residentThoroughfare ( nullable: true )
    }
}
