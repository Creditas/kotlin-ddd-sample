package kotlinddd.web.models.request

import lombok.NoArgsConstructor

@NoArgsConstructor
class CreateOrderRequest {
    var customerId: String = ""
}