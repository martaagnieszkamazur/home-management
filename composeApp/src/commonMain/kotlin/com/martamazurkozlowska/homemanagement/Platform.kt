package com.martamazurkozlowska.homemanagement

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform