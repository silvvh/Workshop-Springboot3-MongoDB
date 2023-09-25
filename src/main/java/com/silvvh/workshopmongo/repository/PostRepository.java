package com.silvvh.workshopmongo.repository;

import com.silvvh.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
   // List<Post> findByTitleContainingIgnoreCase(String text);
    @Query("{ 'title':  { $regex: ?0, $options:  'i' } }")
    List<Post> findByTitle(String text);
}
