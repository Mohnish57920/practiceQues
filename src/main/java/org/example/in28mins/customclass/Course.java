package org.example.in28mins.customclass;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Course {
    private String name;
    private String category;
    private Integer reviewScore;
    private Integer NoOfStudents;
}
