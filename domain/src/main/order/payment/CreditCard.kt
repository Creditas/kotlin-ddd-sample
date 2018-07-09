package kotlinddd.domain.order.payment

import java.util.Date

data class CreditCard(val fullName: String, val cardNumber: String, val expirationDate: Date, val verificationCode: String)