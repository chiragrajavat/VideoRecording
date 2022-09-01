package com.ps.videorecordingdemo.repository

import com.google.gson.JsonObject
import com.ps.videorecordingdemo.retrofit.ApiService
import org.json.JSONObject
import retrofit2.Response

class MainRepository constructor(private val retrofitService: ApiService) {
    suspend fun postRecordedFile(base_64:String): Response<JsonObject> {
        return retrofitService.uploadVideo(base_64)
    }
}