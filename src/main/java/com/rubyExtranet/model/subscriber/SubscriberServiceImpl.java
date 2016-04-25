package com.rubyExtranet.model.subscriber;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rubyExtranet.repository.SubscriberRepository;
import com.rubyExtranet.service.subscriber.SubscriberService;

@Service
public class SubscriberServiceImpl implements SubscriberService{
	
	private final SubscriberRepository subscriberRepository;
	
	@Autowired
    public SubscriberServiceImpl(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

	@Override
	public Optional<Subscriber> getSubscriberById(long id) {
		return Optional.ofNullable(subscriberRepository.findOne(id));
	}

	@Override
	public Optional<Subscriber> getSubscriberByEmail(String email) {
		return subscriberRepository.findOneByEmail(email);
	}

	@Override
	public Collection<Subscriber> getAllSubscribers() {
		return subscriberRepository.findAll(new Sort("email"));
	}

	@Override
	public Subscriber create(SubscriberCreateForm form) {
		Subscriber subscriber = new Subscriber();
		
		subscriber.setEmail(form.getEmail());
		subscriber.setNewsletterFrequency(form.getNewsletterFrequency());
		
		return subscriberRepository.save(subscriber);
	}

	@Override
	public Subscriber findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
