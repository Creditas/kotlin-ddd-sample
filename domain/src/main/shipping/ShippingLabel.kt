package kotlinddd.domain.shipping

import java.util.Date

data class ShippingLabel(val number: String, val estimatedArrival: Date)