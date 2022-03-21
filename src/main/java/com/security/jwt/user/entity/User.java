package com.security.jwt.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Table(name = "user")
@NoArgsConstructor
@Entity
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email", unique = true)
  private String email;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Builder
  public User(String email, String username, String password) {
    this.email = email;
    this.username = username;
    this.password = password;
  }

  public void setPassword(String encodedPassword) {
    this.password = encodedPassword;
  }
}
