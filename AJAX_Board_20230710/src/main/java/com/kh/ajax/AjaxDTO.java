package com.kh.ajax;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class AjaxDTO {
  private int idx;
  private String name;
  private int age;
  private String gender;
  private String email;
}
