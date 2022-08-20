package com.bchmsl.homework16.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bchmsl.homework16.model.ApiResponse
import com.bchmsl.homework16.network.ApiClient

class UsersPagingSource(
    private val api: ApiClient
) : PagingSource<Int, ApiResponse.User>() {
    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ApiResponse.User> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = api.getUsers(page)
            val data = response.body()!!.data
            Log.wtf("TAG", toString())
            LoadResult.Page(
                data = data,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (data.isEmpty()) null else page + 1
            )
        } catch (e: Throwable) {
            Log.wtf("TAG", e.message)
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ApiResponse.User>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }
    }
}