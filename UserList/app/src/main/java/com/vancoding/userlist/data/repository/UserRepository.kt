package com.vancoding.userlist.data.repository

import com.vancoding.userlist.data.remote.api.UserApi
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserApi,
) {
}