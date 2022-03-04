package com.MessageNetworkexample.MessageNetworkdemo.response;

import com.MessageNetworkexample.MessageNetworkdemo.model.Like;
import com.MessageNetworkexample.MessageNetworkdemo.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class PostResponse {

    private Long id;
    private Long userId;
    private String userName;
    private String title;
    private String text;
    private List<Like>postLikes;

    public PostResponse(Post entity){
        this.id=entity.getId();
        this.userId=entity.getUser().getId();
        this.userName=entity.getUser().getUserName();
        this.title=entity.getTitle();
        this.text=entity.getText();
    }


}
