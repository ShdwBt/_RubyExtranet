package com.rubyExtranet.service.subscriber;

import java.util.Collection;
import java.util.Optional;

import com.rubyExtranet.model.subscriber.Subscriber;
import com.rubyExtranet.model.subscriber.SubscriberCreateForm;

public interface SubscriberService {
		Optional<Subscriber> getSubscriberById(long id);

	    Optional<Subscriber> getSubscriberByEmail(String email);

	    Collection<Subscriber> getAllSubscribers();

	    Subscriber create(SubscriberCreateForm form);
	    
	    Subscriber findById(int id);
}
