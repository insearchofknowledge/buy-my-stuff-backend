package com.funtastic4.buymystuff.repository;


import com.funtastic4.buymystuff.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Optional<Producer> findProducerByName(String name);

}
