package ship.it.goodgolems.domain.ai;

/**
 * Represents a document in a vector store.
 *
 * @param id    The identifier of the document.
 * @param title The title or name of the document.
 */
public record VectorStoreDocument(
        String id,
        String title
) {
}
