package kotlinddd.domain.order

interface PaymentService {
    fun debitValueByCreditCart(number: String) : Boolean
}