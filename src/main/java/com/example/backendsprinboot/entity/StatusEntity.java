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
@Setter
@NoArgsConstructor
@ToString
@Table(name = "stat", schema = "tasklist")
public class StatusEntity {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  @Column(name = "id")
  private Long id;
  @Basic
  @Column(name = "completed_total")
  private Long completedTotal;
  @Basic
  @Column(name = "uncompleted_total")
  private Long unCompletedTotal;

  public Long getId() {
    return id;
  }

  public Long getCompletedTotal() {
    return completedTotal;
  }

  public Long getUnCompletedTotal() {
    return unCompletedTotal;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    StatusEntity stat = (StatusEntity) o;
    return id != null && Objects.equals(id, stat.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}



