package com.silvvh.workshopmongo.repository;

import com.silvvh.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
   // List<Post> findByTitleContainingIgnoreCase(String text);
    @Query("{ 'title':  { $regex: ?0, $options:  'i' } }")
    List<Post> findByTitle(String text);

    @Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte:  ?2} } , { $or: [ { 'body': { $regex:  ?0,  $options:  'i' } }, { 'title': { $regex:  ?0,  $options:  'i' } }, { 'comments.text': { $regex:  ?0,  $options:  'i' } } ] } ] }")
    List<Post> findAllWhere(String text, LocalDate minDate, LocalDate maxDate);
}
