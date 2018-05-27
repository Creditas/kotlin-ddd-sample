package org.dddsample.application.order.commands

import org.dddsample.domain.order.User

data class CreateOrderCommand(val user: User)