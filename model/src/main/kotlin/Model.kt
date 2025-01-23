import model.ModelName

/**
 *
 * This interface for model to call and
 *
 * @author roach<dev0jsh@gmail.com>
 */
interface Model {
    suspend fun call(message: String, modelName: ModelName)
}