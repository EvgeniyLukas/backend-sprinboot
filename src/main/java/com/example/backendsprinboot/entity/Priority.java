package com.example.backendsprinboot.entity;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Table(name = "priority", schema = "tasklist")
public class Priority {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "title")
  private String title;
  @Basic
  @Column(name = "color")
  private String color;

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getColor() {
    return color;
  }

}
