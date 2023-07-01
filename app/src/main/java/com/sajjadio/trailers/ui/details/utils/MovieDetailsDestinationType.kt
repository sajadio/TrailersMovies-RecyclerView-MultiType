package com.sajjadio.trailers.ui.details.utils

sealed class MovieDetailsDestinationType {
    data class PersonItem(val personId: Int) : MovieDetailsDestinationType()
    object Persons : MovieDetailsDestinationType()
    object GalleryItem : MovieDetailsDestinationType()
    object Galleries : MovieDetailsDestinationType()
    object Similar : MovieDetailsDestinationType()
    class SimilarItem(val movieId: Int) : MovieDetailsDestinationType()
}