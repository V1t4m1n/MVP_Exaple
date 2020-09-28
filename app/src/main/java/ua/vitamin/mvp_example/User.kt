package ua.vitamin.mvp_example

import com.google.gson.annotations.SerializedName

data class User (@SerializedName("fist") var fistName: String,
                 @SerializedName("last") var lastName: String,
                 @SerializedName("medium") var avatar: String)