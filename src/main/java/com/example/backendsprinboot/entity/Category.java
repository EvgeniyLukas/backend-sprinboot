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
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@NoArgsConstructor
@Setter
@ToString
@Table(name = "category", schema = "tasklist")
public class Category {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "title")
  private String title;
  @Basic
  @Column(name = "completed_count")
  private Long completedCount;
  @Basic
  @Column(name = "uncompleted_count")
  private Long unCompletedCount;


  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public Long getCompletedCount() {
    return completedCount;
  }

  public Long getUnCompletedCount() {
    return unCompletedCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Category category = (Category) o;
    return id != null && Objects.equals(id, category.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}


