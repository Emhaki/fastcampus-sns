package com.fastcampus.sns.repository;

import com.fastcampus.sns.model.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// postEntity를 생성하여 JpaRepository 안에 입력
@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity, Integer> {
}
