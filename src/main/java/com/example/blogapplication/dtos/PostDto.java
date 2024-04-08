package com.example.blogapplication.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Data
@Schema(
        description = "PostDto Model Information"
)
public class PostDto {
    private Long id;


    // title should not be null  or empty
    // title should have at least 2 characters
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters")
    @Schema(
            description = "Blog Post Title"
    )
    private String title;


    // post description should be not null or empty
    // post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")
    @Schema(
            description = "Blog Post Description"
    )
    private String description;

    // post content should be not null or empty
    @NotEmpty
    @Schema(
            description = "Blog Post Content"
    )
    private String content;



    private Set<CommentDto> comments;

    @Schema(
            description = "Blog Post Category"
    )

    private Long categoryId;


}
