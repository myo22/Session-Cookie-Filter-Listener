package org.zerock.review2.domain;

import lombok.*;

import java.time.LocalDate;


@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoVO {

    private Long tno;

    private String title;

    private LocalDate dueDate;

    private boolean finished;
}
