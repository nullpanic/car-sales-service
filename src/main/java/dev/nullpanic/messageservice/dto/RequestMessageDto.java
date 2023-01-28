package dev.nullpanic.messageservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RequestMessageDto {
    private String text;
}
