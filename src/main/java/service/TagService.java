package service;

import entity.Tag;
import repository.TagRepository;

import java.util.List;

public class TagService  {
    TagRepository tagRepository;
    public List<Tag> viewAllTags(){
    List<Tag> tags = tagRepository.findAllTags() ;
        return tags;
    }

}
