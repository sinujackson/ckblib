package com.canehealth.ckblib.graph;

import com.canehealth.ckblib.graph.model.BaseRelation;

import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import reactor.core.publisher.Mono;

@Repository
public interface BaseRelationRepository extends ReactiveNeo4jRepository<BaseRelation, Long> {

    // Flux<BaseRelation> findAll();

    @Query("" + "MATCH (d {cui: $cui}) -[r]- (s) \n" + "RETURN r")
    Mono<BaseRelation> getRelationsByCui(String cui);

}