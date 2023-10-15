package com.example.every_server.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MembershipDto {
    private List<String> title;
    private List<String> img;
    private List<String> content;
    private String language;
}
