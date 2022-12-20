package com.shoppi.app.repository

import com.shoppi.app.model.Category
import com.shoppi.app.network.ApiClinet

class CategoryRemoteDataSource(private val apiClinet: ApiClinet) : CategoryDataSource {
    override suspend fun getCategories(): List<Category> {
        return apiClinet.getCategories()
    }
}