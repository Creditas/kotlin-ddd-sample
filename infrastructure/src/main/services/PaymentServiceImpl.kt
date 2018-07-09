package kotlinddd.infrastructure.services

import kotlinddd.domain.order.payment.CreditCard
import kotlinddd.domain.order.payment.PaymentService

class PaymentServiceImpl : PaymentService {
    override fun debitValueByCreditCard(creditCard: CreditCard): Boolean {
        return true
    }
}