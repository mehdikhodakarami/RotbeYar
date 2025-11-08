package com.rotbeyar.app.domain.model.response

import com.rotbeyar.app.data.remote.Result

data class UpdateProfileResponse(
     val success: Boolean ,
    val error : Boolean = false ,
    val message : String


)