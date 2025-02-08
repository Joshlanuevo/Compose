package com.vancoding.contactlistapp.domain.repository

import com.vancoding.contactlistapp.domain.model.UserPage
import com.vancoding.contactlistapp.utils.NetworkResultState

interface UserRepository {
    suspend fun getContactList(page: Int): NetworkResultState<UserPage>
}