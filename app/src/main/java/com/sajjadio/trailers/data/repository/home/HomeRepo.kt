package com.sajjadio.trailers.data.repository.home


import com.sajjadio.trailers.data.network.ApiService
import com.sajjadio.trailers.utils.SafeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class HomeRepoImpl @Inject constructor(
    private val api: ApiService,
) : HomeRepository, SafeApiCall {

    override suspend fun getTrendMovie() = safeApiCall { api.getTrending() }.flowOn(Dispatchers.IO)

    override suspend fun getMoviePopular() = safeApiCall{api.getPopularMovie()}.flowOn(Dispatchers.IO)

    override suspend fun getMovieTopRated() = safeApiCall{api.getTopRatedMovie()}.flowOn(Dispatchers.IO)

    override suspend fun getUpComingMovie() = safeApiCall{api.getUpComingMovie()}.flowOn(Dispatchers.IO)


}