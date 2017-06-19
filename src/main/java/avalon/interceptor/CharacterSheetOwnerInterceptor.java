package avalon.interceptor;

import avalon.model.CharModel;
import avalon.model.user.User;
import avalon.repository.CharRepository;
import avalon.repository.UserRepository;
import avalon.security.BadRequestException;
import avalon.security.ForbiddenAccessException;
import avalon.util.AuthUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class CharacterSheetOwnerInterceptor implements HandlerInterceptor {

    @Autowired
    private CharRepository characterSheetRepository;

    @Autowired
    private UserRepository userRepository;

    private Logger logger = Logger.getLogger(CharacterSheetOwnerInterceptor.class);

//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//        Map<String, String> pathVariables = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
//
//        Long sheetId = Long.valueOf(pathVariables.get("sheetId"));
//        if (sheetId == null) {
//            throw new BadRequestException("No sheetId parameter provided");
//        }
//        Sheet sheet = sheetRepository.findOne(sheetId);
//        if (sheet == null) {
//            throw new BadRequestException("sheetId parameter invalid");
//        }
//
//        User user = AuthUtils.getLoggedInUser(request);
//        if (!sheet.getOwner().equals(user)) {
//            throw new ForbiddenAccessException();
//        }
//
//        // check if the sheet is in the required steps, if any
//        if (sheetOwnerAnnotation.requiredSteps().length > 0 && !ArrayUtils.contains(sheetOwnerAnnotation.requiredSteps(), sheet.getCreationStep())) {
//            throw new BadRequestException("Sheet is not in the required creation step to make this call. Required: " + ArrayUtils.toString(sheetOwnerAnnotation.requiredSteps()) + ", currently: " + sheet.getCreationStep());
//        }
//
//        request.setAttribute(AuthUtils.SHEET, sheet);
//        return true;
//    }

    /** Validates that the character being requested is owned by the logged in user. Only applies if the @CharacterSheetOwnerRequired annotation is on the method */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // check the annotation on the handler method. if @CharacterSheetOwnerRequired isn't present, return true
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CharacterSheetOwnerRequired characterSheetOwnerRequired = handlerMethod.getMethod().getAnnotation(CharacterSheetOwnerRequired.class);
        if (characterSheetOwnerRequired == null) {
            return true;
        }

        logger.debug("prehandling CharacterSheetOwnerInterceptor");

        Map<String, String> pathVariables = (Map<String, String>)request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        Long charId = Long.valueOf(pathVariables.get("charId"));
        if (charId == null) {
            throw new BadRequestException("No charId parameter provided");
        }
        CharModel charModel = characterSheetRepository.findOne(charId);
        if (charModel == null) {
            throw new BadRequestException("charId parameter invalid");
        }


        User user = AuthUtils.getLoggedInUser(request);
        if (!charModel.getUser().getId().equals(user.getId())) {
            logger.error("user doesn't match: " + charModel.getUser() + " " + user);
            throw new ForbiddenAccessException();
        }

        // store charsheet in request so controllers can access it without looking up again
        request.setAttribute(AuthUtils.CHARACTER, charModel);
        return true;
    }

//    private String parseCharId(String uri) {
//        if (uri.startsWith("/api/char/")) {
//            String[] parts = uri.split("/");
//            return parts[3];
//        }
//        else {
//            return null;
//        }
//    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
