package com.ps.videorecordingdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ps.videorecordingdemo.repository.MainRepository
import kotlinx.coroutines.*

class VideoViewerViewModelconstructor(private val mainRepository: MainRepository) : ViewModel(){
    var job: Job? = null
    val errorMessage = MutableLiveData<String>()

    fun uploadRecording(base64:String){
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = mainRepository.postRecordedFile(base64)
            withContext(Dispatchers.Main) {

            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

}