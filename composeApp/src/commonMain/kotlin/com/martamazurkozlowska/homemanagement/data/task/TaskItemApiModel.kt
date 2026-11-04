package com.martamazurkozlowska.homemanagement.data.task

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TaskItemApiModel(

    @SerialName("name")
    val name: String,

    @SerialName("time_period")
    val timePeriodInSeconds: Long,

    @SerialName("creation_date")
    val creationTimestampInSeconds: Long,

    @SerialName("color")
    val color: String,

    @SerialName("completed")
    val completed: Boolean,

    @SerialName("notes")
    val notes: String,
)