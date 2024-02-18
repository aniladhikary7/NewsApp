package com.anil.newsapp.domain.usecases.app_entry

import com.anil.newsapp.domain.manager.LocalUserManger
import kotlinx.coroutines.flow.Flow

class ReadAppEntry(
    private val localUserManger: LocalUserManger
) {

    operator fun invoke(): Flow<Boolean> {
        return localUserManger.readAppEntry()
    }

}