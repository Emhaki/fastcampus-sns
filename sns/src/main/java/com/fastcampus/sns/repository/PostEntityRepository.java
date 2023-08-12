package com.fastcampus.sns.repository;

import com.fastcampus.sns.model.Post;
import com.fastcampus.sns.model.entity.PostEntity;
import com.fastcampus.sns.model.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// postEntity를 생성하여 JpaRepository 안에 입력
@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Integer> {

    // 페이징 처리
    Page<PostEntity> findAllByUser(UserEntity entity, Pageable pageable);
}
