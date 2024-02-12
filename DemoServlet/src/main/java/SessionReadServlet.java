import java.io.IOException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SessionReadServlet")
public class SessionReadServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(false); // Ne crée pas de nouvelle session si elle n'existe pas
        
        if (session != null) {
            String username = (String) session.getAttribute("username");
            String email = (String) session.getAttribute("email");
            
            response.getWriter().println("Nom d'utilisateur : " + username);
            response.getWriter().println("Email : " + email);
        } else {
            response.getWriter().println("Session introuvable");
        }
    }
}
