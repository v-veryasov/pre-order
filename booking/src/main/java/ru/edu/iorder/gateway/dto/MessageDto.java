package ru.edu.iorder.gateway.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    @JsonProperty("message")
    private String message;

    @JsonProperty("identifier")
    private int identifier;
}
