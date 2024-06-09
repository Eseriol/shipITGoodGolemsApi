
package ship.it.goodgolems.redis.service;


import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ship.it.goodgolems.domain.Employee;
import ship.it.goodgolems.domain.ai.VectorStoreDocument;
import ship.it.goodgolems.spi.vectordb.VectorStoregeService;

/**
 * RedisStorage is a class that implements the VectorStoregeService interface.
 * It provides methods to store, delete, and search for documents in a vector store using Redis.
 */
@Service
@RequiredArgsConstructor
public class RedisStorage implements VectorStoregeService {

    private final VectorStore vectorStore;

    /**
     * Stores the list of employees in a vector store and returns a list of VectorStoreDocuments
     * representing the stored documents.
     *
     * @param employees The list of employees to be stored.
     * @return A list of VectorStoreDocuments representing the stored documents.
     */
    @Override
    public List<VectorStoreDocument> store(Collection<Employee> employees) {
        var documents = employees.stream().map(DocumentCreator::createDocument).toList();
        vectorStore.add(documents);
        return documents.stream()
                .map(e -> new VectorStoreDocument(e.getId(), (String) e.getMetadata().get("fullName")))
                .toList();
    }

    /**
     * Deletes the documents with the given IDs from the vector store.
     *
     * @param documentIds The list of document IDs to be deleted.
     * @return An Optional<Boolean> object indicating whether the delete operation was successful.
     */
    @Override
    public Optional<Boolean> delete(List<String> documentIds) {
        return vectorStore.delete(documentIds);
    }

    /**
     * Retrieves a list of documents similar to the given query from the vector store.
     *
     * @param query The query to search for similarities.
     * @return A list of strings representing the content of the similar documents.
     */
    @Override
    public List<String> simpleVector(String query) {
        List<Document> documents = List.of(
                new Document("Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!! Spring AI rocks!!", Map.of("meta1", "meta1")),
                new Document("The World is Big and Salvation Lurks Around the Corner"),
                new Document("The World is Big"),
                new Document("You walk forward facing the past and you turn back toward the future.", Map.of("meta2", "meta2")));

        //add documents to the vector store
        vectorStore.add(documents);

        // retrieve documents similar to the given query
        List<Document> results = vectorStore.similaritySearch(
                SearchRequest.defaults()
                        .withQuery(query)
                        .withTopK(2)
        );
        return results.stream().map(Document::getContent).toList();
    }
}

