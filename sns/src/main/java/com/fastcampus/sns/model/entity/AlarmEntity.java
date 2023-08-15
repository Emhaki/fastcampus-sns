package com.fastcampus.sns.model.entity;

import com.fastcampus.sns.model.AlarmArgs;
import com.fastcampus.sns.model.AlarmType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"alarm\"")
@Getter
@Setter
@SQLDelete(sql = "UPDATE \"alarm\" SET deleted_at = NOW() where id=?")
@Where(clause = "deleted_at is NULL")
public class AlarmEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    // 알람을 받은 사람
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Enumerated(EnumType.STRING)
    private AlarmType alarmType;

    @Type(type = "jsonb")
    @Column(columnDefinition = "json")
    private AlarmArgs args;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private PostEntity post;

    @Column(name = "registered_at")
    private Timestamp registeredAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @Column(name = "deleted_at")
    private Timestamp deletedAt;

    @PrePersist
    void registeredAt() {
        this.registeredAt = Timestamp.from(Instant.now());
    }
    @PreUpdate
    void updatedAt() {
        this.updatedAt = Timestamp.from(Instant.now());
    }

    public static AlarmEntity of(UserEntity userEntity, PostEntity postEntity) {
        AlarmEntity entity = new AlarmEntity();
        entity.setUser(userEntity);
        entity.setPost(postEntity);
        return entity;

    }
}
