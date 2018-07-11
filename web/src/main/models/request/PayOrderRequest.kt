package kotlinddd.web.models.request

import java.util.Date

class PayOrderRequest {
    var cardName: String = ""
    var cardNumber: String = ""
    var expirationDate: Date? = null
    var verificationCode: String = ""
}