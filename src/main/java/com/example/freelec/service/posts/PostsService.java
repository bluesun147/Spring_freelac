package com.example.freelec.service.posts;

import com.example.freelec.domain.posts.Posts;
import com.example.freelec.domain.posts.PostsRepository;
import com.example.freelec.web.dto.PostsResponseDto;
import com.example.freelec.web.dto.PostsSaveRequestDto;
import com.example.freelec.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    // 등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    // 업데이트
    @Transactional // 실제 데이터 변경 시 사용 어노테이션 
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        // repository.update 하는 것이 아니라 엔티티 안에 업데이트가 있음.
        // 이렇게 짜도 된다고 함. - 백기선
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    // 조회
    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        return new PostsResponseDto(entity);
    }
}