import model.openai.ModelName
import model.openai.OpenAI

suspend fun main() {
    val model = OpenAI("")
    model.call("hello, world", ModelName.GPT_4)
}