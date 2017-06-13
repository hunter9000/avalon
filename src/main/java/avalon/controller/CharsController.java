package avalon.controller;

import avalon.interceptor.CharacterSheetOwnerRequired;
import avalon.model.CharModel;
import avalon.model.user.User;
import avalon.repository.CharRepository;
import avalon.repository.UserRepository;
import avalon.response.SuccessResponse;
import avalon.util.AuthUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CharsController {

    @Autowired
    private CharRepository charRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    /** get all chars for the user */
    @RequestMapping(value="/api/char/", method=RequestMethod.GET)
    public List<CharModel> getChars() {
        long userId = AuthUtils.getUserId(request);

        List<CharModel> r = charRepository.findByUserId(userId);
        return r;
    }

    /** Create a character */
    @RequestMapping(value="/api/char/", method=RequestMethod.POST)
    public SuccessResponse createChar(@RequestBody CharModel character) {
        long userId = AuthUtils.getUserId(request);

        User user = userRepository.findOne(userId);
        character.setUser(user);
        charRepository.save(character);
        return new SuccessResponse(true, "created character");
    }

    /** get the char w/ equipment, inv, etc. add charId to jwt for reuse throughout angular app */
    @RequestMapping(value="/api/char/{charId}/", method=RequestMethod.GET)
    @CharacterSheetOwnerRequired
    public CharModel getChar(@PathVariable long charId) {
//        JwtSubject token = (JwtSubject)request.getAttribute("jwtToken");
//        User user = userRepository.findOne(AuthUtils.getUserId(request));
        CharModel charModel = (CharModel)request.getAttribute(AuthUtils.CHARACTER_NAME);

//        CharModel charModel = charRepository.findById(charId);
        return charModel;
    }

    /** delete char */
    @RequestMapping(value="/api/chars/{charId}/", method=RequestMethod.DELETE)
    @CharacterSheetOwnerRequired
    public SuccessResponse deleteChar(@PathVariable long charId) {
        CharModel charModel = (CharModel)request.getAttribute(AuthUtils.CHARACTER_NAME);

        return new SuccessResponse(false, "not implemented");
    }

}
