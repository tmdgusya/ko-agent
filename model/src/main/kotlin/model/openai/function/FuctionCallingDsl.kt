package model.openai.function

import model.openai.ModelName
import model.openai.dto.Message

fun makeFunctionCall(
    receipies: FunctionCallingDsl.() -> Unit
): FunctionCallingDsl = FunctionCallingDsl().apply(receipies)

class FunctionCallingDsl {
    var modelName: ModelName? = null
    var messages: List<Message>? = null
    var tools: List<Tool>? = null
}

class Tool {
    var type: String? = null // function
    var function: FunctionDsl? = null
}

class FunctionDsl {
    var name: String? = null
    var description: String? = null
    var parameters: List<ParameterDsl>? = null
}

class Parameter {
    var type: String? = null
    var properties: Map<String, String>? = null
}