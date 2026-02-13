package com.web.blog.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name ="article")
public class Article {

  @Id
  @GeneratedValue(strategy= GenerationType.IDENTITY)
  @Column(name="id", updatable = false)
  private Long id;

  @Column(name="title", nullable=false)
  private String title;

  @Column(name="content", nullable=false)
  private String content;

  @CreatedDate  //엔티티 생성시 시간 저장
  @Column(name="created_at")
  private LocalDateTime createAt;

  @LastModifiedDate
  @Column(name="updated_at")
  private LocalDateTime updateAt;

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }

}
