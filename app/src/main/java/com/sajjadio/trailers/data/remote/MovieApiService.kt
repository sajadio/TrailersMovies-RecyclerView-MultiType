package com.sajjadio.trailers.data.remote

import com.sajjadio.trailers.data.model.movie.common.Common
import com.sajjadio.trailers.data.model.movie.actors.ActorsDto
import com.sajjadio.trailers.data.model.genre.GenreDto
import com.sajjadio.trailers.data.model.movie.actorsmovie.ActorsMovie
import com.sajjadio.trailers.data.model.movie.genremovie.Movie
import com.sajjadio.trailers.data.model.movie.id.IDMovie
import com.sajjadio.trailers.data.model.movie.search.SearchMovie
import com.sajjadio.trailers.data.model.movie.similar.Similar
import com.sajjadio.trailers.data.model.movie.trend.TrendMovie
import com.sajjadio.trailers.data.model.movie.video.VideoMovie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("discover/movie")
    suspend fun getGenreList(
        @Query("with_genres") genreId: String?,
        @Query("page") page: Int,
    ): Movie

    @GET("trending/all/day?")
    suspend fun getTrending(
    ): Response<TrendMovie>

    @GET("movie/popular?")
    suspend fun getPopularMovie(
        @Query("page") page: Int = 1,
    ): Response<Common>


    @GET("movie/top_rated?")
    suspend fun getTopRatedMovie(
        @Query("page") page: Int = 1,
    ): Response<Common>

    @GET("movie/upcoming?")
    suspend fun getUpComingMovie(
        @Query("page") page: Int = 1,
    ): Response<Common>

    @GET("movie/{id}/videos?")
    suspend fun getMovieTrailer(
        @Path("id") id: Int?,
    ): Response<VideoMovie>

    @GET("movie/{id}?")
    suspend fun getMoviesDetails(
        @Path("id") page: Int?,
    ): Response<IDMovie>

    @GET("movie/{id}/credits?")
    suspend fun getActors(
        @Path("id") page: Int?,
    ): Response<ActorsDto>

    @GET("movie/{id}/similar?")
    suspend fun getSimilar(
        @Path("id") id: Int?,
        @Query("page") page: Int?,
    ): Response<Similar>


    @GET("genre/movie/list")
    suspend fun getGenresMovie(
    ): Response<GenreDto>

    @GET("search/movie?")
    suspend fun getSearchMovie(
        @Query("query") query: String?,
        @Query("page") page: Int,
    ): SearchMovie


    @GET("person/{person_id}/movie_credits?")
    suspend fun getMovieOfActor(
        @Path("person_id") person_id: Int?,
    ): Response<ActorsMovie>

}