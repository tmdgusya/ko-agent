package model.openai

import Model
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import kotlinx.serialization.json.Json
import model.openai.dto.Message
import model.openai.dto.TextGenerationRequest
import model.openai.dto.TextGenerationResponse

class OpenAI(
    private val apiKey: String,
) : Model {
    override suspend fun call(message: String, modelName: ModelName) {
        return Fuel
            .post(OPEN_AI_URL)
            .header("Content-Type", "application/json")
            .header("Authorization", "Bearer $apiKey")
            .body(Json.encodeToString(
                TextGenerationRequest(
                model = ModelName.GPT_4O.detail,
                messages = listOf(
                    Message(
                        role = Message.Role.USER.text,
                        content = message,
                    )
                )
            )
            ))
            .awaitStringResponseResult()
            .third
            .fold(
                { data -> println(Json.decodeFromString<TextGenerationResponse>(data).toString()) },
                { error -> println("Error: ${error}") }
            )
    }

    companion object {
        const val OPEN_AI_URL = "https://api.openai.com/v1/chat/completions"
    }
}