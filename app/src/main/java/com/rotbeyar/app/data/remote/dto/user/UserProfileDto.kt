package com.rotbeyar.app.data.remote.dto.user

import com.google.gson.annotations.SerializedName

data class UserProfileDto(


    @SerializedName("id")
                             val id: Long,

    @SerializedName("first_name")
                             val firstName: String,

    @SerializedName("last_name")
                             val lastName: String,

    @SerializedName("phone")
                             val phone: String,

    @SerializedName("email")
                             val email: String?,

    @SerializedName("role")
                             val role: String,  // "STUDENT", "PARENT", ...

    @SerializedName("permissions")
                             val permissions: List<String>,  // ["VIEW_BASIC_COURSES", "TAKE_QUIZ", ...]

    @SerializedName("subscription")
                             val subscription: SubscriptionDto?,

    @SerializedName("features")
                             val features: List<String>?,  // ["DOWNLOAD", "HD_QUALITY", ...]

    @SerializedName("related_students")
                             val relatedStudents: List<Long>?,  //for PARENT

    @SerializedName("assigned_students")
                             val assignedStudents: List<Long>?  // for PSYCHOLOGIST/CONSULTANT)



)