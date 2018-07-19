package kotlinddd.web.models

import lombok.NoArgsConstructor

@NoArgsConstructor
class AddProductRequest {
    var productId: String = ""
    var quantity: Int = 0
}