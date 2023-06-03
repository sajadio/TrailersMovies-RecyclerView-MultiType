package com.sajjadio.trailers.ui.details.utils

sealed class DestinationType {
    object Actors : DestinationType()
    data class ActorItem(val id: Int) : DestinationType()
    object Similar : DestinationType()
    class SimilarItem(val id: Int) : DestinationType()
}