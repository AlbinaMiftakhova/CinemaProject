package com.mythesisapp.cinemaproject.domain.media

import android.net.Uri
import com.mythesisapp.cinemaproject.domain.interactor.UseCase
import com.mythesisapp.cinemaproject.domain.type.None
import javax.inject.Inject

class CreateImageFile @Inject constructor(
    private val mediaRepository: MediaRepository
) : UseCase<Uri, None>() {

    override suspend fun run(params: None) = mediaRepository.createImageFile()
}