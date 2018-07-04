package com.saoah.envers.audit.auditor;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import com.saoah.envers.exceptions.MissingUsernameException;

/**
 * class implement {@link AuditorAware} interface for providing the username at runtime
 */
@Component
public class DefaultAuditorAware implements AuditorAware<String> {

    private String systemUsername = "system", username;

    @Override
    public String getCurrentAuditor() {
        try {
            // for web app usage
            username = (String) RequestContextHolder.currentRequestAttributes()
                    .getAttribute("username", RequestAttributes.SCOPE_REQUEST);
        } catch (Exception e) {
            // Spring Security
            final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated())
                username = authentication.getName();
        } finally {
            if (username == null || username.isEmpty()) {
                username = systemUsername;
            }
        }

        if (username == null)
            handleError();

//        LOGGER.info(String.format("Current auditor is >>> %s", username));
        return username;
    }

    public void handleError() {
        throw new MissingUsernameException("Request is missing a Username");
    }
}
