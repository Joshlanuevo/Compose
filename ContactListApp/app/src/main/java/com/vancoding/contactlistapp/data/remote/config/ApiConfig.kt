package com.vancoding.contactlistapp.data.remote.config

import com.vancoding.contactlistapp.BuildConfig

object ApiConfig {
    const val BASE_URL = BuildConfig.BASE_URL
    const val TIMEOUT_SECONDS = 30L

    object Endpoints {
        const val USERS = "api/users?=2"
    }
}