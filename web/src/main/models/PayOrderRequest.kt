package kotlinddd.web.models

import java.util.Date

class PayOrderRequest {
    var cardName: String = ""
    var cardNumber: String = ""
    var expirationDate: Date? = null
    var verificationCode: String = ""
}