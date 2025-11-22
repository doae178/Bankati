package ma.bankati.web.controllers.userController;

import jakarta.servlet.http.*;
import jakarta.servlet.*;
import java.io.IOException;
import java.util.List;
import ma.bankati.dao.userDao.IUserDao;
import ma.bankati.dao.userDao.UserDao;
import ma.bankati.model.users.ERole;
import ma.bankati.model.users.User;

public class UserController {

    private final IUserDao userDao;

    public UserController() {
        this.userDao = new UserDao();
    }

    // Afficher tous les utilisateurs
    public void showAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDao.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/admin/users.jsp").forward(req, resp);
    }

    // Afficher le formulaire d'édition d'un utilisateur
    public void editForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        User user = userDao.findById(id);

        // Si l'utilisateur n'existe pas, rediriger vers la liste des utilisateurs
        if (user == null) {
            resp.sendRedirect(req.getContextPath() + "/users");
            return;
        }

        req.setAttribute("user", user);
        req.getRequestDispatcher("/admin/editUser.jsp").forward(req, resp); // Formulaire d'édition
    }

    // Supprimer un utilisateur
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        userDao.deleteById(id);
        resp.sendRedirect(req.getContextPath() + "/users");
    }

    // Sauvegarder ou mettre à jour un utilisateur
    public void saveOrUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String idStr = req.getParameter("id");
        Long id = (idStr == null || idStr.isEmpty()) ? null : Long.parseLong(idStr);

        // Créer un utilisateur à l'aide du builder
        User user = new User.Builder()
                .id(id)
                .firstName(req.getParameter("firstName"))
                .lastName(req.getParameter("lastName"))
                .username(req.getParameter("username"))
                .password(req.getParameter("password"))
                .role(ERole.valueOf(req.getParameter("role")))
                .build();

        // Sauvegarder ou mettre à jour l'utilisateur dans la base de données
        if (id == null) {
            userDao.save(user);
        } else {
            userDao.update(user);
        }

        // Rediriger vers la page des utilisateurs
        resp.sendRedirect(req.getContextPath() + "/users");
    }
}
