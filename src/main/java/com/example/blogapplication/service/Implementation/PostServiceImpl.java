package com.example.blogapplication.service.Implementation;

import com.example.blogapplication.dtos.PostDto;
import com.example.blogapplication.dtos.PostPageResponse;
import com.example.blogapplication.models.Post;
import com.example.blogapplication.repositories.PostRepository;
import com.example.blogapplication.service.PostServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostServiceInterface {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {

        //1. convert Dto (postDto) into entity (Post)
        Post post = mapToEntity(postDto);

//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription()); // we have written this code in a private method below


        //2. save the entity (Post) into the database using the repository with newPost as the result
        Post newPost = postRepository.save(post);

        //3. convert the entity (newPost) into Dto (postDto) and return it to the controller
        PostDto postResponse = mapToDto(newPost);


//        PostDto postResponse = new PostDto();
//        postResponse.setId(newPost.getId());
//        postResponse.setTitle(newPost.getTitle());
//        postResponse.setContent(newPost.getContent());
//        postResponse.setDescription(newPost.getDescription()); // we have written this code in a private method below


        return postResponse;

    }



//    @Override
//    public List<PostDto> getAllPosts() {
//        // get all the posts from the database using the repository
//        List<Post> posts = postRepository.findAll();
//        // convert the list of entities (Post) into a list of Dtos (PostDto).
//        // so, we use stream method to iterate through the list of entities and convert each entity into Dto
//
//        return posts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());
//
//
//    }

    @Override
    public PostPageResponse getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();



        //create pagable instance

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<Post> posts = postRepository.findAll(pageable);

        //get content for page object
        List<Post> listOfPosts = posts.getContent();


        List<PostDto> content=  listOfPosts.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostPageResponse postPageResponse= new PostPageResponse();
        postPageResponse.setContent(content);
        postPageResponse.setPageNo(posts.getNumber());
        postPageResponse.setPageSize(posts.getSize());
        postPageResponse.setTotalPages(posts.getTotalPages());
        postPageResponse.setTotalElements(posts.getTotalElements());
        postPageResponse.setLast(posts.isLast());

        return postPageResponse;


    }




    @Override
    public PostDto getPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));
        
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Long id) {
        //get the post by id from the database using the repository
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        //update the post with the new values from the Dto
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());

        //save the updated post into the database using the repository
        Post updatedPost = postRepository.save(post);

        //convert the updated post into Dto and return it to the controller
        return mapToDto(updatedPost);

    }

    @Override
    public void deletePost(Long id) {
        //get the post by id from the database using the repository
        Post post = postRepository.findById(id).orElseThrow(() -> new RuntimeException("Post not found"));

        //delete the post from the database using the repository
        postRepository.delete(post);
    }

    //  create a method that will convert the entity (Post) into Dto (PostDto) as a Private method

    private PostDto mapToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    //  create a method that will convert the Dto (PostDto) into entity (Post) as a Private method

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }

}
