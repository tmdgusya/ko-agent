package model

import Model
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import kotlinx.serialization.json.Json
import model.dto.Message
import model.dto.TextGenerationRequest

class OpenAI(
    private val apiKey: String,
) : Model {
    override suspend fun call(message: String, modelName: ModelName) {
        return Fuel
            .post(OPEN_AI_URL)
            .header("Content-Type", "application/json")
            .header("Authorization", apiKey)
            .body(Json.encodeToString(TextGenerationRequest(
                model = ModelName.GPT_4.detail,
                messages = listOf(
                    Message(
                        role = Message.Role.USER,
                        content = message,
                    )
                )
            )))
            .awaitStringResponseResult()
            .third
            .fold(
                { data -> println(data) },
                { error -> println("Error: ${error.message}") }
            )
    }

    companion object {
        const val OPEN_AI_URL = "https://api.openai.com/v1/chat/completions"
    }
}