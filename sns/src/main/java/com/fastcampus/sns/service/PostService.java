package com.fastcampus.sns.service;

import com.fastcampus.sns.exception.ErrorCode;
import com.fastcampus.sns.exception.SimpleSnsApplicationException;
import com.fastcampus.sns.model.Post;
import com.fastcampus.sns.model.entity.PostEntity;
import com.fastcampus.sns.model.entity.UserEntity;
import com.fastcampus.sns.repository.PostEntityRepository;
import com.fastcampus.sns.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostEntityRepository postEntityRepository;
    private final UserEntityRepository userEntityRepository;

    @Transactional
    public void create(String title, String body, String userName) {
        // user find
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));

        // post save
        PostEntity saved = postEntityRepository.save(PostEntity.of(title, body, userEntity));
        // return

    }
    @Transactional
    public Post modify(String title, String body, String userName, int postId) {
        UserEntity userEntity = userEntityRepository.findByUserName(userName).orElseThrow(() ->
                new SimpleSnsApplicationException(ErrorCode.USER_NOT_FOUND, String.format("%s not founded", userName)));
        // post exist
        PostEntity postEntity = postEntityRepository.findById(postId).orElseThrow(()->
                new SimpleSnsApplicationException(ErrorCode.POST_NOT_FOUND, String.format("%s not founded", postId)));
        // post permission
        if (postEntity.getUser() != userEntity) {
            throw new SimpleSnsApplicationException(ErrorCode.INVALID_PERMISSION, String.format("%s has no permission with %s", userName, postId));
        }

        postEntity.setTitle(title);
        postEntity.setBody(body);

        return Post.fromEntity(postEntityRepository.saveAndFlush(postEntity));
    }
}
