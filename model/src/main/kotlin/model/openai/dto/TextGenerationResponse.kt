package model.openai.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonNames

/**
 * {
 *   "id": "chatcmpl-123",
 *   "object": "chat.completion",
 *   "created": 1677652288,
 *   "model": "gpt-4o-mini",
 *   "system_fingerprint": "fp_44709d6fcb",
 *   "choices": [{
 *     "index": 0,
 *     "message": {
 *       "role": "assistant",
 *       "content": "\n\nHello there, how may I assist you today?",
 *     },
 *     "logprobs": null,
 *     "finish_reason": "stop"
 *   }],
 *   "service_tier": "default",
 *   "usage": {
 *     "prompt_tokens": 9,
 *     "completion_tokens": 12,
 *     "total_tokens": 21,
 *     "completion_tokens_details": {
 *       "reasoning_tokens": 0,
 *       "accepted_prediction_tokens": 0,
 *       "rejected_prediction_tokens": 0
 *     }
 *   }
 * }
 *
 */
@Serializable
data class TextGenerationResponse(
    val id: String,
    val `object`: String,
    val created: Long,
    val model: String,
    @SerialName("system_fingerprint")
    val systemFingerprint: String,
    val choices: List<Choice>,
    @SerialName("service_tier")
    val serviceTier: String,
    val usage: Usage,
) {
    @Serializable
    data class Choice(
        val index: Int,
        val message: Message,
        val logprobs: String?,
        @SerialName("finish_reason")
        val finishReason: String,
    )

    @Serializable
    data class Usage(
        @SerialName("prompt_tokens")
        val promptTokens: Int,
        @SerialName("completion_tokens")
        val completionTokens: Int,
        @SerialName("total_tokens")
        val totalTokens: Int,
        @SerialName("prompt_tokens_details")
        val promptTokensDetails: PromptTokensDetails,
        @SerialName("completion_tokens_details")
        val completionTokensDetails: CompletionTokensDetails,
    ) {
        @Serializable
        data class PromptTokensDetails(
            @SerialName("cached_tokens")
            val cachedTokens: Int,
            @SerialName("audio_tokens")
            val audioTokens: Int,
        )

        @Serializable
        data class CompletionTokensDetails(
            @SerialName("reasoning_tokens")
            val reasoningTokens: Int,
            @SerialName("audio_tokens")
            val audioTokens: Int,
            @SerialName("accepted_prediction_tokens")
            val acceptedPredictionTokens: Int,
            @SerialName("rejected_prediction_tokens")
            val rejectedPredictionTokens: Int,
        )
    }
}
