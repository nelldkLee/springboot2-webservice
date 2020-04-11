package org.carpediem.site.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsModifyRequestDto {

    private String title;
    private String content;

    @Builder
    public PostsModifyRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
