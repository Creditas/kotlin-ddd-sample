package kotlinddd.domain.order

import javax.money.MonetaryAmount

data class Product(val description: String, val value: MonetaryAmount)

