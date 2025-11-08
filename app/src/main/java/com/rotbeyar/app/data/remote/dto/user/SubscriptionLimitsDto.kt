package com.rotbeyar.app.data.remote.dto.user

import com.google.gson.annotations.SerializedName

data class SubscriptionLimitsDto(


    @SerializedName("max_downloads")
                                val maxDownloads: Int?,

                                @SerializedName("max_courses")
                                val maxCourses: Int?,

                                @SerializedName("max_devices")
                                val maxDevices: Int,

                                @SerializedName("video_quality")
                                val videoQuality: String,  // "SD", "HD", "FULL_HD"

                                @SerializedName("current_downloads")
                                val currentDownloads: Int,

                                @SerializedName("current_courses")
                                val currentCourses: Int)