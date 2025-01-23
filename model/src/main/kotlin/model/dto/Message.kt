package model.dto

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val role: Role,
    val content: String,
) {

    @Serializable
    enum class Role(text: String) {
        SYSTEM("system"),
        ASSISTANT("assistant"),
        USER("user"),
    }
}