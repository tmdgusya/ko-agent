import model.ModelName
import model.OpenAI

suspend fun main() {
    val model = OpenAI("")
    model.call("hello, world", ModelName.GPT_4)
}