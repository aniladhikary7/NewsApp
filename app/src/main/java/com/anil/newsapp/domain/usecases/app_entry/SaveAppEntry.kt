package com.anil.newsapp.domain.usecases.app_entry

import com.anil.newsapp.domain.manager.LocalUserManger

class SaveAppEntry(
    private val localUserManger: LocalUserManger
) {

    suspend operator fun invoke(){
        localUserManger.saveAppEntry()
    }

}