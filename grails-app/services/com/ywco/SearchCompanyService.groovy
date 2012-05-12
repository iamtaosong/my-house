package com.ywco

class SearchCompanyService {

    def httpService


    def searchCompany() {

        def url = 'http://xmlgw.companieshouse.gov.uk/v1-0/xmlgw/Gateway'
        def xml =  generateCHSearchXML()
        log.error xml
        def xmlResponse =  postXML(url, xml)

    }

    def searchCompanyFromReturnXML(xmlContent){
//        def modelSpecData = xmlSlurper.parse(new URL(dataLocationPath, modelSpecDetailFilenamePrefix + modelId + modelSpecDetailFilenameSuffix).newInputStream())
//
//        modelSpecData.Body.NameSearch.each{coSearchItem ->
//
//            coSearchItem.CompanyName.children().each{offerData ->
//
//                def offer = buildModelOffer(offerData)
//
//                if(offer instanceof FinanceOffer){
//
//                    model.addToOffers(offer)
//                } else {
//
//                    model.addToSpecialOffers(offer)
//                }
//            }
//
//        }
//
//        def companiesNamesData = new XmlSlurper().parseText(xmlContent)
//        companiesNamesData
    }

    def postXML(urlString, xmlContent){
        try
        {
            URL url = new URL( urlString );
            URLConnection con = url.openConnection();

            // specify that we will send output and accept input
            con.setDoInput(true);
            con.setDoOutput(true);

            con.setConnectTimeout( 20000 );  // long timeout, but not infinite
            con.setReadTimeout( 20000 );

            con.setUseCaches (false);
            con.setDefaultUseCaches (false);

            // tell the web server what we are sending
            con.setRequestProperty ( "Content-Type", "text/xml" );

            OutputStreamWriter writer = new OutputStreamWriter( con.getOutputStream() );
            writer.write( xmlContent );
            writer.flush();
            writer.close();

            // reading the response
            InputStreamReader reader = new InputStreamReader( con.getInputStream() );

            StringBuilder buf = new StringBuilder();
            char[] cbuf = new char[ 2048 ];
            int num;

            while ( -1 != (num=reader.read( cbuf )))
            {
                buf.append( cbuf, 0, num );
            }

            String result = buf.toString();

            return result

            //log.error "Response from server after POST " + result
        }
        catch( Throwable t )
        {

        }


    }
    private generateCHSearchXML(){


        def stringBuilder = new StringBuilder();
        stringBuilder.append('<GovTalkMessage xsi:schemaLocation="http://www.govtalk.gov.uk/CM/envelope http://xmlgw.companieshouse.gov.uk/v1-0/schema/Egov_ch-v2-0.xsd" xmlns="http://www.govtalk.gov.uk/CM/envelope" xmlns:dsig="http://www.w3.org/2000/09/xmldsig#" xmlns:gt="http://www.govtalk.gov.uk/schemas/govtalk/core" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" >')
        stringBuilder.append('<EnvelopeVersion>1.0</EnvelopeVersion>')
        stringBuilder.append('<Header>')
        stringBuilder.append('<MessageDetails>')
        stringBuilder.append('<Class>NameSearch</Class>')
        stringBuilder.append('<Qualifier>request</Qualifier>')
        stringBuilder.append(' <TransactionID>12345</TransactionID>')
        stringBuilder.append('</MessageDetails>')
        stringBuilder.append('<SenderDetails>')
        stringBuilder.append('<IDAuthentication>')
        stringBuilder.append('<SenderID>XMLGatewayTestUserID</SenderID>')
        stringBuilder.append('<Authentication>')
        stringBuilder.append('<Method>CHMD5</Method>')
        stringBuilder.append('<Value>007b30e5116ed5894c2c55b6ace01b64</Value>')
        stringBuilder.append('</Authentication>')
        stringBuilder.append('</IDAuthentication>')
        stringBuilder.append('</SenderDetails>')
        stringBuilder.append('</Header>')
        stringBuilder.append('<GovTalkDetails>')
        stringBuilder.append('<Keys/>')
        stringBuilder.append('</GovTalkDetails>')
        stringBuilder.append('<Body>')
        stringBuilder.append('<NameSearchRequest xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:noNamespaceSchemaLocation="http://xmlgw.companieshouse.gov.uk/v1-0/schema/NameSearch.xsd">')
        stringBuilder.append('<CompanyName>')
        stringBuilder.append('i love u hahah ltd')
        stringBuilder.append('</CompanyName>')
        stringBuilder.append('<DataSet>LIVE</DataSet>')
        stringBuilder.append('<SearchRows>100</SearchRows>')
        stringBuilder.append('</NameSearchRequest>')
        stringBuilder.append('</Body>')
        stringBuilder.append('</GovTalkMessage>')
        stringBuilder.toString()
    }
}
