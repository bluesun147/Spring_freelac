package com.example.freelec.service.posts;

import com.example.freelec.domain.posts.Posts;
import com.example.freelec.domain.posts.PostsRepository;
import com.example.freelec.web.dto.PostsListResponseDto;
import com.example.freelec.web.dto.PostsResponseDto;
import com.example.freelec.web.dto.PostsSaveRequestDto;
import com.example.freelec.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    // readOnly=true 옵션 주면 트랜잭션 범위는 유지하되 조회 기능만 남겨 조회 속도 개선됨.
    // 등록, 수정, 삭제 기능 전혀 없는 서비스 메소드에서 사용하는것 추천
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAlLDesc() {
        return postsRepository.findAllDesc().stream()
                // .map(PostsListResponseDto.new) // 아래와 같은 코드
                // postRepository 결과로 넘어온 Posts의 스트림을 map을 통해 dto로 변환 -> List로 반환하는 메서드
                .map(posts -> new PostsListResponseDto(posts))
                .collect(Collectors.toList());
    }

    // 삭제
    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        postsRepository.delete(posts);
    }
}