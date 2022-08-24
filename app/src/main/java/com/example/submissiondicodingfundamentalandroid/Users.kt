package com.example.submissiondicodingfundamentalandroid

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Users(
    var avatar: Int,
    var username: String,
    var name: String,
    var location: String,
    var company: String,
    var followers: String,
    var following: String,
    var repository: String


): Parcelable


