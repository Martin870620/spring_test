package com.example.demo.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TopicService {

	private List<Topic> topics = new ArrayList<>(Arrays.asList(
			new Topic("spring", "Spring Topic", "Spring Desciption"),
			new Topic("spring2", "Spring Topic2", "Spring Desciption2"),
			new Topic("spring3", "Spring Topic3", "Spring Desciption3")
		));
	
	public List<Topic> getAllTopics(){
		return topics;
	}
	
	public Topic getTopic(String id) {
		return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		topics.add(topic);	
	}
	
	public void updateTopic(String id, Topic topic) {
		for (int i=0;i < topics.size(); i++) {
			Topic t = topics.get(i);
			if(t.getId().equals(id)) {
				topics.set(i, topic);
				return;
			}
		}
	}
	
	public void deleteTopic(String id) {
		for (int i=0; i < topics.size();i++) {
			if(topics.get(i).getId().equals(id)) {
				topics.remove(i);
			}
		}
	}
	
}
