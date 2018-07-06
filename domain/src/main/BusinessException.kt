package kotlinddd.domain

data class BusinessException(override var message: String): Exception(message)