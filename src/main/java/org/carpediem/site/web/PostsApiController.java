package org.carpediem.site.web;

import lombok.RequiredArgsConstructor;
import org.carpediem.site.service.PostsService;
import org.carpediem.site.web.dto.PostsResponseDto;
import org.carpediem.site.web.dto.PostsSaveRequestDto;
import org.carpediem.site.web.dto.PostsUpdateRequestDto;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id) {
        return postsService.findById(id);
    }

    @PostMapping("/api/v1/posts")
    public Long register(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long modify(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.modify(id, requestDto);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

}
