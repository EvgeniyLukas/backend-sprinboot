package com.example.backendsprinboot.search;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskSearchCriteria {

  String title;
  Integer completed;
  Long priorityId;
  Long categoryId;

  Integer pageNumber;
  Integer pageSize;

  String sortColumn;
  String sortDirection;

}
