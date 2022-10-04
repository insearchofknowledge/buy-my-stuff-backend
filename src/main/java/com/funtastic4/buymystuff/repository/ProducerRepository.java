package com.funtastic4.buymystuff.repository;


import com.funtastic4.buymystuff.model.Producer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProducerRepository extends JpaRepository<Producer, Long> {

    Optional<Producer> findProducerByName(String name);

}
