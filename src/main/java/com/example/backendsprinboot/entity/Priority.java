package com.example.backendsprinboot.entity;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

@Entity
@Setter
@NoArgsConstructor
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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Priority priority = (Priority) o;
    return id != null && Objects.equals(id, priority.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
