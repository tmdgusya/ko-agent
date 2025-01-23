package model.openai.dto

import kotlinx.serialization.Serializable

@Serializable
data class TextGenerationRequest(
    val model: String,
    val messages: List<Message>,
)
