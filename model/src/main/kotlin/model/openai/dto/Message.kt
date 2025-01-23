package model.openai.dto

import kotlinx.serialization.Serializable

@Serializable
data class Message(
    val role: String,
    val content: String,
    val refusal: String? = null,
) {

    @Serializable
    enum class Role(val text: String) {
        SYSTEM("system"),
        ASSISTANT("assistant"),
        USER("user"),
    }
}