package pl.io2.inwentaryzator.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pl.io2.inwentaryzator.worker.Worker;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class WorkerUrlAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    private Worker myWorker;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException {

        Object worker = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(worker instanceof UserDetails){
            myWorker = new Worker(((UserDetails) worker).getUsername(),
                    ((UserDetails) worker).getPassword(),
                    ((UserDetails) worker).getAuthorities().toString());
        }else {
            //To-Do
        }

        System.out.println(myWorker.getRole());
        System.out.println("ROLE_MANAGER");

        if(myWorker.getRole().equals("[ROLE_MANAGER]")){
            redirectStrategy.sendRedirect(request,response,"/manager");
        }

        if(myWorker.getRole().equals("[ROLE_WORKER]")){
            redirectStrategy.sendRedirect(request,response,"/");
        }

        if(myWorker.getRole().equals("[ROLE_OWNER]")){
            redirectStrategy.sendRedirect(request,response,"/owner");
        }

    }
}
