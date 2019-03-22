package kotlinddd.web.models

import java.util.*

class PayOrderRequest(
    val cardName :String = "",
    val cardNumber :String = "",
    val expirationDate : Date? = null,
    val verificationCode :String = ""
)