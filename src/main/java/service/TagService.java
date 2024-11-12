package service;

import entity.Tag;
import repository.TagRepository;

import java.sql.SQLException;
import java.util.List;

public class TagService  {
    public void addNewTag(String title) throws SQLException {
tagRepository.save(title);
    }


    TagRepository tagRepository;
    public List<Tag> viewAllTags(){
    List<Tag> tags = tagRepository.findAllTags() ;
        return tags;
    }

}
