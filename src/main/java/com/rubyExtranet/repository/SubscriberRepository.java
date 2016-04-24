package com.rubyExtranet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rubyExtranet.model.subscriber.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Long>{
	Optional<Subscriber> findOneByEmail(String email);
}
