package kotlinddd.infrastructure

import kotlinddd.domain.order.PaymentService

class PaymentServiceImpl : PaymentService {
    override fun debitValueByCreditCart(number: String): Boolean {
        return true
    }
}