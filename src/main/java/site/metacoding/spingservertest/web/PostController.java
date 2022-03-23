package site.metacoding.spingservertest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice.Return;
import site.metacoding.spingservertest.domain.post.PostRepository;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostRepository postRepository;

    @GetMapping("/list")
    public String main(Model model, @RequestParam(defaultValue = "") String keyword) {

        model.addAttribute("BoardTbl", postRepository.mSearch(keyword));

        return "/post/list";
    }

}
