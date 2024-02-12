import java.io.IOException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/SessionDemoServlet")
public class SessionDemoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Créer ou récupérer une session
        HttpSession session = request.getSession(true);
        
        // Ajouter des attributs à la session
        session.setAttribute("username", "JohnDoe");
        session.setAttribute("email", "johndoe@example.com");
        
        response.getWriter().println("Données de session ajoutées avec succès");
    }
}

